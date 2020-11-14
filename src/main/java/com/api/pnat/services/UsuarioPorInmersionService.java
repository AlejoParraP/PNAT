package com.api.pnat.services;

import com.api.pnat.idao.IObjectCrudDao;
import com.api.pnat.idao.IQueryObject;
import com.api.pnat.interfaces.IAvistamiento;
import com.api.pnat.interfaces.IUsuarioPorInmersion;
import com.api.pnat.model.Avistamiento;
import com.api.pnat.model.Especies;
import com.api.pnat.model.UsuarioPorInmersion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioPorInmersionService implements IObjectCrudDao<UsuarioPorInmersion>{

	@Autowired
    IUsuarioPorInmersion iUsuarioPorInmersion;


    @Override
    public List<UsuarioPorInmersion> findAll() {
        return (List<UsuarioPorInmersion>) iUsuarioPorInmersion.findAll();
    }

    @Override
    public void save(UsuarioPorInmersion o) {
    	UsuarioPorInmersion usuarioPorInmersion = new UsuarioPorInmersion();
    	usuarioPorInmersion = (UsuarioPorInmersion) o;
        iUsuarioPorInmersion.save(usuarioPorInmersion);
    }

    @Override
    public Object findById(Long id) {
    	UsuarioPorInmersion usuarioPorInmersion = new UsuarioPorInmersion();
    	usuarioPorInmersion = iUsuarioPorInmersion.findById(id).orElse(null);
        return usuarioPorInmersion;
    }

    @Override
    public void delete(Long id) {
        if (id > 0) {
        	UsuarioPorInmersion usuarioPorInmersion = new UsuarioPorInmersion();
        	usuarioPorInmersion = (UsuarioPorInmersion) findById(id);
            //Metodo Get Requerido del modelo
            if (usuarioPorInmersion.getId() > 0) {
                iUsuarioPorInmersion.delete(usuarioPorInmersion);
            }
        }
    }
}
