package com.inventario.modelo;

import com.inventario.dao.UsuarioDAO;

public class pruebaBuscarxId {

    public static void main(String[] args) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        int idABuscar = 1;

        UsuarioVO usuario = usuarioDao.buscarUsuarioxId(idABuscar);

        System.out.println("----------------------------------------");
        if (usuario != null) {
            System.out.println("USUARIO ENCONTRADO:");
            System.out.println("ID: " + usuario.getId_usuario());
            System.out.println("Username: " + usuario.getUsername());
            System.out.println("Correo: " + usuario.getCorreo());
            System.out.println("Estado: " + usuario.getEstado());
            System.out.println("Rol: " + usuario.getRol().getNombre_rol());
        } else {
            System.out.println("No se encontró ningún usuario con el ID: " + idABuscar);
        }
        System.out.println("----------------------------------------");
    }
}