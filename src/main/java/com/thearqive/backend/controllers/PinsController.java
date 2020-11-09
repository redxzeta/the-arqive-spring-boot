package com.thearqive.backend.controllers;

import com.thearqive.backend.dto.PinsDto;
import com.thearqive.backend.dto.PinsFormDto;
import com.thearqive.backend.service.PinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pins")
public class PinsController {
    @Autowired
    PinsService pinsService;

    @GetMapping
    public List<PinsDto> getAllPins() {
        return pinsService.getAllPins();

    }

    @GetMapping("/{id}")
    public PinsDto getAPinById(@PathVariable Long id){
        return pinsService.getPinById(id);
    }

    @PostMapping
    public PinsDto createPin(@RequestBody PinsFormDto pinsFormDto){
        return pinsService.createNewPin(pinsFormDto);
    }

    @GetMapping("/userpins/{userId}")
    public List<PinsDto> getUserPins(@PathVariable Long userId){
        return pinsService.getUserPins(userId);
    }

    @DeleteMapping("/{id}")
    public Long deletePinById(@PathVariable Long id){
        return pinsService.deletePinById(id);
    }
}
