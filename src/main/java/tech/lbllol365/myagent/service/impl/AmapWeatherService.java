package tech.lbllol365.myagent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.lbllol365.myagent.client.AmapClient;
import tech.lbllol365.myagent.dto.AmapGeoDTO;
import tech.lbllol365.myagent.dto.AmapWeatherDTO;
import tech.lbllol365.myagent.service.WeatherService;

@Service
public class AmapWeatherService implements WeatherService {

    @Autowired
    private AmapClient amapClient;
    @Override
    public String getWeatherByAddress(String address) {
        AmapGeoDTO geoInfo = amapClient.getGeoInfo(address, "北京");
        AmapWeatherDTO weatherInfo = amapClient.getWeatherInfo(geoInfo.getGeocodes().getFirst().getAdcode());
        StringBuilder sb = new StringBuilder();
        return sb.append(address).append("的天气是").append(weatherInfo.getLives().getFirst().getWeather()).append("，温度是").append(weatherInfo.getLives().getFirst().getTemperature()).append("度").toString();
    }
}
