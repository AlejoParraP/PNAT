package com.api.pnat.controller;

import com.api.pnat.model.Inmersion;
import com.api.pnat.model.Usuario;
import com.api.pnat.services.InmersionService;
import com.api.pnat.services.UsuarioService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
@SessionAttributes("usuarios")
public class UsuarioController {

    private static final Gson gson = new Gson();

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> usuarios() {
        return usuarioService.findAll();
    }

    //listar un registro en especifico
    @GetMapping("{id}")
    public ResponseEntity<Usuario> usuarios(@PathVariable Integer id) {
        if (id > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
        usuario.setId_usuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUsuarios(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            if (usuario.getId() > 0) {
                usuarioService.delete(usuario.getId_usuario());
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
