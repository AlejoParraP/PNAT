package com.api.pnat.controller;

import com.api.pnat.model.Avistamiento;
import com.api.pnat.model.Especies;
import com.api.pnat.services.AvistamientoService;
import com.api.pnat.services.EspeciesService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/avistamientos")
@SessionAttributes("avistamientos")
public class AvistamientoController {

    private static final Gson gson = new Gson();

    @Autowired
    AvistamientoService avistamientoService;

    @GetMapping
    public List<Avistamiento> especies() {
        return avistamientoService.findAll();
    }

    //listar un registro en especifico
    @GetMapping("{id}")
    public ResponseEntity<Avistamiento> avistamiento(@PathVariable Integer id) {
        if (id > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(avistamientoService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping
    public ResponseEntity<Avistamiento> createAvistamiento(@RequestBody Avistamiento avistamiento) {
        return ResponseEntity.status(HttpStatus.OK).body(avistamientoService.save(avistamiento));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Avistamiento> updateAvistamiento(@RequestBody Avistamiento avistamiento, @PathVariable Integer id) {
        avistamiento.setId_especie(id);
        return ResponseEntity.status(HttpStatus.OK).body(avistamientoService.save(avistamiento));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAvistamiento(@PathVariable Integer id) {
        Avistamiento avistamiento = avistamientoService.findById(id);
        if (avistamiento != null) {
            if (avistamiento.getId_avistamiento() > 0) {
                avistamientoService.delete(avistamiento.getId_especie());
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    
}