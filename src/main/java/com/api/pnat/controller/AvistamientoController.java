package com.api.pnat.controller;

import com.api.pnat.model.Avistamiento;
import com.api.pnat.services.AvistamientoService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avistamientos")
@SessionAttributes("avistamientos")
public class AvistamientoController {

    @Autowired
    AvistamientoService avistamientoService;

    @GetMapping({"/avistamientos"})
    public List<Avistamiento> avistamientos() {
        return avistamientoService.findAll();
    }
}