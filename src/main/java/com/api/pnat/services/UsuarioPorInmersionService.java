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

    public UsuarioPorInmersion save(UsuarioPorInmersion o) {
        return iUsuarioPorInmersion.save(o);
    }

    public UsuarioPorInmersion findById(Integer id) {
        return iUsuarioPorInmersion.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        if (id > 0) {
            UsuarioPorInmersion upi = (UsuarioPorInmersion) findById(id);
            if (upi.getId_usuarioPorInmersion() > 0) {
                iUsuarioPorInmersion.delete(upi);
            }
        }
    }
}
