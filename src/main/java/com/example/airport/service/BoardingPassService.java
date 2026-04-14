package com.example.airport.service;


import com.example.airport.entity.BoardingPassEntity;
import com.example.airport.repository.BoardingPassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardingPassService {
    private final BoardingPassRepository boardingPassRepository;


    public List<BoardingPassEntity> getaAll(){
        return boardingPassRepository.findAll();
    }

    public BoardingPassEntity getById(BoardingPassEntity.BoardingPassId Id){
        return boardingPassRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Место не найдено"));
    }

    public BoardingPassEntity create(BoardingPassEntity boardingPassEntity){
        return boardingPassRepository.save(boardingPassEntity);
    }

    public BoardingPassEntity update(BoardingPassEntity.BoardingPassId Id, BoardingPassEntity boardingPassEntity){
        if (!boardingPassRepository.existsById(Id)) {
            return boardingPassRepository.save(boardingPassEntity);
        }
        throw new RuntimeException("Посадочный  не найден");
    }

    public void delete(BoardingPassEntity.BoardingPassId id){
        boardingPassRepository.deleteById(id);
    }
}
