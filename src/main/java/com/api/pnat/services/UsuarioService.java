package com.api.pnat.services;

import com.api.pnat.interfaces.IUsuario;
import com.api.pnat.model.Especies;
import com.api.pnat.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService{

	@Autowired
    IUsuario iUsuario;

	public List<Usuario> findAll() {
        return (List<Usuario>) iUsuario.findAll();
    }

    public Usuario save(Usuario o) {
        return iUsuario.save(o);
    }

    public Usuario findById(Integer id) {
    	return iUsuario.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        if (id > 0) {
            Usuario usuario = (Usuario) findById(id);
            if (usuario.getId_usuario() > 0) {
                iUsuario.delete(usuario);
            }
        }
    }
	
}
