package com.example.airport.controller;


import com.example.airport.model.Seat;
import com.example.airport.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAll();
    }

    @GetMapping("/{id}")
    public Seat getByIdSeat(@PathVariable Seat.SeatId Id){
        return seatService.getById(Id);
    }

    @PostMapping
    public Seat createSeat(@RequestBody Seat seat){
        return seatService.create(seat);
    }

    @PutMapping("/{id}")
    public Seat updateSeat(Seat.SeatId id, @RequestBody Seat seat){
        return seatService.updateSeat(id, seat);
    }

    @DeleteMapping("/{id}")
    public void deleteSeat(@PathVariable Seat.SeatId id){
        seatService.delete(id);
    }

}
