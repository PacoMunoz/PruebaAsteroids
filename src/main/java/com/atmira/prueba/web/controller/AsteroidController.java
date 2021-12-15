package com.atmira.prueba.web.controller;

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
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/asteroids")
@RestController
@Validated
public class AsteroidController {

    @GetMapping()
    public ResponseEntity<List<AsteroidDTO>> getAsteroids(@RequestParam @Min(1) @Max(7) @NotBlank String days) {
        List<AsteroidDTO> result = new ArrayList<>();
        result.add(AsteroidDTO.builder()
                .diametro(12.12)
                .nombre("prueba")
                .planeta("peube")
                .fecha("2021-12-12")
                .velocidad(12221.1212)
                .build());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
