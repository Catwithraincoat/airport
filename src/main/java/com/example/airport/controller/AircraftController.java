package com.example.airport.controller;

import com.example.airport.dto.AircraftDTO;
import com.example.airport.dto.AircraftFilterDTO;
import com.example.airport.entity.AircraftEntity;
import com.example.airport.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/aircrafts")
@RequiredArgsConstructor
public class AircraftController {
    private final AircraftService aircraftService;
    // Контроллер для поиска с фильтрами
    @GetMapping("/search")
    public List<AircraftDTO> search(AircraftFilterDTO aircraftFilterDTO){
        return aircraftService.search(aircraftFilterDTO);
    }

    @GetMapping("/{code}")
    public AircraftDTO getById(@PathVariable String code){
        return aircraftService.getAircraftById(code);
    }

    @GetMapping
    public List<AircraftDTO> getAllAircrafts() {
        return aircraftService.getAll();
    }

    @PostMapping
    public AircraftDTO createAircraft(@RequestBody AircraftDTO aircraftDTO){
        return aircraftService.saveAircraft(aircraftDTO);
    }


    @PutMapping("/{code}")
    public AircraftDTO updateAircraft(@PathVariable String code, @RequestBody AircraftDTO aircraftDTO){
        return aircraftService.updateAircraft(code, aircraftDTO);
    }

    @DeleteMapping("/{code}")
    public String deleteAircraft(@PathVariable String code){

        return aircraftService.deleteAircraft(code);
    }



}
