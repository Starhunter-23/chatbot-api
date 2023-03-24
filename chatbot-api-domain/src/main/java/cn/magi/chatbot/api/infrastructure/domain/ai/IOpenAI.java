package cn.magi.chatbot.api.infrastructure.domain.ai;

import java.io.IOException;

public interface IOpenAI {

    String doChatGPT(String question) throws IOException;
}
