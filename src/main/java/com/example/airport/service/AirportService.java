package com.example.airport.service;

import com.example.airport.entity.AirportEntity;
import com.example.airport.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportEntity getById(String Id){
        return airportRepository.findById(Id).orElseThrow(() -> new RuntimeException("Аэропорт не найден"));
    }

    public List<AirportEntity> getAll(){
        return airportRepository.findAll();
    }

    public AirportEntity saveAirport(AirportEntity airport){
        return airportRepository.save(airport);
    }

    public void deleteAirport(String Id){
        airportRepository.deleteById(Id);
    }

    public AirportEntity updateAirport(String Id, AirportEntity airport){
        if (!airportRepository.existsById(Id)) {
            throw new RuntimeException("Аэропрт не найден");
        }
        return airportRepository.save(airport);
    }
}
