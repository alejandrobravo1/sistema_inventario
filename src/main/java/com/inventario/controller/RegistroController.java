package com.inventario.controller;

import com.inventario.dao.UsuarioDAO;
import com.inventario.modelo.RolVO;
import com.inventario.modelo.UsuarioVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistroController")
public class RegistroController extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // 1. Validar campos vacíos
        if (username == null || correo == null || password == null || 
            username.trim().isEmpty() || correo.trim().isEmpty() || password.trim().isEmpty()) {
            
            request.setAttribute("error", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }

        // 2. Coincidencia de contraseñas
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Las contraseñas no coinciden.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
         RolVO rolPredeterminado = new RolVO(1 , null, null);
         
        // 3. Crear objeto asignando el estado "ACTIVO" por defecto
        UsuarioVO nuevoUsuario = new UsuarioVO();
        nuevoUsuario.setUsername(username.trim());
        nuevoUsuario.setCorreo(correo.trim());
        nuevoUsuario.setPassword(password);
        nuevoUsuario.setEstado("Activo");
        nuevoUsuario.setRol(rolPredeterminado);

        // 4. Intentar registro mediante DAO
        boolean registrado = usuarioDAO.registrarUsuario(nuevoUsuario);

        if (registrado) {
            response.sendRedirect("login.jsp?exito=1");
        } else {
            request.setAttribute("error", "Error al registrar el usuario. Intenta de nuevo.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}