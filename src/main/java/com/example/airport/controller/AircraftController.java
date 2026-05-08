package com.example.airport.controller;

import com.example.airport.dto.AircraftDTO;
import com.example.airport.dto.AircraftFilterDTO;
import com.example.airport.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/aircrafts")
@RequiredArgsConstructor
public class AircraftController {
    private final AircraftService aircraftService;


    @GetMapping("/search")
    public Page<AircraftDTO> search(
            AircraftFilterDTO filter,
            @PageableDefault(size = 10, page = 0) Pageable pageable
    ) {
        return aircraftService.search(filter, pageable);
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
