package com.api.pnat.services;

import com.api.pnat.idao.IObjectCrudDao;
import com.api.pnat.idao.IQueryObject;

import com.api.pnat.interfaces.ILugares;
import com.api.pnat.model.Avistamiento;
import com.api.pnat.model.Lugares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugaresService implements IObjectCrudDao<Lugares>{

	@Autowired
    ILugares iLugares;


    @Override
    public List<Lugares> findAll() {
        return (List<Lugares>) iLugares.findAll();
    }

    @Override
    public void save(Lugares o) {
    	Lugares lugares = new Lugares();
        lugares = (Lugares) o;
        iLugares.save(lugares);
    }

    @Override
    public Object findById(Long id) {
    	Lugares lugares = new Lugares();
        lugares = iLugares.findById(id).orElse(null);
        return lugares;
    }

    @Override
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
