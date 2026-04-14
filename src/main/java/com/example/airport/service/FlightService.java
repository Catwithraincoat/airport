package com.example.airport.service;


import com.example.airport.entity.FlightEntity;
import com.example.airport.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public List<FlightEntity> getAll() {
        return flightRepository.findAll();
    }


    public FlightEntity getById(Integer id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }


    public FlightEntity create(FlightEntity flightEntity) {
        return flightRepository.save(flightEntity);
    }

    public void delete(Integer id) {
        flightRepository.deleteById(id);
    }

    public FlightEntity updateFlight(Integer Id, FlightEntity flightEntity){
        if (!flightRepository.existsById(Id)) {
            return flightRepository.save(flightEntity);
        }
        throw new RuntimeException("Полет не найден");
    }
}
