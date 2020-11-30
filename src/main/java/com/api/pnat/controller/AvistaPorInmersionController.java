package com.api.pnat.controller;

import com.api.pnat.model.AvistaPorInmersion;
import com.api.pnat.model.Especies;
import com.api.pnat.services.AvistaPorInmersionService;
import com.api.pnat.services.EspeciesService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/avistamientosPorInmersion")
@SessionAttributes("avistamientosPorInmersion")
public class AvistaPorInmersionController {

    private static final Gson gson = new Gson();

    @Autowired
    AvistaPorInmersionService avistaPorInmersionService;

    @GetMapping
    public List<AvistaPorInmersion> avistaPorInmersion() {
        return avistaPorInmersionService.findAll();
    }

    //listar un registro en especifico
    @GetMapping("{id}")
    public ResponseEntity<AvistaPorInmersion> avistamientosPorInmersion(@PathVariable Integer id) {
        if (id > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(avistaPorInmersionService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping
    public ResponseEntity<AvistaPorInmersion> createAporI(@RequestBody AvistaPorInmersion avistaPorInmersion) {
        return ResponseEntity.status(HttpStatus.OK).body(avistaPorInmersionService.save(avistaPorInmersion));
    }

    @PatchMapping("{id}")
    public ResponseEntity<AvistaPorInmersion> updateAporI(@RequestBody AvistaPorInmersion avistaPorInmersion, @PathVariable Integer id) {
        avistaPorInmersion.setId_avisPorInmersion(id);
        return ResponseEntity.status(HttpStatus.OK).body(avistaPorInmersionService.save(avistaPorInmersion));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAporI(@PathVariable Integer id) {
        AvistaPorInmersion avistaPorInmersion = avistaPorInmersionService.findById(id);
        if (avistaPorInmersion != null) {
            if (avistaPorInmersion.getId_avisPorInmersion() > 0) {
                avistaPorInmersionService.delete(avistaPorInmersion.getId_avisPorInmersion());
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
