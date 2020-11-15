package com.api.pnat.services;

import com.api.pnat.interfaces.ILugares;
import com.api.pnat.model.Lugares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugaresService{

	@Autowired
    ILugares iLugares;

    public List<Lugares> findAll() {
        return (List<Lugares>) iLugares.findAll();
    }

    public void save(Lugares o) {
    	Lugares lugares = new Lugares();
        lugares = (Lugares) o;
        iLugares.save(lugares);
    }

    public Object findById(Long id) {
    	Lugares lugares = new Lugares();
        lugares = iLugares.findById(id).orElse(null);
        return lugares;
    }

    public void delete(Long id) {
        if (id > 0) {
        	Lugares lugares = new Lugares();
            lugares = (Lugares) findById(id);
            //Metodo Get Requerido del modelo
            if (lugares.getId() > 0) {
                iLugares.delete(lugares);
            }
        }
    }
}
