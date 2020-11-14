package com.api.pnat.controller;

import com.api.pnat.model.Inmersion;
import com.api.pnat.services.InmersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Inmersiones")
@SessionAttributes("inmersiones")
public class InmersionController {

	@Autowired
    InmersionService inmersionService;

    @GetMapping({"/Inmersiones"}) //get:empresas
    public List<Inmersion> inmersiones(Model model, @RequestParam(name = "page", defaultValue = "0") String a) {
        List<Inmersion> inmersiones;
        inmersiones = inmersionService.findAll();
        return  inmersiones;
    }
	
	
}
