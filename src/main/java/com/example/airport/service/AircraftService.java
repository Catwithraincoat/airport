package com.example.airport.service;

import com.example.airport.model.Aircraft;
import com.example.airport.repository.AircraftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {
    private AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository){
        this.aircraftRepository = aircraftRepository;
    }

    public Aircraft getAircraftById(String Id){
        return aircraftRepository.findById(Id).orElseThrow(() -> new RuntimeException("Самолёт не найден"));

    }
    public List<Aircraft> getAll(){
        return aircraftRepository.findAll();
    }

    public Aircraft saveAircraft(Aircraft aircraft){
        return aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(String Id){
        aircraftRepository.deleteById(Id);
    }

    public Aircraft updateAircraft(String Id, Aircraft aircraft){
        if (!aircraftRepository.existsById(aircraft.getAircraftCode())) {
            throw new RuntimeException("Самолет не найден");
        }
        return aircraftRepository.save(aircraft);
    }



}
