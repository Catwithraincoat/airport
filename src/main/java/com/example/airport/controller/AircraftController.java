package com.example.airport.controller;

import com.example.airport.model.Aircraft;
import com.example.airport.model.Airport;
import com.example.airport.service.AircraftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircrafts")
public class AircraftController {
    private AircraftService aircraftService;
    // Контроллер для поиска с фильтрами
    public AircraftController(AircraftService aircraftService){
        this.aircraftService = aircraftService;
    }

    @GetMapping("/{code}")
    public Aircraft getById(@PathVariable String code){
        return aircraftService.getAircraftById(code);
    }

    @GetMapping
    public List<Aircraft> getAllAircrafts() {
        return aircraftService.getAll();
    }

    @PostMapping
    public Aircraft createAircraft(@RequestBody Aircraft aircraft){
        return aircraftService.saveAircraft(aircraft);
    }

    @PutMapping("/{code}")
    public Aircraft putAircraft(@PathVariable String code, @RequestBody Aircraft aircraft){
        return aircraftService.updateAircraft(code, aircraft);
    }
    //Для удлание физическое и логическое - передача флага
    @DeleteMapping("/{code}")
    public void deleteAircraft(@PathVariable String code){
        aircraftService.deleteAircraft(code);
    }



}
