package com.example.airport.controller;

import com.example.airport.model.BoardingPass;
import com.example.airport.model.Booking;
import com.example.airport.service.BoardingPassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("\boardingPasses")
public class BoardingPassController {
    private BoardingPassService boardingPassService;

    @GetMapping
    public List<BoardingPass> getAllBoardingPasses(){
        return boardingPassService.getaAll();
    }

    @GetMapping("/{id}")
    public BoardingPass getByid(@PathVariable BoardingPass.BoardingPassId Id){
        return boardingPassService.getById(Id);
    }

    @PostMapping
    public BoardingPass createBoardingPass(@RequestBody BoardingPass boardingPass){
        return boardingPassService.create(boardingPass);
    }

    @PutMapping("/{id}")
    public BoardingPass putBoardingPass(@PathVariable BoardingPass.BoardingPassId id, @RequestBody BoardingPass boardingPass){
        return boardingPassService.update(id, boardingPass);
    }

    @DeleteMapping("/{id}")
    public void deleteBoardingPass(@PathVariable BoardingPass.BoardingPassId id){
        boardingPassService.delete(id);
    }


}
