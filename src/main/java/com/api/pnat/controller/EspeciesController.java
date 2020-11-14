package com.api.pnat.controller;


import com.api.pnat.model.Especies;
import com.api.pnat.services.EspeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especies")
@SessionAttributes("especies")
public class EspeciesController {
	
	@Autowired
    EspeciesService especiesService;

    @GetMapping({"/especies"}) //get:empresas
    public List<Especies> especies(Model model, @RequestParam(name = "page", defaultValue = "0") String a) {
        List<Especies> especies;
        especies = especiesService.findAll();
        return  especies;
    }

}
