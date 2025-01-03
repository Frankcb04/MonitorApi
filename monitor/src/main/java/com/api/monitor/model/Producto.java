package com.api.monitor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.Min;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identificador único del producto

    @Column(nullable = false, length = 100)
    private String nombre;  // Nombre del producto

    @Column(nullable = false)
    private int stock;  // Cantidad de stock disponible

    @Column(nullable = false)
    @Min(value = 0, message = "El umbral debe ser mayor o igual a cero")
    private int umbral;  // Umbral mínimo de stock para disparar alertas

    @Column(nullable = false)
    private double precio;  // Precio del producto

    @Column(length = 255)
    private String descripcion;

    // Constructor vacío
    public Producto() {}

    // Constructor con todos los parámetros
    public Producto(String nombre, int stock, int umbral, double precio, String descripcion) {
        this.nombre = nombre;
        this.stock = stock;
        this.umbral = umbral;
        this.precio = precio;
        this.descripcion = descripcion;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getUmbral() {
        return umbral;
    }

    public void setUmbral(int umbral) {
        this.umbral = umbral;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para reducir el stock, útil para cuando se vendan productos
    public void reducirStock(int cantidad) {
        if (cantidad <= stock) {
            this.stock -= cantidad;
        } else {
            throw new IllegalArgumentException("No hay suficiente stock");
        }
    }

    // Método para agregar stock
    public void agregarStock(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
        } else {
            throw new IllegalArgumentException("La cantidad a agregar debe ser mayor a cero");
        }
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", umbral=" + umbral +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
