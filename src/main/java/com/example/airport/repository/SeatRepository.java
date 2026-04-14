package com.example.airport.repository;

import com.example.airport.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, SeatEntity.SeatId> {
}
