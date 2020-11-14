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
@Table(name = "Lugares")
public class Lugares implements Serializable{

	public Lugares() {
		
	}
	
	@Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lugar", nullable = false)
	private Integer id_lugar;
	
	@Getter
    @Setter
    @Column(name = "id_padre")
	private Integer id_padre;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "tipo_lugar")
	private String tipo_lugar;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "nombre_lugar")
	private String nombre_lugar;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "descripcion")
	private String descripcion;

	public Integer getId() {
		return id_lugar;
	}
}
