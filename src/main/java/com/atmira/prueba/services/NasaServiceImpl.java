package com.atmira.prueba.services;

import com.atmira.prueba.web.client.NasaClient;
import com.atmira.prueba.web.model.AsteroidDTO;
import com.atmira.prueba.web.model.NasaObjectResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class NasaServiceImpl implements NasaService {

    private NasaClient nasaClient;

    public NasaServiceImpl(NasaClient nasaClient) {
        this.nasaClient = nasaClient;
    }

    @Override
    public List<AsteroidDTO> getTopBigestPotentiallyHazardousAsteroids() throws JSONException, JsonProcessingException {

        //LinkedHashMap objeteos = nasaClient.getData("2021-12-09", "2021-12-12", "zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb");

        LinkedHashMap response = nasaClient.getData("2021-12-09", "2021-12-12", "zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb");

        /*ResponseEntity<NasaObjectResponse> rateResponse =
                restTemplate.exchange("https://bitpay.com/api/rates",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Rate>>() {
                        });*/

        LinkedHashMap ob = (LinkedHashMap) response.get("near_earth_objects");
        ob.forEach((key, value) -> {
            ((List<LinkedHashMap>)value).forEach((key1) -> {
                if ((boolean)key1.get("is_potentially_hazardous_asteroid") == true){

                    AsteroidDTO asteroidDTO = new AsteroidDTO();

                    Double min = (Double) ((LinkedHashMap)((LinkedHashMap) key1.get("estimated_diameter")).get("kilometers")).get("estimated_diameter_min");
                    Double max = (Double) ((LinkedHashMap)((LinkedHashMap) key1.get("estimated_diameter")).get("kilometers")).get("estimated_diameter_max") ;

                    asteroidDTO.setFecha(((LinkedHashMap)((ArrayList)key1.get("close_approach_data")).get(0)).get("close_approach_date").toString());
                    asteroidDTO.setPlaneta(((LinkedHashMap)((ArrayList) key1.get("close_approach_data")).get(0)).get("orbiting_body").toString());
                    asteroidDTO.setDiametro((max + min) / 2);
                    asteroidDTO.setNombre(key1.get("name").toString());

                    System.out.println(asteroidDTO.toString());

                }
            });
        });

        return null;
    }
}
