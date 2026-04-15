package com.example.airport.controller;

import com.example.airport.entity.BookingEntity;
import com.example.airport.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/bookings")
public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    public List<BookingEntity> getAllBookings(){
        return bookingService.getAll();
    }

    @GetMapping("/{Id}")
    public BookingEntity getByid(@PathVariable  String Id){
        return bookingService.getbyId(Id);
    }

    @PostMapping
    public BookingEntity createBooking(@RequestBody BookingEntity bookingEntity){
        return bookingService.create(bookingEntity);
    }

    @PutMapping("/{id}")
    public BookingEntity putBooking(@PathVariable String id, @RequestBody BookingEntity bookingEntity){
        return bookingService.updateBooking(id, bookingEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable String id){
        bookingService.delete(id);
    }


}
