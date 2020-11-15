package com.api.pnat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "avistamiento")
public class Avistamiento implements Serializable {

    public Avistamiento() {
    }


    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Getter
    @Setter
    @Size(min = 3, max = 50)
    @Column(name = "url_foto")
    private String url_foto;


    @Getter
    @Setter
    @Size(min = 3, max = 50)
    @Column(name = "description")
    private String description;


    @Getter
    @Setter
    @NotNull
    @Column(name = "id_especie")
    private int id_especie;


    @Getter
    @Setter
    @Size(min = 3, max = 50)
    @NotNull
    @Column(name = "visibilidad")
    private String visibilidad;


    @Getter
    @Setter
    @NotNull
    @Column(name = "profundidad")
    private float profundidad;


    @Getter
    @Setter
    @Size(min = 3, max = 50)
    @NotNull
    @Column(name = "comportamiento_inicial")
    private String comportamiento_inicial;


    @Getter
    @Setter
    @Size(min = 3, max = 50)
    @NotNull
    @Column(name = "comportamiento_final")
    private String comportamiento_final;


    @Getter
    @Setter
    @Size(min = 3, max = 50)
    @NotNull
    @Column(name = "tamanio")
    private String tamanio;


    @Getter
    @Setter
    @Size(min = 3, max = 50)
    @NotNull
    @Column(name = "puntos")
    private Integer puntos;


	public Integer getId() {
		return id;
	}

    //    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idEmpresa")
//    private List<RutaEmpresa> rutaEmpresaList;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idEmpresa")
//    private List<Persona> personaList;
//}
}


