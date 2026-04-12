package com.example.airport.service;


import com.example.airport.model.Flight;
import com.example.airport.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public List<Flight> getAll() {
        return flightRepository.findAll();
    }


    public Flight getById(Integer id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }


    public Flight create(Flight flight) {
        return flightRepository.save(flight);
    }

    public void delete(Integer id) {
        flightRepository.deleteById(id);
    }

    public Flight updateFlight(Integer Id, Flight flight){
        if (!flightRepository.existsById(Id)) {
            return flightRepository.save(flight);
        }
        throw new RuntimeException("Полет не найден");
    }
}
