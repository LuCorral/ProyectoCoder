package com.coderhouse.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Ventas venta;
    
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Ventas getVentas() {
        return venta;
    }

    public void setVentas(Ventas venta) {
        this.venta = venta;
    }

    public Producto(Long id, String nombre, double precio, int cantidad) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto() {
        super();
        // TODO Auto-generated constructor stub
    }
}


/*
package com.coderhouse.entity;
import javax.persistence.*;
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;
    private int cantidad;
    
    @ManyToOne
    @JoinColumn(name="venta_id")
    private Ventas venta;
    
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Producto(Long id, String nombre, double precio, int cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
   
}
*/