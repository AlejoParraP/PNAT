package com.api.pnat.services;

import com.api.pnat.interfaces.IAvistaPorInmersion;
import com.api.pnat.model.AvistaPorInmersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvistaPorInmersionService {

	@Autowired
    IAvistaPorInmersion iAvistaPorInmersion;


    
    public List<AvistaPorInmersion> findAll() {
        return (List<AvistaPorInmersion>) iAvistaPorInmersion.findAll();
    }

    
    public void save(AvistaPorInmersion o) {
    	AvistaPorInmersion avistaPorInmersion = new AvistaPorInmersion();
    	avistaPorInmersion = (AvistaPorInmersion) o;
        iAvistaPorInmersion.save(avistaPorInmersion);
    }

    
    public Object findById(Long id) {
    	AvistaPorInmersion avistaPorInmersion = new AvistaPorInmersion();
    	avistaPorInmersion = iAvistaPorInmersion.findById(id).orElse(null);
        return avistaPorInmersion;
    }

    
    public void delete(Long id) {
        if (id > 0) {
        	AvistaPorInmersion avistaPorInmersion = new AvistaPorInmersion();
        	avistaPorInmersion = (AvistaPorInmersion) findById(id);
            //Metodo Get Requerido del modelo
            if (avistaPorInmersion.getId() > 0) {
                iAvistaPorInmersion.delete(avistaPorInmersion);
            }
        }
    }
}
