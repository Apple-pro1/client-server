package com.Nathan.springboottutorial.dto;

import com.Nathan.springboottutorial.component.WeatherAPIClient;
import com.Nathan.springboottutorial.type.WeatherTypeEnum;
import lombok.Data;

import java.util.List;
@Data
public class WeatherDto {
    private WeatherDtoResponse response;

    @Data
    public static class WeatherDtoResponse {
        private WeatherDtoHeader header;
        private WeatherDtoBody body;

    }
    @Data
    public static class WeatherDtoHeader {
        private String resultCode;
        private String resultMsg;
    }
    @Data
    public static class WeatherDtoBody {
        private String dataType;
        private int pageNo;
        private int numOfRows;
        private int totalCount;
        private itemList items;

    }
    @Data
    public static class itemList {
        private List<WeatherItem> item;

    }

    @Data
    public static class WeatherItem {
        private String baseDate;
        private String baseTime;
        private String category;
        private int nx;
        private int ny;
        private String obsrValue;
    }

    public double getTemperature() {
        List<WeatherItem> item = this.getResponse().getBody().getItems().getItem();
        for (WeatherItem elem: item) {
            String category = elem.getCategory();
            if (category.equals("T1H")) {
                return Double.parseDouble(
                        elem.getObsrValue()
                );
            }

        }
        return 0.0f;
    }

    public WeatherTypeEnum getWeatherType() {
        int rn1 = 0;
        List<WeatherItem> item = this.getResponse().getBody().getItems().getItem();
        for (WeatherItem elem: item) {
            String category = elem.getCategory();
            if (category.equals("RN1")) {
                rn1 = Integer.parseInt(elem.getObsrValue());
                break;
            }

        }
        if (rn1 > 0) {
            return WeatherTypeEnum.RAINY;
        }

        int sky = 0;
        for (WeatherItem elem: item) {
            String category = elem.getCategory();
            if (category.equals("SKY")) {
                rn1 = Integer.parseInt(elem.getObsrValue());
                break;
            }

        }

        switch (sky) {
            case 1:
                return WeatherTypeEnum.SUNNY;
            case 2:
            case 3:
            default:
                return WeatherTypeEnum.CLOUDY;
        }
    }
}
