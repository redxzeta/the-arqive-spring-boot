package com.thearqive.backend.repositories;

import com.thearqive.backend.entities.Roles;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RolesRepository extends CrudRepository<Roles, Long> {
    @Override
    List<Roles> findAll();

    Roles getById(Long id);
}
