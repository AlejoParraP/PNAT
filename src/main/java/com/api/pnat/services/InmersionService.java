package com.api.pnat.services;

import com.api.pnat.interfaces.IInmersion;
import com.api.pnat.model.Inmersion;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InmersionService{

	IInmersion iInmersion;
	
    public List<Inmersion> findAll() {
        return (List<Inmersion>) iInmersion.findAll();
    }

   
    public void save(Inmersion o) {
    	Inmersion inmersion = new Inmersion();
    	inmersion = (Inmersion) o;
    	iInmersion.save(inmersion);
    	
    }

    
    public Object findById(Integer id) {
        Inmersion inmersion = new Inmersion();
        inmersion = iInmersion.findById(id).orElse(null);
        return inmersion;
    }

    public void delete(Integer id) {
        if (id > 0) {
            Inmersion inmersion = new Inmersion();
            inmersion = (Inmersion) findById(id);
            //Metodo Get Requerido del modelo
            if (inmersion.getId() > 0) {
                iInmersion.delete(inmersion);
            }
        }
    }


	
}
