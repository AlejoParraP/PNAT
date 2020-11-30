package com.api.pnat.services;

import com.api.pnat.interfaces.ILugares;
import com.api.pnat.model.Lugares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugaresService{

	@Autowired
    ILugares iLugares;

    public List<Lugares> findAll() {
        return (List<Lugares>) iLugares.findAll();
    }

    public Lugares save(Lugares o) {
        return iLugares.save(o);
    }

    public Lugares findById(Integer id) {
        return iLugares.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        if (id > 0) {
            Lugares lugares = (Lugares) findById(id);
            if (lugares.getId_lugar() > 0) {
                iLugares.delete(lugares);
            }
        }
    }
}
