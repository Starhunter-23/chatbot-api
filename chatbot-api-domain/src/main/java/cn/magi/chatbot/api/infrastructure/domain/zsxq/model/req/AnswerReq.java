package cn.magi.chatbot.api.infrastructure.domain.zsxq.model.req;

/**
 * @ClassName AnswerReq
 * @Description TODO
 * @Author 百里诀
 * @Date 2023/3/23 11:34
 * @Version 1.0
 */

public class AnswerReq {
    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }
}
