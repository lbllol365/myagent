package tech.lbllol365.myagent.llm.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.lbllol365.myagent.service.WeatherService;

@Component
public class WeatherTool {

    @Autowired
    private WeatherService weatherService;

    @Tool("return the weather of the given address")
    public String getWeather(@P("the address for which the weather forecast should be returned") String address) {
        return weatherService.getWeatherByAddress(address);
    }
}
