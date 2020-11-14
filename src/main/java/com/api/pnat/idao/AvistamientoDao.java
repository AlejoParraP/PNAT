package com.api.pnat.idao;

import com.api.pnat.model.Avistamiento;

import java.util.List;
import java.util.Optional;

public interface AvistamientoDao {
    public List<Avistamiento> findAllEmpresas();


    public void save(Avistamiento avistamiento);

    public Avistamiento buscarAvistamiento(Long id);

    public void delete(Avistamiento id);

    List<Avistamiento> findById(Long id);
}