package com.api.pnat.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
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
	private Integer id_inmersion;

	@Getter
    @Setter
    @NotNull
    @Column(name = "inicio")
	private Date inicio;
	
	@Getter
    @Setter
    @NotNull
    @Column(name = "fin")
	private Date fin;
	
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
    @Column(name = "numero_avistamiento")
	private Integer numero_avistamiento;

	public Integer getId() {
		return id_inmersion;
	}

    @Getter
    @Setter
    @OneToMany(mappedBy = "inmersion")
    private List<AvistaPorInmersion> avistamientosPorInmersion = new ArrayList<AvistaPorInmersion>();

    @ManyToOne
    @JoinColumn(name = "id_lugar", referencedColumnName = "id_lugar")
    private Lugares lugares;

    @Getter
    @Setter
    @OneToMany(mappedBy = "inmersion")
    private List<UsuarioPorInmersion> usuarioPorInmersion = new ArrayList<UsuarioPorInmersion>();
}
