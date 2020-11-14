package com.api.pnat.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Especies")
public class Especies implements Serializable{

	public Especies() {
		
	}

	@Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especie", nullable = false)
	private Integer id_especie;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "nombre_especie")
	private String nombre_especie;

	@Getter
    @Setter
    @NotNull
    @Column(name = "descripcion")
	private String descripcion;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "tamanio_maximo")
	private String tamanio_maximo;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "tamanio_minimo")
	private String tamanio_minimo;

	public Integer getId() {
		return id_especie;
	}
}
