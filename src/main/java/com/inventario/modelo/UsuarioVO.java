package com.inventario.modelo;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table (name = "usuario")
public class UsuarioVO implements Serializable{
   
    private static final long serialVersionUID = 1L; 
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_usuario")
    private int id_usuario;
    
    @Column (name = "username")
    private String username;
    
    @Column (name = "correo")
    private String correo;
    
    @Column (name = "password")
    private String password;
    
    @Column (name = "estado")
    private String estado="Activo";
    
    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private RolVO rol;

    public UsuarioVO() {
    }

    public UsuarioVO(int id_usuario, String username, String correo, String password, String estado, RolVO rol) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.correo = correo;
        this.password = password;
        this.estado = estado;
        this.rol = rol;
    }
    
    
    

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public RolVO getRol() {
        return rol;
    }

    public void setRol(RolVO rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UsuarioVO{" + "id_usuario=" + id_usuario + ", username=" + username + ", correo=" + correo + ", password=" + password + ", estado=" + estado + ", rol=" + rol + '}';
    }

    
    
    
    
    
}
