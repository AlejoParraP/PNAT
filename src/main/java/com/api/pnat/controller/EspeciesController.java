package com.api.pnat.controller;

import com.api.pnat.model.Especies;
import com.api.pnat.services.EspeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.util.List;

@RestController
@RequestMapping("/v1/especies")
@SessionAttributes("especies")
public class EspeciesController {

    private static final Gson gson = new Gson();

    @Autowired
    EspeciesService especiesService;

    @GetMapping
    public List<Especies> especies() {
        return especiesService.findAll();
    }

    //listar un registro en especifico
    @GetMapping("{id}")
    public ResponseEntity<Especies> especies(@PathVariable Integer id) {
        if (id > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(especiesService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping
    public ResponseEntity<Especies> createEspecie(@RequestBody Especies especie) {
        return ResponseEntity.status(HttpStatus.OK).body(especiesService.save(especie));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Especies> updateEspecie(@RequestBody Especies especie, @PathVariable Integer id) {
        especie.setId_especie(id);
        return ResponseEntity.status(HttpStatus.OK).body(especiesService.save(especie));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEspecies(@PathVariable Integer id) {
        Especies especie = especiesService.findById(id);
        if (especie != null) {
            if (especie.getId_especie() > 0) {
                especiesService.delete(especie.getId_especie());
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
