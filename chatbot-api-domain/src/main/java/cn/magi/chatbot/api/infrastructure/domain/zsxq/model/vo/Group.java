package cn.magi.chatbot.api.infrastructure.domain.zsxq.model.vo;

/**
 * @ClassName Group
 * @Description TODO
 * @Author 百里诀
 * @Date 2023/3/23 10:52
 * @Version 1.0
 */

public class Group {

    private String group_id;

    private String name;

    private String type;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
