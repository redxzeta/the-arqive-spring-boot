package com.thearqive.backend.controllers;

import com.thearqive.backend.service.PinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pins")
public class PinsController {
    @Autowired
    PinsService pinsService;

}
