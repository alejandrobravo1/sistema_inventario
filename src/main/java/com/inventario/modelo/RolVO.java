/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.modelo;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 *
 * @author osals
 */
@Entity
@Table (name = "rol")
public class RolVO implements Serializable {
    private static final long serialVersionUID = 1L; // Recomendado para Serializable
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_rol")
    private int id_rol ;
    
    
    @Column (name = "nombre_rol")
    private String nombre_rol ;
    
    @Column (name = "descripcion")
    private String descripcion ;
    
    public RolVO (){
        
    }

    public RolVO(int id_rol, String nombre_rol, String descripcion) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.descripcion = descripcion;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "RolVO{" + "id_rol=" + id_rol + ", nombre_rol=" + nombre_rol + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
