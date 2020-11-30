package com.api.pnat.services;

import com.api.pnat.interfaces.IEspecies;
import com.api.pnat.model.Especies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EspeciesService {

    @Autowired
    IEspecies iEspecies;

    public List<Especies> findAll() {
        return (List<Especies>) iEspecies.findAll();
    }

    public Especies save(Especies o) {
        return iEspecies.save(o);
    }	

    public Especies findById(Integer id) {
        return iEspecies.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        if (id > 0) {
            Especies especies = (Especies) findById(id);
            if (especies.getId_especie() > 0) {
                iEspecies.delete(especies);
            }
        }
    }
}