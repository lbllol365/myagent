package tech.lbllol365.myagent.service;

public interface WeatherService {

    /**
     * 通过详细地址获取天气
     * */
    String getWeatherByAddress(String address);
}
