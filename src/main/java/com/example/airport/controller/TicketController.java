package com.example.airport.controller;


import com.example.airport.entity.TicketEntity;
import com.example.airport.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping
    public List<TicketEntity> getAllTickets(){
        return ticketService.getAll();
    }

    @GetMapping("/{id}")
    public TicketEntity getByIdTicket(@PathVariable String id){
        return ticketService.getbyId(id);
    }

    @PostMapping
    public TicketEntity createTicket(@RequestBody TicketEntity ticketEntity){
        return ticketService.create(ticketEntity);
    }

    @PutMapping("/{id}")
    public TicketEntity updateTicket(@PathVariable String id , @RequestBody TicketEntity ticketEntity){
        return ticketService.updateTicket(id, ticketEntity);
    }

    @DeleteMapping("/{id}")
    public void  deleteTicket(@PathVariable String id){
        ticketService.delete(id);
    }


}
