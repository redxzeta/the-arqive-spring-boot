package com.thearqive.backend.repositories;

import com.thearqive.backend.entities.Pins;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PinsRepository extends CrudRepository<Pins,Long> {
    @Override
    List<Pins> findAll();

    Pins getPinById(Long id);
}
