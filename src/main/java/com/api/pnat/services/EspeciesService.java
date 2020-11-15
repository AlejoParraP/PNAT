package com.api.pnat.services;

import com.api.pnat.interfaces.IEspecies;
import com.api.pnat.model.Especies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EspeciesService {

	@Autowired
    IEspecies iEspecies;


    
    public List<Especies> findAll() {
        return (List<Especies>) iEspecies.findAll();
    }

    
    public void save(Especies o) {
    	Especies especies = new Especies();
    	especies = (Especies) o;
        iEspecies.save(especies);
    }

    
    public Object findById(Integer id) {
    	Especies especies = new Especies();
    	especies = iEspecies.findById(id).orElse(null);
        return especies;
    }

    
    public void delete(Integer id) {
        if (id > 0) {
        	Especies especies = new Especies();
            especies = (Especies) findById(id);
            //Metodo Get Requerido del modelo
            if (especies.getId() > 0) {
                iEspecies.delete(especies);
            }
        }
    }
}
