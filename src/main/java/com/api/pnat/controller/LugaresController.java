package com.api.pnat.controller;

import com.api.pnat.model.Especies;
import com.api.pnat.model.Lugares;
import com.api.pnat.services.EspeciesService;
import com.api.pnat.services.LugaresService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/lugares")
@SessionAttributes("lugares"))
public class LugaresController {

    private static final Gson gson = new Gson();

    @Autowired
    LugaresService lugaresService;

    @GetMapping
    public List<Lugares> lugares() {
        return lugaresService.findAll();
    }

    //listar un registro en especifico
    @GetMapping("{id}")
    public ResponseEntity<Lugares> lugares(@PathVariable Integer id) {
        if (id > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(lugaresService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping
    public ResponseEntity<Lugares> createLugar(@RequestBody Lugares lugares) {
        return ResponseEntity.status(HttpStatus.OK).body(lugaresService.save(lugares));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Lugares> updateLugares(@RequestBody Lugares lugares, @PathVariable Integer id) {
        lugares.setId_lugar(id);
        return ResponseEntity.status(HttpStatus.OK).body(lugaresService.save(lugares));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLugares(@PathVariable Integer id) {
        Lugares lugares = lugaresService.findById(id);
        if (lugares != null) {
            if (lugares.getId_lugar() > 0) {
                lugaresService.delete(lugares.getId_lugar());
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
