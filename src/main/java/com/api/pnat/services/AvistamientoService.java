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
    
    public Avistamiento save(Avistamiento avistamiento) {
        return iAvistamiento.save(avistamiento);    
    }
   
    public Object findById(Integer id) {
        Avistamiento avistamiento = new Avistamiento();
        avistamiento = iAvistamiento.findById(id).orElse(null);
        return avistamiento;
    }
   
    public void delete(Integer id) {
        if (id > 0) {
            Avistamiento avistamiento = new Avistamiento();
            avistamiento = (Avistamiento) findById(id);
            //Metodo Get Requerido del modelo
            if (avistamiento.getId() > 0) {
                iAvistamiento.delete(avistamiento);
            }
        }
    }
}