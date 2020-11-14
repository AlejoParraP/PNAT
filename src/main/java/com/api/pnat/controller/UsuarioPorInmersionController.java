package com.api.pnat.controller;

import com.api.pnat.model.UsuarioPorInmersion;
import com.api.pnat.services.UsuarioPorInmersionService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarioPorInmersiones")
@SessionAttributes("UsuarioPorInmersiones")
public class UsuarioPorInmersionController {
	
	@Autowired
    UsuarioPorInmersionService usuarioPorInmersionService;

    @GetMapping({"/usuarioPorInmersiones"})
    public List<UsuarioPorInmersion> usuariosPorInmersion() {
        return usuarioPorInmersionService.findAll();
    }

}
