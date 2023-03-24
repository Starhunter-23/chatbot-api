package cn.magi.chatbot.api.infrastructure.domain.zsxq.model.res;

import cn.magi.chatbot.api.infrastructure.domain.zsxq.model.vo.Topics;

import java.util.List;

/**
 * @ClassName RespData
 * @Description TODO
 * @Author 百里诀
 * @Date 2023/3/24 10:36
 * @Version 1.0
 */

public class RespData {
    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }
}
