package com.udla.eckarmanager.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@DiscriminatorValue("ELECTRICO")
@View(members =
    "Datos Generales[" +
    "marca, modelo, anio, color;" +
    "numeroPlaca, capacidadMotor, tipoMotor, traccion" +
    "]" +
    "Datos Específicos[" +
    "capacidadBateria, autonomiaKm" +
    "]"
)
public class Electrico extends Auto {

    private double capacidadBateria;
    private double autonomiaKm;

    // Getters y setters
    public double getCapacidadBateria() {
        return capacidadBateria;
    }

    public void setCapacidadBateria(double capacidadBateria) {
        this.capacidadBateria = capacidadBateria;
    }

    public double getAutonomiaKm() {
        return autonomiaKm;
    }

    public void setAutonomiaKm(double autonomiaKm) {
        this.autonomiaKm = autonomiaKm;
    }

    // Método adicional
    public String estadoBateria() {
        return "Capacidad de Batería: " + capacidadBateria + "kWh, Autonomía: " + autonomiaKm + "km";
    }
}
