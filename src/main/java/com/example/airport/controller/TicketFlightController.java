package com.example.airport.controller;


import com.example.airport.entity.TicketFlightEntity;
import com.example.airport.service.TicketFlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/ticketflights")
public class TicketFlightController {
    private final TicketFlightService ticketFlightService;


    @GetMapping
    public List<TicketFlightEntity> getAllTF(){
        return ticketFlightService.getAll();
    }

    @GetMapping("/{id}")
    public TicketFlightEntity getByIdTF(@PathVariable TicketFlightEntity.TicketFlightId id){
        return ticketFlightService.getbyId(id);
    }

    @PostMapping
    public TicketFlightEntity createTF(@RequestBody TicketFlightEntity ticketFlightEntity){
        return ticketFlightService.create(ticketFlightEntity);
    }

    @PutMapping("/{id}")
    public TicketFlightEntity updateTF(@PathVariable TicketFlightEntity.TicketFlightId id, @RequestBody TicketFlightEntity ticketFlightEntity){
        return ticketFlightService.updateTicket(id, ticketFlightEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteTF(@PathVariable TicketFlightEntity.TicketFlightId id){
        ticketFlightService.delete(id);
    }

}
