package com.udla.eckarmanager.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Table(name = "propietario")
@Data
@View(members = 
    "datosPersonales {nombre, apellido, cedula, direccion, telefono, email};" +
    "gestionAutos {autos}"
)
@View(name = "Simple", members = "nombre, apellido, cedula")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String apellido;

    @Column(length = 100)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    @Column(length = 50)
    private String email;

    @Column(length = 10, unique = true)
    private String cedula;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    @ListProperties("marca, modelo, anio, color, numeroPlaca")
    private Collection<Auto> autos = new ArrayList<>();

    @Transient
    public void asociarAuto(Auto auto) {
        if (auto != null && !this.autos.contains(auto)) {
            auto.setPropietario(this);
            this.autos.add(auto);
        }
    }

    @Transient
    public void desasociarAuto(Auto auto) {
        if (auto != null && this.autos.contains(auto)) {
            auto.setPropietario(null);
            this.autos.remove(auto);
        }
    }
}
