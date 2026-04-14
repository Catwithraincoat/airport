package com.example.airport.controller;

import com.example.airport.entity.BoardingPassEntity;
import com.example.airport.service.BoardingPassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/boardingPasses")
public class BoardingPassController {
    private final BoardingPassService boardingPassService;

    @GetMapping
    public List<BoardingPassEntity> getAllBoardingPasses(){
        return boardingPassService.getaAll();
    }

    @GetMapping("/{Id}")
    public BoardingPassEntity getByid(@PathVariable BoardingPassEntity.BoardingPassId Id){
        return boardingPassService.getById(Id);
    }

    @PostMapping
    public BoardingPassEntity createBoardingPass(@RequestBody BoardingPassEntity boardingPassEntity){
        return boardingPassService.create(boardingPassEntity);
    }

    @PutMapping("/{id}")
    public BoardingPassEntity putBoardingPass(@PathVariable BoardingPassEntity.BoardingPassId id, @RequestBody BoardingPassEntity boardingPassEntity){
        return boardingPassService.update(id, boardingPassEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteBoardingPass(@PathVariable BoardingPassEntity.BoardingPassId id){
        boardingPassService.delete(id);
    }


}
