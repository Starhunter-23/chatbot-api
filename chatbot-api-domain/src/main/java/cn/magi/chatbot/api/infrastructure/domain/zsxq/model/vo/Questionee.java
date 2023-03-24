package cn.magi.chatbot.api.infrastructure.domain.zsxq.model.vo;

/**
 * @ClassName Questionee
 * @Description TODO
 * @Author 百里诀
 * @Date 2023/3/23 10:55
 * @Version 1.0
 */

public class Questionee {

    private String user_id;

    private String name;

    private String avatar_url;

    private String description;

    private String location;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
