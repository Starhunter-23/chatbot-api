package cn.magi.chatbot.api.infrastructure.application.job;

import cn.magi.chatbot.api.infrastructure.domain.ai.IOpenAI;
import cn.magi.chatbot.api.infrastructure.domain.zsxq.IZsxqApi;
import cn.magi.chatbot.api.infrastructure.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import cn.magi.chatbot.api.infrastructure.domain.zsxq.model.vo.Topics;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * @ClassName ChatbotSchedule
 * @Description 问题任务
 * @Author 百里诀
 * @Date 2023/3/24 16:38
 * @Version 1.0
 */

@EnableScheduling
@Configuration
public class ChatbotSchedule {

    private Logger logger = LoggerFactory.getLogger(ChatbotSchedule.class);

    @Value("${chatbot-api.groupId}")
    private String groupId;

    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IOpenAI openAI;

    // 表达式网站：cron.qqe2.com
    @Scheduled(cron = "0/45  * * * * ?")
    public void run() {
        try {
            if (new Random().nextBoolean()) {
                logger.info("{随机打烊中...}");
                return;
            }

            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if (hour > 22 || hour < 7) {
                logger.info("{打烊时间不工作，AI 下班了！}");
                return;
            }
            try {
                //1.检索问题
                UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
                logger.info("测试结果:{}", JSON.toJSONString(unAnsweredQuestionsAggregates));
                List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
                if (null == topics || topics.isEmpty()) {
                    logger.info("本次检索未查询到待会回答问题");
                    return;
                }

                //2.AI回答
                Topics topic = topics.get(0);
                String answer = openAI.doChatGPT(topic.getQuestion().getText().trim());

                //3.问题回写
                boolean status = zsxqApi.answer(groupId, cookie, topic.getTopic_id(), answer, false);
                logger.info("编号：{} 问题：{} 回答：{} 状态：{}", topic.getTopic_id(), topic.getQuestion().getText(), answer, status);
            } catch (Exception e) {
                logger.error("自动回答问题异常", e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
