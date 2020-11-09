package com.thearqive.backend.service;

import com.thearqive.backend.dto.PinsDto;
import com.thearqive.backend.dto.PinsFormDto;

import java.util.List;

public interface PinsService {
    List<PinsDto> getAllPins();

    PinsDto getPinById(Long id);

    PinsDto createNewPin(PinsFormDto pinsFormDto);

    Long deletePinById(Long id);
}
