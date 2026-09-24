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
@Table (name = " marca")
public class MarcaVO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_marca")
    private int id_marca;
    @Column (name = "id_marca")
    private String nombre_marca;

    public MarcaVO() {
    }

    public MarcaVO(int id_marca, String nombre_marca) {
        this.id_marca = id_marca;
        this.nombre_marca = nombre_marca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    @Override
    public String toString() {
        return "MarcaVO{" + "id_marca=" + id_marca + ", nombre_marca=" + nombre_marca + '}';
    }
    
    
}
