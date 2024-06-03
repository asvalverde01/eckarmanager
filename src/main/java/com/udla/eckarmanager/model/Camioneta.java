package com.udla.eckarmanager.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@DiscriminatorValue("CAMIONETA")
@View(members =
    "Datos Generales[" +
    "marca, modelo, anio, color;" +
    "numeroPlaca, capacidadMotor, tipoMotor, traccion" +
    "]" +
    "Datos Específicos[" +
    "capacidadCargaKg, dobleCabina" +
    "]"
)
public class Camioneta extends Auto {

    private double capacidadCargaKg;
    private boolean dobleCabina;

    // Getters y setters
    public double getCapacidadCargaKg() {
        return capacidadCargaKg;
    }

    public void setCapacidadCargaKg(double capacidadCargaKg) {
        this.capacidadCargaKg = capacidadCargaKg;
    }

    public boolean isDobleCabina() {
        return dobleCabina;
    }

    public void setDobleCabina(boolean dobleCabina) {
        this.dobleCabina = dobleCabina;
    }

    // Método adicional
    public String detalleCarga() {
        return "Capacidad de Carga: " + capacidadCargaKg + "kg, Doble Cabina: " + (dobleCabina ? "Sí" : "No");
    }
}
