package com.udla.eckarmanager.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Table(name = "suvsedan")
@PrimaryKeyJoinColumn(name = "auto_id")
@Data
@EqualsAndHashCode(callSuper = true) // Evitar recursión en equals y hashCode
@View(members =
    "Datos Generales[" +
    "marca, modelo, anio, color;" +
    "numeroPlaca, capacidadMotor, tipoMotor, traccion;" +
    "propietario" +
    "];" +
    "Datos Específicos[" +
    "tipoAuto, nivelEquipamiento" +
    "]"
)
public class SuvSedan extends Auto {

    @Column(length = 50)
    private String tipoAuto;

    @Column(length = 50)
    private String nivelEquipamiento;

    public String descripcionCaracteristica() {
        return "Tipo: " + tipoAuto + ", Equipamiento: " + nivelEquipamiento;
    }
}
