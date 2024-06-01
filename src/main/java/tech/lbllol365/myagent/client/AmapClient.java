package tech.lbllol365.myagent.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import tech.lbllol365.myagent.constant.AmapAPIConstant;
import tech.lbllol365.myagent.dto.AmapGeoDTO;
import tech.lbllol365.myagent.dto.AmapWeatherDTO;
import tech.lbllol365.myagent.interceptor.AmapKeyInterceptor;

@BaseRequest(interceptor = AmapKeyInterceptor.class)
public interface AmapClient {

    @Get(url = AmapAPIConstant.GEO_REGEO_API)
    AmapGeoDTO getGeoInfo(@Query("address") String address, @Query("address") String city);

    @Get(url = AmapAPIConstant.WEATHER_LIVE_API)
    AmapWeatherDTO getWeatherInfo(@Query("city") String city);
}
