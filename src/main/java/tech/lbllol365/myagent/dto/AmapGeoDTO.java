package tech.lbllol365.myagent.dto;

import lombok.Data;

import java.util.List;

/**
 * 高德地图地理编码DTO
 * */

@Data
public class AmapGeoDTO {
    /**
     * 返回值为 0 或 1，0 表示请求失败；1 表示请求成功。
     * */
    private Integer status;

    /**
     * 当 status 为 0 时，info 会返回具体错误原因，否则返回“OK”
     * */
    private String info;

    /**
     * 返回结果的个数。
     * */
    private Integer count;

    private List<GeoCode> geocodes;

}

