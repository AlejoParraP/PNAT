package com.api.pnat.services;

import com.api.pnat.idao.IObjectCrudDao;
import com.api.pnat.idao.IQueryObject;
import com.api.pnat.interfaces.IAvistamiento;
import com.api.pnat.interfaces.IUsuario;
import com.api.pnat.model.Avistamiento;
import com.api.pnat.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService implements IObjectCrudDao<Usuario>{

	@Autowired
    IUsuario iUsuario;


    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) iUsuario.findAll();
    }

    @Override
    public void save(Usuario o) {
        Usuario usuario = new Usuario();
        usuario = (Usuario) o;
        iUsuario.save(usuario);
    }

    @Override
    public Object findById(Long id) {
    	Usuario usuario = new Usuario();
    	usuario = iUsuario.findById(id).orElse(null);
        return usuario;
    }

    @Override
    public void delete(Long id) {
        if (id > 0) {
        	Usuario usuario = new Usuario();
            usuario = (Usuario) findById(id);
            //Metodo Get Requerido del modelo
            if (usuario.getId() > 0) {
                iUsuario.delete(usuario);
            }
        }
    }
	
}
