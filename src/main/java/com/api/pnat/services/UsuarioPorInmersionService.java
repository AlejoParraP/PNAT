package com.api.pnat.services;

import com.api.pnat.interfaces.IUsuarioPorInmersion;
import com.api.pnat.model.UsuarioPorInmersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioPorInmersionService{

	@Autowired
    IUsuarioPorInmersion iUsuarioPorInmersion;


    
    public List<UsuarioPorInmersion> findAll() {
        return (List<UsuarioPorInmersion>) iUsuarioPorInmersion.findAll();
    }

    
    public void save(UsuarioPorInmersion o) {
    	UsuarioPorInmersion usuarioPorInmersion = new UsuarioPorInmersion();
    	usuarioPorInmersion = (UsuarioPorInmersion) o;
        iUsuarioPorInmersion.save(usuarioPorInmersion);
    }

    
    public Object findById(Long id) {
    	UsuarioPorInmersion usuarioPorInmersion = new UsuarioPorInmersion();
    	usuarioPorInmersion = iUsuarioPorInmersion.findById(id).orElse(null);
        return usuarioPorInmersion;
    }

    
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
