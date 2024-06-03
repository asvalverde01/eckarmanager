package com.udla.eckarmanager.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Table(name = "propietario")
@View(members = 
    "datosPersonales {nombre, apellido, cedula, direccion, telefono, email};" +
    "gestionAutos {autos}"
)
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
    private Collection<Auto> autos;

    // Constructor
    public Propietario() {
        this.autos = new ArrayList<>();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Collection<Auto> getAutos() {
        return autos;
    }

    public void setAutos(Collection<Auto> autos) {
        this.autos = autos;
    }

    // Métodos de negocio relacionados con la gestión de autos
    @Transient
    public void asociarAuto(Auto auto) {
        auto.setPropietario(this);
        this.autos.add(auto);
    }

    @Transient
    public void desasociarAuto(Auto auto) {
        auto.setPropietario(null);
        this.autos.remove(auto);
    }
}
