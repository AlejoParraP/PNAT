package com.api.pnat.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "Especies")
public class Especies implements Serializable {

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
}