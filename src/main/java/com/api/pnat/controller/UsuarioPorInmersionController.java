package com.api.pnat.controller;

import com.api.pnat.model.Inmersion;
import com.api.pnat.model.UsuarioPorInmersion;
import com.api.pnat.services.InmersionService;
import com.api.pnat.services.UsuarioPorInmersionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/usuariosPorInmersion")
@SessionAttributes("usuariosPorInmersion")
public class UsuarioPorInmersionController {

    private static final Gson gson = new Gson();

    @Autowired
    UsuarioPorInmersionService usuarioPorInmersionService;

    @GetMapping
    public List<UsuarioPorInmersion> usuarioPorInmersion() {
        return usuarioPorInmersionService.findAll();
    }

    //listar un registro en especifico
    @GetMapping("{id}")
    public ResponseEntity<UsuarioPorInmersion> usuariosPorInmersion(@PathVariable Integer id) {
        if (id > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioPorInmersionService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping
    public ResponseEntity<UsuarioPorInmersion> createUporI(@RequestBody UsuarioPorInmersion usuarioPorInmersion) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioPorInmersionService.save(usuarioPorInmersion));
    }

    @PatchMapping("{id}")
    public ResponseEntity<UsuarioPorInmersion> updateUporI(@RequestBody UsuarioPorInmersion usuarioPorInmersion, @PathVariable Integer id) {
        usuarioPorInmersion.setId_usuarioPorInmersion(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioPorInmersionService.save(usuarioPorInmersion));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUporI(@PathVariable Integer id) {
        UsuarioPorInmersion usuarioPorInmersion = usuarioPorInmersionService.findById(id);
        if (usuarioPorInmersion != null) {
            if (usuarioPorInmersion.getId_usuarioPorInmersion() > 0) {
                usuarioPorInmersionService.delete(usuarioPorInmersion.getId_usuarioPorInmersion());
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
