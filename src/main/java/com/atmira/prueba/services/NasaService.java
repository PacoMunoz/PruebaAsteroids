package com.atmira.prueba.services;

import com.atmira.prueba.web.model.AsteroidDTO;
import java.util.List;

public interface NasaService {
    List<AsteroidDTO> getTopBigestPotentiallyHazardousAsteroids(String initDate, String endDate);
}
