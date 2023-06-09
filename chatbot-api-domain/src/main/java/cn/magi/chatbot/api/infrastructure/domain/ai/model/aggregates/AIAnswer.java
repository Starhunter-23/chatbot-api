package cn.magi.chatbot.api.infrastructure.domain.ai.model.aggregates;

import cn.magi.chatbot.api.infrastructure.domain.ai.model.vo.Choices;

import java.util.List;

/**
 * @ClassName AIAnswer
 * @Description TODO
 * @Author 百里诀
 * @Date 2023/3/24 16:15
 * @Version 1.0
 */

public class AIAnswer {
    private String id;

    private String object;

    private int created;

    private String model;

    private List<Choices> choices;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setObject(String object){
        this.object = object;
    }
    public String getObject(){
        return this.object;
    }
    public void setCreated(int created){
        this.created = created;
    }
    public int getCreated(){
        return this.created;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }
    public void setChoices(List<Choices> choices){
        this.choices = choices;
    }
    public List<Choices> getChoices(){
        return this.choices;
    }
}
