package com.example.airport.service;


import com.example.airport.model.BoardingPass;
import com.example.airport.repository.BoardingPassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardingPassService {
    private BoardingPassRepository boardingPassRepository;


    public List<BoardingPass> getaAll(){
        return boardingPassRepository.findAll();
    }

    public BoardingPass getById(BoardingPass.BoardingPassId Id){
        return boardingPassRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Место не найдено"));
    }

    public BoardingPass create(BoardingPass boardingPass){
        return boardingPassRepository.save(boardingPass);
    }

    public BoardingPass update(BoardingPass.BoardingPassId Id, BoardingPass boardingPass){
        if (!boardingPassRepository.existsById(Id)) {
            return boardingPassRepository.save(boardingPass);
        }
        throw new RuntimeException("Посадочный  не найден");
    }

    public void delete(BoardingPass.BoardingPassId id){
        boardingPassRepository.deleteById(id);
    }
}
