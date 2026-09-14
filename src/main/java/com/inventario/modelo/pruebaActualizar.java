package com.inventario.modelo;

import com.inventario.dao.UsuarioDAO;

public class pruebaActualizar {

    public static void main(String[] args) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        int idAEditar = 1;

        // 1. Obtener el usuario existente
        UsuarioVO usuario = usuarioDao.buscarUsuarioxId(idAEditar);

        if (usuario != null) {
            // 2. Modificar los atributos necesarios
            usuario.setUsername("osman_editado");
            usuario.setCorreo("osman_nuevo@correo.com");
            usuario.setPassword("nuevaClave456");

            // 3. Ejecutar la actualización
            boolean actualizado = usuarioDao.actualizar(usuario);

            System.out.println("----------------------------------------");
            if (actualizado) {
                System.out.println(" ¡USUARIO ACTUALIZADO CON ÉXITO!");
            } else {
                System.out.println(" Falló la actualización del usuario.");
            }
            System.out.println("----------------------------------------");
        } else {
            System.out.println("No existe el usuario con ID: " + idAEditar);
        }
    }
}