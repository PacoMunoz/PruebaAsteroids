package com.atmira.prueba.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Component
@ConfigurationProperties(value = "atmira.prueba", ignoreUnknownFields = false)
public class NasaClient {

    public final String NASA_API_V1 = "/neo/rest/v1/feed";
    private String apihost;
    private String key;
    private final RestTemplate restTemplate;

    public NasaClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public LinkedHashMap getData(String startDate, String endDate) {

        ResponseEntity<LinkedHashMap> result = restTemplate
                .getForEntity(apihost + NASA_API_V1 + "?start_date=" + startDate + "&end_date=" + endDate + "&api_key=" + key
                , LinkedHashMap.class);

        return result.getBody();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
    public void setKey(String key) { this.key = key; }
}

