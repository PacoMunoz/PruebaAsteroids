package com.atmira.prueba.web.controller;


import com.atmira.prueba.services.NasaService;
import com.atmira.prueba.web.model.AsteroidDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("api/v1/asteroids")
@RestController
@Validated
public class AsteroidController {

    private NasaService nasaService;

    public AsteroidController(NasaService nasaService) {
        this.nasaService = nasaService;
    }

    @GetMapping()
    public ResponseEntity<List<AsteroidDTO>> getAsteroids(@RequestParam @Min(1) @Max(7) @NotBlank String days) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();

        String initDate = simpleDateFormat.format(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, Integer.parseInt(days));
        String endDate = simpleDateFormat.format(calendar.getTime());

        return new ResponseEntity<>(nasaService.getTopBigestPotentiallyHazardousAsteroids(initDate, endDate), HttpStatus.OK);
    }
}
