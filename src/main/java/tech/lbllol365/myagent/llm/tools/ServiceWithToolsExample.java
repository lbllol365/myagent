package tech.lbllol365.myagent.llm.tools;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class ServiceWithToolsExample {

    // Please also check CustomerSupportApplication and CustomerSupportApplicationTest
    // from spring-boot-example module

    static class Calculator {

        @Tool("Calculates the length of a string")
        int stringLength(String s) {
            System.out.println("Called stringLength with s='" + s + "'");
            return s.length();
        }

        @Tool("Calculates the sum of two numbers")
        int add(int a, int b) {
            System.out.println("Called add with a=" + a + ", b=" + b);
            return a + b;
        }

        @Tool("Calculates the square root of a number")
        double sqrt(int x) {
            System.out.println("Called sqrt with x=" + x);
            return Math.sqrt(x);
        }
    }

    interface Assistant {

        String chat(String userMessage);
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1",1081));
        Assistant assistant = AiServices.builder(Assistant.class)
                // WARNING! "demo" key does not support tools
                .chatLanguageModel(OpenAiChatModel.builder().proxy(proxy).apiKey("YOUR KEY").build())
                .tools(new WeatherTool())
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();

        String question = "明天北京市海淀区彩和坊路海淀西大街74号的天气怎么样?";

        String answer = assistant.chat(question);

        System.out.println(answer);
        // The square root of the sum of the number of letters in the words "hello" and "world" is approximately 3.162.
    }
}
