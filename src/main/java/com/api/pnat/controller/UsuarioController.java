package com.api.pnat.controller;

import com.api.pnat.model.Usuario;
import com.api.pnat.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@SessionAttributes("usuarios")
public class UsuarioController {

	@Autowired
    UsuarioService usuarioService;

    @GetMapping({"/avistamientos"})
    public List<Usuario> usuarios() {
        return usuarioService.findAll();
    }
}
