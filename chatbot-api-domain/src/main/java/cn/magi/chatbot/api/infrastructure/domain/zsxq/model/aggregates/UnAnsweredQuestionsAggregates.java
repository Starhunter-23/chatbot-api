package cn.magi.chatbot.api.infrastructure.domain.zsxq.model.aggregates;

import cn.magi.chatbot.api.infrastructure.domain.zsxq.model.res.RespData;

/**
 * @ClassName UnAnsweredQuestionsAggregates
 * @Description TODO
 * @Author 百里诀
 * @Date 2023/3/24 10:36
 * @Version 1.0
 */

public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;
    private RespData resp_data;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public RespData getResp_data() {
        return resp_data;
    }

    public void setResp_data(RespData resp_data) {
        this.resp_data = resp_data;
    }
}
