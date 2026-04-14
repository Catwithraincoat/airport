package com.example.airport.controller;

import com.example.airport.entity.AircraftEntity;
import com.example.airport.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/aircrafts")
@RequiredArgsConstructor
public class AircraftController {
    private final AircraftService aircraftService;
    // Контроллер для поиска с фильтрами

    @GetMapping("/{code}")
    public AircraftEntity getById(@PathVariable String code){
        return aircraftService.getAircraftById(code);
    }

    @GetMapping
    public List<AircraftEntity> getAllAircrafts() {
        return aircraftService.getAll();
    }

    @PostMapping
    public AircraftEntity createAircraft(@RequestBody AircraftEntity aircraftEntity){
        return aircraftService.saveAircraft(aircraftEntity);
    }

    @PutMapping("/{code}")
    public AircraftEntity updateAircraft(@PathVariable String code, @RequestBody AircraftEntity aircraftEntity){
        return aircraftService.updateAircraft(code, aircraftEntity);
    }
    //Для удлание физическое и логическое - передача флага
    @DeleteMapping("/{code}")
    public void deleteAircraft(@PathVariable String code){
        aircraftService.deleteAircraft(code);
    }



}
