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
@Table(name = "Inmersion")
public class Inmersion implements Serializable{

	public Inmersion() {
		
	}
	
	@Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inmersion", nullable = false)
	private Integer Id_Inmersion;

	@Getter
    @Setter
    @NotNull
    @Column(name = "Inicio")
	private Date Inicio;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "Fin")
	private Date Fin;       
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "TemperaturaAgua")
	private Integer TemperaturaAgua; 
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "ProfundidadMax")
	private float ProfundidadMax;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "Avistamiento")
	private Boolean Avistamiento;   
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "Longitud")
	private float Longitud;                             
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "Latitud")
	private float Latitud;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "Visibilidad")
	private String Visibilidad;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "AireInicial")
	private float AireInicial;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "AireFinal")
	private float AireFinal;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "Observaciones")
	private String Observaciones;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "Id_lugar")
	private Integer Id_lugar;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "Numero_Avistamiento")
	private Integer Numero_Avistamiento;

	public Integer getId() {
		return Id_Inmersion;
	}

	
	
	
}
