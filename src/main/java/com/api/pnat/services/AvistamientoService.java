package com.api.pnat.services;

import com.api.pnat.interfaces.IAvistamiento;
import com.api.pnat.model.Avistamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvistamientoService{

    @Autowired
    IAvistamiento iAvistamiento;

    public List<Avistamiento> findAll() {
        return (List<Avistamiento>) iAvistamiento.findAll();
    }
    
    public Avistamiento save(Avistamiento o) {
        return iAvistamiento.save(o);
    }

    public Avistamiento findById(Integer id) {
        return iAvistamiento.findById(id).orElse(null);
    }
   
    public void delete(Integer id) {
        if (id > 0) {
            Avistamiento avistamiento = (Avistamiento) findById(id);
            if (avistamiento.getId_avistamiento() > 0) {
                iAvistamiento.delete(avistamiento);
            }
        }
    }
}