package com.example.airport.service;

import com.example.airport.model.Airport;
import com.example.airport.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }

    public Airport getById(String Id){
        return airportRepository.findById(Id).orElseThrow(() -> new RuntimeException("Аэропорт не найден"));
    }

    public List<Airport> getAll(){
        return airportRepository.findAll();
    }

    public Airport saveAirport(Airport airport){
        return airportRepository.save(airport);
    }

    public void deleteAirport(String Id){
        airportRepository.deleteById(Id);
    }

    public Airport updateAirport(String Id, Airport airport){
        if (!airportRepository.existsById(Id)) {
            throw new RuntimeException("Аэропрт не найден");
        }
        return airportRepository.save(airport);
    }
}
