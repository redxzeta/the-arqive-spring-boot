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
    public List<RolesDto> getAllRoles (){
        return rolesService.findAllRoles();
    }

    @PostMapping
    public RolesDto createNewRole (@RequestBody RolesDtoForm rolesDtoForm){
        return rolesService.createNewRole(rolesDtoForm);
    }

    @PostMapping("/test")
    public RolesDtoForm createTEST (@RequestBody RolesDtoForm rolesDtoForm){
        return rolesDtoForm;
    }
}
