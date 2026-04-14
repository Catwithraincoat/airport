package com.example.airport.controller;


import com.example.airport.entity.FlightEntity;
import com.example.airport.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping
    public List<FlightEntity> getAll() {
        return flightService.getAll();
    }

    @GetMapping("/{id}")
    public FlightEntity getById(@PathVariable Integer id) {
        return flightService.getById(id);
    }

    @PostMapping
    public FlightEntity create(@RequestBody FlightEntity flightEntity) {
        return flightService.create(flightEntity);
    }

    @PutMapping("/{id}")
    public FlightEntity updateFlight(@PathVariable Integer id, @RequestBody FlightEntity flightEntity){
        return flightService.updateFlight(id, flightEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        flightService.delete(id);
    }

}
