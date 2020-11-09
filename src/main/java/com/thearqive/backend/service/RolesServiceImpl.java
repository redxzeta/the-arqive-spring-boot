package com.thearqive.backend.service;

import com.thearqive.backend.converter.Converter;
import com.thearqive.backend.dto.RolesDto;
import com.thearqive.backend.dto.RolesDtoForm;
import com.thearqive.backend.entities.Roles;
import com.thearqive.backend.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RolesServiceImpl implements RolesService {
    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    Converter converter;

    @Override
    public List<RolesDto> findAllRoles() {
        return converter.rolesListEntityToRolesDto(rolesRepository.findAll());
    }

    @Override
    public RolesDto createNewRole(RolesDtoForm rolesDtoForm) {
        Roles roles = converter.roleDtoFormToEntity(rolesDtoForm);
        roles = rolesRepository.save(roles);
        System.out.println(roles);
        return converter.rolesEntityToRolesDto(roles);
    }

    @Override
    public RolesDto getRoleById(Long id) {
        Roles roles = rolesRepository.getById(id);
        return converter.rolesEntityToRolesDto(roles);
    }

    @Override
    public Long deleteRoleById(Long id) {
        rolesRepository.deleteById(id);
        return id;
    }
}
