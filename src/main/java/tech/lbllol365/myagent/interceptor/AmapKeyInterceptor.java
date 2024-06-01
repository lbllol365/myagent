package tech.lbllol365.myagent.interceptor;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.interceptor.Interceptor;
import tech.lbllol365.myagent.constant.AmapAPIConstant;

public class AmapKeyInterceptor<T> implements Interceptor<T> {

    @Override
    public boolean beforeExecute(ForestRequest req) {
        req.addQuery("key", AmapAPIConstant.AMAP_API_KEY);
        return true;
    }
}
