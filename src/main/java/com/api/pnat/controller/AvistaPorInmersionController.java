package com.api.pnat.controller;

import com.api.pnat.model.AvistaPorInmersion;
import com.api.pnat.services.AvistaPorInmersionService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/AvistamientoPorInmersion")
@SessionAttributes("AvistamientoPorInmersion")
public class AvistaPorInmersionController {

	@Autowired
    AvistaPorInmersionService avistaService;

    @GetMapping({"/avistamientos"})
    public List<AvistaPorInmersion> avistamientosPorInmersion() {
        return avistaService.findAll();
    }
}
