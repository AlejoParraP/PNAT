package com.api.pnat.services;

import com.api.pnat.idao.IObjectCrudDao;
import com.api.pnat.idao.IQueryObject;
import com.api.pnat.interfaces.IAvistamiento;
import com.api.pnat.model.Avistamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvistamientoService implements IObjectCrudDao<Avistamiento> {

    @Autowired
    IAvistamiento iAvistamiento;


    @Override
    public List<Avistamiento> findAll() {
        return (List<Avistamiento>) iAvistamiento.findAll();
    }

    @Override
    public void save(Avistamiento o) {
        Avistamiento avistamiento = new Avistamiento();
        avistamiento = (Avistamiento) o;
        iAvistamiento.save(avistamiento);
    }

    @Override
    public Object findById(Long id) {
        Avistamiento avistamiento = new Avistamiento();
        avistamiento = iAvistamiento.findById(id).orElse(null);
        return avistamiento;
    }

    @Override
    public void delete(Long id) {
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