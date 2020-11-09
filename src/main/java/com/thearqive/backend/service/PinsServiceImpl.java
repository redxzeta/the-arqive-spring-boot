package com.thearqive.backend.service;

import com.thearqive.backend.converter.Converter;
import com.thearqive.backend.dto.PinsDto;
import com.thearqive.backend.dto.PinsFormDto;
import com.thearqive.backend.entities.Pins;
import com.thearqive.backend.repositories.PinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PinsServiceImpl implements PinsService {
    @Autowired
    PinsRepository pinsRepository;

    @Autowired
    Converter converter;

    @Override
    public List<PinsDto> getAllPins() {
        return converter.pinsListEntityToPinDto(pinsRepository.findAll());
    }

    @Override
    public PinsDto getPinById(Long id) {
        return converter.pinsEntityToPinsDto(pinsRepository.getPinById(id));
    }

    @Override
    public PinsDto createNewPin(PinsFormDto pinsFormDto) {
        Pins pins = converter.pinsDtoFormToEntity(pinsFormDto);
        pins = pinsRepository.save(pins);
        return converter.pinsEntityToPinsDto(pins);
    }

    @Override
    public Long deletePinById(Long id) {
        pinsRepository.deleteById(id);
        return id;
    }

    @Override
    public List<PinsDto> getUserPins(Long userId) {
        return converter.pinsListEntityToPinDto(pinsRepository.getUserPinsByUserProfileId(userId));
    }
}
