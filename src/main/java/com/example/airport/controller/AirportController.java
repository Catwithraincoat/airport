package com.example.airport.controller;

import com.example.airport.entity.AirportEntity;
import com.example.airport.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/airports")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @GetMapping("/{code}")
    public AirportEntity getById(@PathVariable String code){
        return airportService.getById(code);
    }

    @GetMapping
    public List<AirportEntity> getAllAirports() {
        return airportService.getAll();
    }

    @PostMapping
    public AirportEntity createAirport(@RequestBody AirportEntity airport){
        return airportService.saveAirport(airport);
    }

    @PutMapping("/{code}")
    public AirportEntity updateAirport(@PathVariable String code, @RequestBody AirportEntity airport){
        return airportService.updateAirport(code, airport);
    }

    @DeleteMapping("/{code}")
    public void deleteAirport(@PathVariable String code){
        airportService.deleteAirport(code);
    }
}
