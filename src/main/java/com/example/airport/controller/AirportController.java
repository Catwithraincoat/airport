package com.example.airport.controller;

import com.example.airport.model.Airport;
import com.example.airport.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {
    private AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;}

    @GetMapping("/{code}")
    public Airport getById(@PathVariable String code){
        return airportService.getById(code);
    }

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAll();
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport){
        return airportService.saveAirport(airport);
    }

    @PutMapping("/{code}")
    public Airport updateAirport(@PathVariable String code, @RequestBody Airport airport){
        return airportService.updateAirport(code, airport);
    }

    @DeleteMapping("/{code}")
    public void deleteAirport(@PathVariable String code){
        airportService.deleteAirport(code);
    }
}
