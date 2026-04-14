package com.example.airport.service;

import com.example.airport.entity.BookingEntity;
import com.example.airport.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public List<BookingEntity> getAll(){
        return bookingRepository.findAll();
    }

    public BookingEntity getbyId(String Id){
        if (!bookingRepository.existsById(Id)) {
        return bookingRepository.getById(Id);}

        throw new RuntimeException("Бронь  не найдена");
    }

    public BookingEntity create(BookingEntity bookingEntity){
        return bookingRepository.save(bookingEntity);
    }

    public BookingEntity updateBooking(String Id, BookingEntity bookingEntity){
        if (!bookingRepository.existsById(Id)) {
            return bookingRepository.save(bookingEntity);
        }
        throw new RuntimeException("Бронь не найдена");

    }
    public void delete(String Id){
        bookingRepository.deleteById(Id);
    }
}
