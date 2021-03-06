package com.api.pnat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;

import java.io.Serializable;

import lombok.Setter;

@Entity
@Table(name = "UsuarioPorInmersion")
public class UsuarioPorInmersion implements Serializable {

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
    @Column(name = "numero_avistamiento")
    private Integer numero_avistamiento;


    @ManyToOne
    @JoinColumn(name = "id_inmersion")
    private Inmersion inmersion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;
}
