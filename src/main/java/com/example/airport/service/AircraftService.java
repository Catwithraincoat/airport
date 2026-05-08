package com.example.airport.service;

import com.example.airport.dto.AircraftDTO;
import com.example.airport.dto.AircraftFilterDTO;
import com.example.airport.dto.projection.AircraftProjection;
import com.example.airport.entity.AircraftEntity;
import com.example.airport.mapper.AircraftMapper;
import com.example.airport.repository.AircraftRepository;
import com.example.airport.service.validate.AircraftValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AircraftService {
    private final AircraftRepository aircraftRepository;
    private final AircraftMapper aircraftMapper;
    private final AircraftValidationService aircraftValidationService;

    public AircraftDTO getAircraftById(String Id){
        return aircraftMapper.toDTO(aircraftRepository.findById(Id).orElseThrow(() -> new RuntimeException("Самолёт не найден")));

    }

    public List<AircraftDTO> getAll(){
        return aircraftRepository.findAll().stream()
                .map(aircraftMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AircraftDTO saveAircraft(AircraftDTO aircraftDTO){
        //TODO вызвать сервис вылидации  AurcraftValidationService - Фабрика  внутри коллецкия интерфесйов которая проверяет DTO
        aircraftValidationService.validate(aircraftDTO);
        return aircraftMapper.toDTO(aircraftRepository.save(aircraftMapper.toEntity(aircraftDTO)));
    }

    public String deleteAircraft(String Id){
        aircraftRepository.deleteById(Id);
        return "Ok";
    }

    public AircraftDTO updateAircraft(String code, AircraftDTO dto){

        AircraftEntity existing = aircraftRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("Not found"));

        existing.setModel(dto.getModel());
        existing.setRange(Integer.valueOf(dto.getRange()));
        return aircraftMapper.toDTO(aircraftRepository.save(existing));
    }

    public Page<AircraftDTO> search(AircraftFilterDTO filter, Pageable pageable) {
        return aircraftRepository.search(
                filter.getModel(),
                filter.getMinRange(),
                filter.getMaxRange(),
                filter.getAircraftCode(),
                pageable
        ).map(p -> {
            AircraftDTO dto = new AircraftDTO();
            dto.setAircraftCode(p.getAircraftCode());
            dto.setModel(p.getModel());
            dto.setRange(String.valueOf(p.getRange()));
            return dto;
        });
    }



}
