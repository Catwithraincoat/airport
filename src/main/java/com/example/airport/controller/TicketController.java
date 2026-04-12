package com.example.airport.controller;


import com.example.airport.model.Ticket;
import com.example.airport.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets(){
        return ticketService.getAll();
    }

    @GetMapping("/{id}")
    public Ticket getByIdTicket(@PathVariable String id){
        return ticketService.getbyId(id);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketService.create(ticket);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable String id , @RequestBody Ticket ticket ){
        return ticketService.updateTicket(id, ticket);
    }

    @DeleteMapping("/{id}")
    public void  deleteTicket(@PathVariable String id){
        ticketService.delete(id);
    }


}
