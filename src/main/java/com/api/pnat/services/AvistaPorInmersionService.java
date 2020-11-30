package com.api.pnat.services;

import com.api.pnat.interfaces.IAvistaPorInmersion;
import com.api.pnat.model.AvistaPorInmersion;
import com.api.pnat.model.Especies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvistaPorInmersionService {

	@Autowired
    IAvistaPorInmersion iAvistaPorInmersion;

    public List<AvistaPorInmersion> findAll() {
        return (List<AvistaPorInmersion>) iAvistaPorInmersion.findAll();
    }

    public AvistaPorInmersion save(AvistaPorInmersion o) {
    	return iAvistaPorInmersion.save(o);
    }

    public AvistaPorInmersion findById(Integer id) {
    	return iAvistaPorInmersion.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        if (id > 0) {
            AvistaPorInmersion api = (AvistaPorInmersion) findById(id);
            if (api.getId_avisPorInmersion() > 0) {
                iAvistaPorInmersion.delete(api);
            }
        }
    }
}
