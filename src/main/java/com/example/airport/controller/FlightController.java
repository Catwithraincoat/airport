package com.example.airport.controller;

import com.example.airport.model.Airport;
import com.example.airport.model.Flight;
import com.example.airport.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAll() {
        return flightService.getAll();
    }

    @GetMapping("/{id}")
    public Flight getById(@PathVariable Integer id) {
        return flightService.getById(id);
    }

    @PostMapping
    public Flight create(@RequestBody Flight flight) {
        return flightService.create(flight);
    }

    @PutMapping("/{id}")
    public Flight putFlight(@PathVariable Integer id, @RequestBody Flight flight){
        return flightService.updateFlight(id, flight);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        flightService.delete(id);
    }

}
