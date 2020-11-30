package com.api.pnat.controller;

import com.api.pnat.model.Especies;
import com.api.pnat.model.Inmersion;
import com.api.pnat.services.EspeciesService;
import com.api.pnat.services.InmersionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/inmersiones")
@SessionAttributes("inmersiones")
public class InmersionController {

    private static final Gson gson = new Gson();

    @Autowired
    InmersionService inmersionService;

    @GetMapping
    public List<Inmersion> inmersiones() {
        return inmersionService.findAll();
    }

    //listar un registro en especifico
    @GetMapping("{id}")
    public ResponseEntity<Inmersion> inmersiones(@PathVariable Integer id) {
        if (id > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(inmersionService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping
    public ResponseEntity<Inmersion> createInmersion(@RequestBody Inmersion inmersion) {
        return ResponseEntity.status(HttpStatus.OK).body(inmersionService.save(inmersion));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Inmersion> updateInmersion(@RequestBody Inmersion inmersion, @PathVariable Integer id) {
        inmersion.setId_inmersion(id);
        return ResponseEntity.status(HttpStatus.OK).body(inmersionService.save(inmersion));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInmersiones(@PathVariable Integer id) {
        Inmersion inmersion = inmersionService.findById(id);
        if (inmersion != null) {
            if (inmersion.getId() > 0) {
                inmersionService.delete(inmersion.getId_inmersion());
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
