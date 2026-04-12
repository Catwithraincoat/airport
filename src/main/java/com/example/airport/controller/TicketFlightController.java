package com.example.airport.controller;


import com.example.airport.model.TicketFlight;
import com.example.airport.service.TicketFlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticketflights")
public class TicketFlightController {
    private TicketFlightService ticketFlightService;


    @GetMapping
    public List<TicketFlight> getAllTF(){
        return ticketFlightService.getAll();
    }

    @GetMapping("/{id}")
    public TicketFlight getByIdTF(@PathVariable TicketFlight.TicketFlightId id){
        return ticketFlightService.getbyId(id);
    }

    @PostMapping
    public TicketFlight createTF(@RequestBody TicketFlight ticketFlight){
        return ticketFlightService.create(ticketFlight);
    }

    @PutMapping("/{id}")
    public TicketFlight updateTF(@PathVariable TicketFlight.TicketFlightId id,@RequestBody TicketFlight ticketFlight ){
        return ticketFlightService.updateTicket(id, ticketFlight);
    }

    @DeleteMapping("/{id}")
    public void deleteTF(@PathVariable TicketFlight.TicketFlightId id){
        ticketFlightService.delete(id);
    }

}
