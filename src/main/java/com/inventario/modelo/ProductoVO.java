/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.modelo;

import jakarta.persistence.*;

/**
 *
 * @author osals
 */
@Entity
@Table (name = "producto")
public class ProductoVO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private String id_producto;
    
    @Column(name = "codigo_barras")
    private String codigo_barras;
    
    @Column(name = "nombre_producto")
    private float nombre_producto;
    
    @Column(name = "precio_cop")
    private int precio_cop;
    
    @Column(name = "stock_actual")
    private int stock_actual;
    
  
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaVO id_categoria;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private MarcaVO id_marca;
    


    public ProductoVO() {
    }

    public ProductoVO(String id_producto, String codigo_barras, float nombre_producto, int precio_cop, int stock_actual, CategoriaVO id_categoria, MarcaVO id_marca) {
        this.id_producto = id_producto;
        this.codigo_barras = codigo_barras;
        this.nombre_producto = nombre_producto;
        this.precio_cop = precio_cop;
        this.stock_actual = stock_actual;
        this.id_categoria = id_categoria;
        this.id_marca = id_marca;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public float getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(float nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getPrecio_cop() {
        return precio_cop;
    }

    public void setPrecio_cop(int precio_cop) {
        this.precio_cop = precio_cop;
    }

    public int getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    public CategoriaVO getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(CategoriaVO id_categoria) {
        this.id_categoria = id_categoria;
    }

    public MarcaVO getId_marca() {
        return id_marca;
    }

    public void setId_marca(MarcaVO id_marca) {
        this.id_marca = id_marca;
    }

    @Override
    public String toString() {
        return "ProductoVO{" + "id_producto=" + id_producto + ", codigo_barras=" + codigo_barras + ", nombre_producto=" + nombre_producto + ", precio_cop=" + precio_cop + ", stock_actual=" + stock_actual + ", id_categoria=" + id_categoria + ", id_marca=" + id_marca + '}';
    }
    
    
 
}
