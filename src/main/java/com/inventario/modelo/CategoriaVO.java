package com.inventario.modelo;

import jakarta.persistence.*;

@Entity
@Table (name = "categoria")
public class CategoriaVO { 
    @Id
    @Column (name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;
    @Column (name = "nombre_categoria")
    private String nombre_categoria;

    public CategoriaVO() {
    }

    public CategoriaVO(int id_categoria, String nombre_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    @Override
    public String toString() {
        return "CategoriaVO{" + "id_categoria=" + id_categoria + ", nombre_categoria=" + nombre_categoria + '}';
    }

}
