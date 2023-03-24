package cn.magi.chatbot.api.infrastructure;

import cn.magi.chatbot.api.infrastructure.domain.ai.IOpenAI;
import cn.magi.chatbot.api.infrastructure.domain.zsxq.IZsxqApi;
import cn.magi.chatbot.api.infrastructure.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import cn.magi.chatbot.api.infrastructure.domain.zsxq.model.vo.Question;
import cn.magi.chatbot.api.infrastructure.domain.zsxq.model.vo.Topics;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName SpringBootRunTest
 * @Description TODO
 * @Author 百里诀
 * @Date 2023/3/24 10:58
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {
    private Logger logger = LoggerFactory.getLogger(SpringBootTest.class);

    @Value("${chatbot-api.groupId}")
    private String groupId;

    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IOpenAI openAI;

    @Test
    public void test_zsxqApi() throws IOException
    {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId,cookie);
        logger.info("测试结果:{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        System.out.println(topics);
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            logger.info("topicId:{} text: {}",topicId,text);

        }
    }

    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://open.aiproxy.xyz/v1/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer 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");
        String paramJson = "{\"model\":\"text-davinci-003\",\"prompt\":\"帮我写一个java冒泡排序\",\"temperature\":0,\"max_tokens\":1024}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "utf-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void test_openAi() throws IOException
    {
        String response = openAI.doChatGPT("帮我用java写快速排序");
        logger.info("测试结果:{}",response);
    }
}
