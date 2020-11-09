package com.thearqive.backend.controllers;

import com.thearqive.backend.dto.RolesDto;
import com.thearqive.backend.dto.RolesDtoForm;
import com.thearqive.backend.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    RolesService rolesService;

    @GetMapping
    public List<RolesDto> getAllRoles() {
        return rolesService.findAllRoles();
    }

    @GetMapping("/{id}")
    public RolesDto getRoleById(@PathVariable Long id) {
        return rolesService.getRoleById(id);
    }

    @PostMapping
    public RolesDto createNewRole(@RequestBody RolesDtoForm rolesDtoForm) {
        return rolesService.createNewRole(rolesDtoForm);
    }

    @DeleteMapping("/{id}")
    public Long deleteRole(@PathVariable Long id) {
        return rolesService.deleteRoleById(id);
    }
}
