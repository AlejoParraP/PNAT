package com.api.pnat.controller;

import com.api.pnat.model.Lugares;
import com.api.pnat.services.LugaresService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/lugares")
@SessionAttributes("lugares")
public class LugaresController {
	
	@Autowired
    LugaresService lugaresService;

    @GetMapping({"/"})
    public List<Lugares> lugares() {
        return lugaresService.findAll();
    }
}
