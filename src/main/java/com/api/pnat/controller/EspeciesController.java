package com.api.pnat.controller;

import com.api.pnat.interfaces.IEspecies;
import com.api.pnat.model.Especies;
import com.api.pnat.services.EspeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import java.util.List;

@RestController
@RequestMapping("/especies")
@SessionAttributes("especies")
public class EspeciesController {
	
	private static final Gson gson = new Gson();
	
	@Autowired
    EspeciesService especiesService;

    @GetMapping
    public List<Especies> especies(Model model, @RequestParam(name = "page", defaultValue = "0") String a) {
        List<Especies> especies;
        especies = especiesService.findAll();
        return  especies;
    }
    
    @PostMapping
    public ResponseEntity<Void> createLugar(@RequestBody Especies especie) {
    	especiesService.save(especie);   	
    	return  ResponseEntity.status(HttpStatus.OK).build(); 
    			//created(savedAvistamiento).build();
    }
    
    @PutMapping
    /*public ResponseEntity<Void> updateEspecie(@RequestBody Especies especie, @PathVariable Integer idd) {
    	
    	Especies dato = (Especies) especiesService.findById(idd);
    	
    	if(dato != null ) {
    		dato.
    		especiesService.save(especie);
    	}
    	
    	especiesService.findById(idd);
    	
    	
    	
    	return  ResponseEntity.status(HttpStatus.OK).build();
    
    }*/
    
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEspecies(@PathVariable Integer id) {
    	if (id > 0) {
            Especies especie = new Especies();
            especie = (Especies) especiesService.findById(id);
            //Metodo Get Requerido del modelo
            if (especie.getId() > 0) {
                especiesService.delete(especie.getId());
                return ResponseEntity.ok(gson.toJson("SUCCESFUL"));
            }
            
        }
    	return ResponseEntity.ok(gson.toJson("This is a String"));
    }
}
