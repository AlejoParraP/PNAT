package com.api.pnat.services;

import com.api.pnat.idao.IObjectCrudDao;
import com.api.pnat.idao.IQueryObject;
import com.api.pnat.interfaces.IAvistamiento;
import com.api.pnat.interfaces.IEspecies;
import com.api.pnat.model.Avistamiento;
import com.api.pnat.model.Especies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspeciesService implements IObjectCrudDao<Especies> {

	@Autowired
    IEspecies iEspecies;


    @Override
    public List<Especies> findAll() {
        return (List<Especies>) iEspecies.findAll();
    }

    @Override
    public void save(Especies o) {
    	Especies especies = new Especies();
    	especies = (Especies) o;
        iEspecies.save(especies);
    }

    @Override
    public Object findById(Long id) {
    	Especies especies = new Especies();
    	especies = iEspecies.findById(id).orElse(null);
        return especies;
    }

    @Override
    public void delete(Long id) {
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
