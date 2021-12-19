package com.atmira.prueba.services;


import com.atmira.prueba.web.client.NasaClient;
import com.atmira.prueba.web.model.AsteroidDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class NasaServiceImpl implements NasaService {

    private NasaClient nasaClient;

    public NasaServiceImpl(NasaClient nasaClient) {
        this.nasaClient = nasaClient;
    }

    @Override
    public List<AsteroidDTO> getTopBigestPotentiallyHazardousAsteroids(String initDate, String endDate) {
        LinkedHashMap response = nasaClient.getData(initDate, endDate);

        return parseResponse(response);
    }

    private List<AsteroidDTO> parseResponse(LinkedHashMap response) {
        List<AsteroidDTO> parserResponse = new ArrayList<>();

        LinkedHashMap ob = (LinkedHashMap) response.get("near_earth_objects");
        ob.forEach((key, value) -> {
            ((List<LinkedHashMap>)value).forEach((key1) -> {
                if ((boolean)key1.get("is_potentially_hazardous_asteroid") == true){
                    AsteroidDTO asteroidDTO = new AsteroidDTO();

                    Double min = (Double) ((LinkedHashMap)((LinkedHashMap) key1.get("estimated_diameter")).get("kilometers")).get("estimated_diameter_min");
                    Double max = (Double) ((LinkedHashMap)((LinkedHashMap) key1.get("estimated_diameter")).get("kilometers")).get("estimated_diameter_max") ;

                    asteroidDTO.setFecha(((LinkedHashMap)((ArrayList) key1
                            .get("close_approach_data"))
                            .get(0)).get("close_approach_date").toString());
                    asteroidDTO.setPlaneta(((LinkedHashMap)((ArrayList) key1
                            .get("close_approach_data")).get(0))
                            .get("orbiting_body").toString());
                    asteroidDTO.setVelocidad(((LinkedHashMap)((LinkedHashMap)((ArrayList) key1
                            .get("close_approach_data"))
                            .get(0))
                            .get("relative_velocity"))
                            .get("kilometers_per_hour").toString());
                    asteroidDTO.setDiametro((max + min) / 2);
                    asteroidDTO.setNombre(key1.get("name").toString());

                    parserResponse.add(asteroidDTO);
                }
            });
        });

        return parserResponse;
    }
}
