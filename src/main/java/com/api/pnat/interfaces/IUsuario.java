package com.api.pnat.interfaces;

import com.api.pnat.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends CrudRepository<Usuario, Long>{

}
