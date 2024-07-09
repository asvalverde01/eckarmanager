package com.udla.eckarmanager.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Table(name = "electrico")
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
    "capacidadBateria, autonomiaKm" +
    "]"
)
public class Electrico extends Auto {

    private double capacidadBateria;
    private double autonomiaKm;

    public String estadoBateria() {
        return "Capacidad de Batería: " + capacidadBateria + "kWh, Autonomía: " + autonomiaKm + "km";
    }
}
