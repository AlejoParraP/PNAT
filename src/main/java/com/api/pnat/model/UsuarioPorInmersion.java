package com.api.pnat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import java.io.Serializable;
import lombok.Setter;

@Entity
@Table(name = "UsuarioPorInmersion")
public class UsuarioPorInmersion implements Serializable{

	public UsuarioPorInmersion() {
		
	}
	
	@Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuarioPorInmersion", nullable = false)
	private Integer id_usuarioPorInmersion;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "id_usuario")
	private Integer id_usuario;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "id_inmersion")
	private Integer id_inmersion;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "num_inmersiones")
	private Integer num_inmersiones;

	public Integer getId() {
		return id_usuarioPorInmersion;
	}
}
