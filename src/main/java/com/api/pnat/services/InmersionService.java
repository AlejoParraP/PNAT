package com.api.pnat.services;

import com.api.pnat.idao.IObjectCrudDao;
import com.api.pnat.idao.IQueryObject;
import com.api.pnat.interfaces.IInmersion;
import com.api.pnat.model.Inmersion;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InmersionService implements IObjectCrudDao<Inmersion> {

	IInmersion iInmersion;
	
	@Override
    public List<Inmersion> findAll() {
        return (List<Inmersion>) iInmersion.findAll();
    }

    @Override
    public void save(Inmersion o) {
    	Inmersion inmersion = new Inmersion();
    	inmersion = (Inmersion) o;
    	iInmersion.save(inmersion);
    	
    }

    @Override
    public Object findById(Long id) {
        Inmersion inmersion = new Inmersion();
        inmersion = iInmersion.findById(id).orElse(null);
        return inmersion;
    }

    @Override
    public void delete(Long id) {
        if (id > 0) {
            Inmersion inmersion = new Inmersion();
            inmersion = (Inmersion) findById(id);
            //Metodo Get Requerido del modelo
            if (inmersion.getId() > 0) {
                iInmersion.delete(inmersion);
            }
        }
    }


	
}
