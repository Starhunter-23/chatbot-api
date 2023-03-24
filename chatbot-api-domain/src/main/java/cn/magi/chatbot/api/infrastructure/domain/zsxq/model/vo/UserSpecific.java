package cn.magi.chatbot.api.infrastructure.domain.zsxq.model.vo;

/**
 * @ClassName UserSpecific
 * @Description TODO
 * @Author 百里诀
 * @Date 2023/3/23 11:33
 * @Version 1.0
 */

public class UserSpecific {
    private boolean liked;

    private boolean subscribed;

    public void setLiked(boolean liked){
        this.liked = liked;
    }
    public boolean getLiked(){
        return this.liked;
    }
    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }
    public boolean getSubscribed(){
        return this.subscribed;
    }
}
