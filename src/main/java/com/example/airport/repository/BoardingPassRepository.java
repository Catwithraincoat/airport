package com.example.airport.repository;

import com.example.airport.entity.BoardingPassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardingPassRepository extends JpaRepository<BoardingPassEntity, BoardingPassEntity.BoardingPassId> {
}
