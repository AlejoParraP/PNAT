package com.api.pnat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AvistaPorInmersion")
public class AvistaPorInmersion implements Serializable {

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
    @Column(name = "fin")
    private Date Fin;


    @ManyToOne
    @JoinColumn(name = "id_avistamiento")
    private Avistamiento avistamiento;

    @ManyToOne
    @JoinColumn(name = "id_inmersion")
    private Inmersion inmersion;

}
