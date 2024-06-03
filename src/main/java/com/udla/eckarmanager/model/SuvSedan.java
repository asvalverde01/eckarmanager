package com.udla.eckarmanager.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@DiscriminatorValue("SUV_SEDAN")
@View(members =
    "Datos Generales[" +
    "marca, modelo, anio, color;" +
    "numeroPlaca, capacidadMotor, tipoMotor, traccion" +
    "]" +
    "Datos Específicos[" +
    "tipoAuto, nivelEquipamiento" +
    "]"
)
public class SuvSedan extends Auto {

    @Column(length = 50)
    private String tipoAuto;

    @Column(length = 50)
    private String nivelEquipamiento;

    // Getters y setters
    public String getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(String tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    public String getNivelEquipamiento() {
        return nivelEquipamiento;
    }

    public void setNivelEquipamiento(String nivelEquipamiento) {
        this.nivelEquipamiento = nivelEquipamiento;
    }

    // Método adicional
    public String descripcionCaracteristica() {
        return "Tipo: " + tipoAuto + ", Equipamiento: " + nivelEquipamiento;
    }
}
