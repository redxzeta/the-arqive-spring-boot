package com.thearqive.backend.service;

import com.thearqive.backend.dto.RolesDto;
import com.thearqive.backend.dto.RolesDtoForm;

import java.util.List;

public interface RolesService {

    List<RolesDto> findAllRoles();

    RolesDto createNewRole(RolesDtoForm rolesDtoForm);

    RolesDto getRoleById(Long id);

    Long deleteRoleById(Long id);
}
