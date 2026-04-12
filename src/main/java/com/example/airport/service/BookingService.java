package com.example.airport.service;

import com.example.airport.model.Booking;
import com.example.airport.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private BookingRepository bookingRepository;

    public List<Booking> getAll(){
        return bookingRepository.findAll();
    }

    public Booking getbyId(String Id){
        if (!bookingRepository.existsById(Id)) {
        return bookingRepository.getById(Id);}

        throw new RuntimeException("Бронь  не найдена");
    }

    public Booking create(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(String Id, Booking booking){
        if (!bookingRepository.existsById(Id)) {
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Бронь не найдена");

    }
    public void delete(String Id){
        bookingRepository.deleteById(Id);
    }
}
