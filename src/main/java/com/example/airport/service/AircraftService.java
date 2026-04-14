package com.example.airport.service;

import com.example.airport.entity.AircraftEntity;
import com.example.airport.repository.AircraftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftService {
    private final AircraftRepository aircraftRepository;

    public AircraftEntity getAircraftById(String Id){
        return aircraftRepository.findById(Id).orElseThrow(() -> new RuntimeException("Самолёт не найден"));

    }

    public List<AircraftEntity> getAll(){
        return aircraftRepository.findAll();
    }

    public AircraftEntity saveAircraft(AircraftEntity aircraftEntity){
        return aircraftRepository.save(aircraftEntity);
    }

    public void deleteAircraft(String Id){
        aircraftRepository.deleteById(Id);
    }

    public AircraftEntity updateAircraft(String Id, AircraftEntity aircraftEntity){
        if (!aircraftRepository.existsById(aircraftEntity.getAircraftCode())) {
            throw new RuntimeException("Самолет не найден");
        }
        return aircraftRepository.save(aircraftEntity);
    }



}
