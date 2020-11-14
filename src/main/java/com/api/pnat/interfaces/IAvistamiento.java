package com.api.pnat.interfaces;


import com.api.pnat.model.Avistamiento;
import org.springframework.data.repository.CrudRepository;

public interface IAvistamiento extends CrudRepository<Avistamiento, Long> {

//    public Empresa findByIdEmpresaAndNombre(int id, String nombre);
}
