package com.inventario.modelo;

import com.inventario.dao.UsuarioDAO;

public class prueba_eliminar {

    public static void main(String[] args) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        int idAEliminar = 1;

        boolean eliminado = usuarioDao.eliminar(idAEliminar);

        System.out.println("----------------------------------------");
        if (eliminado) {
            System.out.println(" ¡USUARIO " + idAEliminar + " ELIMINADO CON ÉXITO!");
        } else {
            System.out.println(" No se pudo eliminar. El ID " + idAEliminar + " no existe.");
        }
        System.out.println("----------------------------------------");
    }
}