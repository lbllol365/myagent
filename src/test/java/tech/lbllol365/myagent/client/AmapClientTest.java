package tech.lbllol365.myagent.client;

import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.lbllol365.myagent.dto.AmapGeoDTO;
import tech.lbllol365.myagent.dto.AmapWeatherDTO;

@SpringBootTest
class AmapClientTest {

    @Autowired
    private AmapClient amapClient;

    @Test
    public void testGeoregeo() {
        String address = "北京市朝阳区";
        String city = "北京";
        AmapGeoDTO geoInfo = amapClient.getGeoInfo(address, city);
        System.out.println(JSON.toJSONString(geoInfo));
    }

    @Test
    public void testWeather() {
        String city = "110105";
        AmapWeatherDTO weatherInfo = amapClient.getWeatherInfo(city);
        System.out.println(JSON.toJSONString(weatherInfo));
    }
}
