package com.example.airport.controller;

import com.example.airport.model.Booking;
import com.example.airport.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAll();
    }

    @GetMapping("/{id}")
    public Booking getByid(@PathVariable  String Id){
        return bookingService.getbyId(Id);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.create(booking);
    }

    @PutMapping("/{id}")
    public Booking putBooking(@PathVariable String id, @RequestBody Booking booking){
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable String id){
        bookingService.delete(id);
    }




}
