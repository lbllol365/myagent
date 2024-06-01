package tech.lbllol365.myagent.dto;


import lombok.Data;

@Data
public class GeoCode {

    private String country;

    private String formattedAddress;

    private String province;

    private String city;

    private Integer citycode;

    private String district;

    private String township;

    private String street;

    private String number;

    /**
     * 地理编码
     * */
    private String adcode;

    private String location;

    private String level;

}
