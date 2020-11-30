package com.api.pnat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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


	@Getter
	@Setter
	@NotNull
	@Column(name = "puntuacion")
	private Integer puntuacion;

	@Getter
	@Setter
	@NotNull
	@Column(name = "url_foto")
	private String url_foto;

	@Getter
	@Setter
	@NotNull
	@Column(name = "id_lugar")
	private Integer id_lugar;

	@Getter
	@Setter
	@NotNull
	@Column(name = "inicio")
	private Date inicio;

	@Getter
	@Setter
	@NotNull
	@Column(name = "id_inmersion")
	private Date Fin;


	public Integer getId() {
		return id_avisPorInmersion;
	}

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "id_avistamiento", referencedColumnName = "id_avistamiento"),
			@JoinColumn(name = "url_foto", referencedColumnName = "url_foto"),
			@JoinColumn(name = "puntuacion", referencedColumnName = "puntuacion")
	})
	private Avistamiento avistamiento;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "id_inmersion", referencedColumnName = "id_inmersion"),
			@JoinColumn(name = "inicio", referencedColumnName = "inicio"),
			@JoinColumn(name = "fin", referencedColumnName = "fin"),
			@JoinColumn(name = "id_lugar", referencedColumnName = "id_lugar")
	})
	private Inmersion inmersion;

}
