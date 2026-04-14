package com.example.airport.controller;


import com.example.airport.entity.SeatEntity;
import com.example.airport.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/seats")
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @GetMapping
    public List<SeatEntity> getAllSeats() {
        return seatService.getAll();
    }

    @GetMapping("/{Id}")
    public SeatEntity getByIdSeat(@PathVariable SeatEntity.SeatId Id){
        return seatService.getById(Id);
    }

    @PostMapping
    public SeatEntity createSeat(@RequestBody SeatEntity seatEntity){
        return seatService.create(seatEntity);
    }

    @PutMapping("/{id}")
    public SeatEntity updateSeat(SeatEntity.SeatId id, @RequestBody SeatEntity seatEntity){
        return seatService.updateSeat(id, seatEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteSeat(@PathVariable SeatEntity.SeatId id){
        seatService.delete(id);
    }

}
