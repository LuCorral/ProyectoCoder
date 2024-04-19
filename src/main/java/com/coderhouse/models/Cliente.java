package com.coderhouse.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Ventas> ventas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ventas> getVentas() {
        return ventas;
    }

    public void setVentas(List<Ventas> ventas) {
        this.ventas = ventas;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente() {
        super();
     // TODO Auto-generated constructor stub
    }

    public Cliente(Long id, String nombre, String apellido, String email) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }  
}





