package com.api.pnat.interfaces;

import com.api.pnat.model.Avistamiento;
import com.api.pnat.model.Especies;
import org.springframework.data.repository.CrudRepository;


public interface IEspecies extends CrudRepository<Especies, Long> {

}
