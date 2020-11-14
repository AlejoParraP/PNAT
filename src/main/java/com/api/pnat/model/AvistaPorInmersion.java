package com.api.pnat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AvistaPorInmersion")
public class AvistaPorInmersion implements Serializable{

	public AvistaPorInmersion() {	
	
	}
	
	@Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avisPorInmersion", nullable = false)
	private Integer id_avisPorInmersion;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "id_avistamiento")
	private Integer id_avistamiento;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "id_inmersion")
	private Integer id_inmersion;

	public Integer getId() {
		return id_avisPorInmersion;
	}		
}
