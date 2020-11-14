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
@Table(name = "Usuario")
public class Usuario implements Serializable{

	public Usuario() {
		
	}
	
	@Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
	private Integer id_usuario;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "nombre_usuario")
	private String nombre_usuario;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "correo")
	private String correo;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "tipo_usuario")
	private String tipo_usuario;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "nacionalidad")
	private String nacionalidad;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "UrlFoto")
	private String UrlFoto;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "contrasena")
	private String contrasena;

	public Integer getId() {
		return id_usuario;
	}
	
}
