package cn.zuoye.chat;


import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
@Service
public class Responder {
    @Value("${openai.api.key}")
    private String apiKey;
    private OpenAiService service;
    private static Logger logger = LoggerFactory.getLogger(Responder.class);

    /**
     * Construct a Responder
     */
    public Responder()
    {

    }





    /**
     * 异步调用openai api得到回答的内容
     * @param inputContent
     * @return
     */
    public String generateResponse(String inputContent) {
        System.setProperty("proxyHost", "127.0.0.1"); // 代理的IP地址
        System.setProperty("proxyPort", "10809"); // 代理的端口号
        if(service == null) {
            service = new OpenAiService(apiKey);
        }
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), inputContent);
        messages.add(systemMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(1)
                .maxTokens(500)
                .logitBias(new HashMap<>())
                .build();
        StringBuffer sb = new StringBuffer();

        service.createChatCompletion(chatCompletionRequest)
                .getChoices().forEach(choice -> {
                    sb.append(choice.getMessage().getContent());
                });

        return sb.toString();
    }

}
