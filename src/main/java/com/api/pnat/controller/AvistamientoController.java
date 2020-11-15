package com.api.pnat.controller;

import com.api.pnat.model.Avistamiento;
import com.api.pnat.services.AvistamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/avistamientos")
@SessionAttributes("avistamientos")
public class AvistamientoController {

    @Autowired
    AvistamientoService avistamientoService;

    @GetMapping
    public List<Avistamiento> avistamientos() {
        return avistamientoService.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Void> createAvistamiento(@RequestBody Avistamiento avistamiento) {
    	Avistamiento savedAvistamiento = avistamientoService.save(avistamiento);   	
    	return  ResponseEntity.status(HttpStatus.OK).build(); 
    			//created(savedAvistamiento).build();
    }

    @PutMapping
    public void updateAvistamiento(@RequestBody Avistamiento avistamiento) {
    	
    }
    
    
    @DeleteMapping("{id}")
    public void deleteAvistamiento(@PathVariable Long id) {
    		
    }
    
    
}