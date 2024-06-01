package tech.lbllol365.myagent.llm.tools;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.agent.tool.ToolSpecification;
import dev.langchain4j.agent.tool.ToolSpecifications;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherToolTest {

    @Autowired
    private WeatherTool weatherTool;
    interface Assistant {

        String chat(String userMessage);
    }
    @Test
    void getWeather() {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1",1081));
        Assistant assistant = AiServices.builder(Assistant.class)
                // WARNING! "demo" key does not support tools
                .chatLanguageModel(OpenAiChatModel.builder().proxy(proxy).apiKey("YOUR KEY").build())
                .tools(weatherTool)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();

        String question = "北京市朝阳区的天气怎么样";
        String answer = assistant.chat(question);
        System.out.println(answer);
    }
}
