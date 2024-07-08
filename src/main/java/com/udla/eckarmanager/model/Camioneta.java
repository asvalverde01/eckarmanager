package com.udla.eckarmanager.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@DiscriminatorValue("CAMIONETA")
@Data
@View(members =
    "Datos Generales[" +
    "marca, modelo, anio, color;" +
    "numeroPlaca, capacidadMotor, tipoMotor, traccion;" +
    "propietario" +
    "];" +
    "Datos Específicos[" +
    "capacidadCargaKg, dobleCabina" +
    "]"
)
public class Camioneta extends Auto {

    private double capacidadCargaKg;
    private boolean dobleCabina;

    public String detalleCarga() {
        return "Capacidad de Carga: " + capacidadCargaKg + "kg, Doble Cabina: " + (dobleCabina ? "Sí" : "No");
    }
}
