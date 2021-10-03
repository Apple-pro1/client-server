package com.Nathan.springboottutorial.component;


import com.Nathan.springboottutorial.dto.WeatherDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class WeatherAPIClient {
    private static final String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
    private static final String SERVICE_KEY = "BeKyRI2Tn9petRnTzDPdYTU8x0BIJxe5RewzNeYd401Hf42BmLs2b2yk67FKIrKKFI2kjb4FdBd%2FaXkICs5Lcw%3D%3D";


    private LocalDateTime getCurrentDataTime() {
        return LocalDateTime.now();

    }


    @SneakyThrows
    public WeatherDto convert(String weatherApiResponseJsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherDto weatherDto = objectMapper.readValue(weatherApiResponseJsonString, WeatherDto.class);

        return weatherDto;
    }

    public WeatherDto getWeather() {
        String weatherInfoJson = null;
        try {
            weatherInfoJson = getWeatherInfoJson();
        } catch (IOException e) {
            log.error("error occurred while calling getWeatherInfoJson");
            return null;
        }
        return convert(weatherInfoJson);
    }



    public String getWeatherInfoJson() throws IOException {
        String jsonString = "";
        LocalDateTime currentDateTime = getCurrentDataTime();
        currentDateTime= currentDateTime.minusHours(1);
        DateTimeFormatter dateStringFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter timeStringFormatter = DateTimeFormatter.ofPattern("HH" + "00");
        String dateString = currentDateTime.format(dateStringFormatter);
        String timeString = currentDateTime.format(timeStringFormatter);
        System.out.println("dateString = " + dateString);
        System.out.println("timeString = " + timeString);




        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + SERVICE_KEY); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(dateString, "UTF-8")); /*‘21년 6월 28일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(timeString, "UTF-8")); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("55", "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*예보지점의 Y 좌표값*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        jsonString = sb.toString();

        return jsonString;
    }
}


