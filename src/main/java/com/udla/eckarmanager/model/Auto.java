package com.udla.eckarmanager.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name = "auto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@View(members =
    "marca, modelo, anio, color;" +
    "numeroPlaca, capacidadMotor, tipoMotor, traccion"
)
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String marca;

    @Column(length = 50)
    private String modelo;

    private int anio;

    @Column(length = 20)
    private String color;

    @Column(length = 20, unique = true)
    private String numeroPlaca;

    private double capacidadMotor;

    @Column(length = 20)
    private String tipoMotor;

    private boolean traccion;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public double getCapacidadMotor() {
        return capacidadMotor;
    }

    public void setCapacidadMotor(double capacidadMotor) {
        this.capacidadMotor = capacidadMotor;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public boolean isTraccion() {
        return traccion;
    }

    public void setTraccion(boolean traccion) {
        this.traccion = traccion;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
