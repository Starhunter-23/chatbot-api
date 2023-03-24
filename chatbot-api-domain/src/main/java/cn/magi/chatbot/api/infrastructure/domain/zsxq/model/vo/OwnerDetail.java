package cn.magi.chatbot.api.infrastructure.domain.zsxq.model.vo;

/**
 * @ClassName OwnerDetail
 * @Description TODO
 * @Author 百里诀
 * @Date 2023/3/23 10:56
 * @Version 1.0
 */

public class OwnerDetail {

    private int questions_count;

    private String join_time;

    public int getQuestions_count() {
        return questions_count;
    }

    public void setQuestions_count(int questions_count) {
        this.questions_count = questions_count;
    }

    public String getJoin_time() {
        return join_time;
    }

    public void setJoin_time(String join_time) {
        this.join_time = join_time;
    }
}
