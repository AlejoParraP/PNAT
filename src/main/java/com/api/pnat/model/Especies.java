package com.api.pnat.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Especies")
public class Especies implements Serializable {

    public Especies() {
    }

    @Getter
    @Setter
    @OneToMany(targetEntity =Avistamiento.class)
    private List<Avistamiento> avistamientos = new ArrayList<Avistamiento>();

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especie", nullable = false)
    private Integer id_especie;

    @Getter
    @Setter
    @NotNull
    @Column(name = "grupo")
    private String grupo;

    @Getter
    @Setter
    @NotNull
    @Column(name = "orden")
    private String orden;

    @Getter
    @Setter
    @NotNull
    @Column(name = "familia")
    private String familia;

    @Getter
    @Setter
    @NotNull
    @Column(name = "nombre_cientifico")
    private String nombre_cientifico;

    @Getter
    @Setter
    @NotNull
    @Column(name = "zona")
    private String zona;

}