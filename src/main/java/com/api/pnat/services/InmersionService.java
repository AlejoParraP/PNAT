package com.api.pnat.services;

import com.api.pnat.interfaces.IInmersion;
import com.api.pnat.model.Inmersion;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InmersionService{

	IInmersion iInmersion;
	
    public List<Inmersion> findAll() {
        return (List<Inmersion>) iInmersion.findAll();
    }

   
    public Inmersion save(Inmersion o) {
    	return iInmersion.save(o);
    }

    
    public Inmersion findById(Integer id) {
        return iInmersion.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        if (id > 0) {
            Inmersion inmersion = (Inmersion) findById(id);
            if (inmersion.getId() > 0) {
                iInmersion.delete(inmersion);
            }
        }
    }


	
}
