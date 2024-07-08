package com.udla.eckarmanager.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Table(name = "auto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@Data
@View(members =
    "marca, modelo, anio, color;" +
    "numeroPlaca, capacidadMotor, tipoMotor, traccion;" +
    "propietario"
)
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 50)
    private String marca;

    @NotNull
    @Column(length = 50)
    private String modelo;

    @Min(1886) // Año del primer automóvil
    private int anio;

    @Column(length = 20)
    private String color;

    @NotNull
    @Column(length = 20, unique = true)
    private String numeroPlaca;

    @Min(0)
    private double capacidadMotor;

    @Column(length = 20)
    private String tipoMotor;

    private boolean traccion;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    @ReferenceView("Simple")
    private Propietario propietario;
}
