package com.atmira.prueba.services;

import com.atmira.prueba.web.model.AsteroidDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.util.List;

public interface NasaService {

    List<AsteroidDTO> getTopBigestPotentiallyHazardousAsteroids() throws JSONException, JsonProcessingException;
}
