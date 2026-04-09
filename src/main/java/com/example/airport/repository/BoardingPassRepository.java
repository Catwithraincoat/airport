package com.example.airport.repository;

import com.example.airport.model.BoardingPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardingPassRepository extends JpaRepository<BoardingPass, BoardingPass.BoardingPassId> {
}
