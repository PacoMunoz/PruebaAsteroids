package com.atmira.prueba.web.client;

import com.atmira.prueba.web.model.NasaObjectResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.*;

@Component
@ConfigurationProperties(value = "atmira.prueba", ignoreUnknownFields = false)
public class NasaClient {

    public final String NASA_API_V1 = "/neo/rest/v1/feed";
    private String apihost;
    private final RestTemplate restTemplate;

    public NasaClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public LinkedHashMap getData(String startDate, String endDate, String apiKey) throws JSONException, JsonProcessingException {
        /*return restTemplate.getForObject(apihost + NASA_API_V1 + "?start_date={start}&end_date={end}&api_key={key}"
                , String.class, startDate, endDate, apiKey );*/
       /* String json = restTemplate.getForObject(apihost + NASA_API_V1 + "?start_date=2021-12-09&end_date=2021-12-12&api_key=zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb"
                , String.class);

        JSONObject obj = new JSONObject(json);
        String pageName = obj.getJSONObject("links").getString("next");
        JSONObject element = obj.getJSONObject("near_earth_objects");

        ObjectMapper mapper = new ObjectMapper();

element.getJSONObject("value");

         JSONArray arr = new JSONArray();
         Map ma = mapper.readValue(element.toString(), Map.class);

         ma.forEach( (key, value) -> {

         });*/
        /*ResponseEntity<NasaObjectResponse[]> rateResponse =
                restTemplate.exchange("https://bitpay.com/api/rates",
                        HttpMethod.GET, null, new ParameterizedTypeReference<NasaObjectResponse[]>() {
                        });

        return rateResponse.getBody();*/


        ResponseEntity<LinkedHashMap> result = restTemplate.getForEntity(apihost + NASA_API_V1 + "?start_date=2021-12-09&end_date=2021-12-12&api_key=zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb"
                , LinkedHashMap.class);
        return result.getBody();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}

