package com.inventario.controller;

import com.inventario.dao.UsuarioDAO;
import com.inventario.modelo.UsuarioVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginController")
public class loginController extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        // Inicializamos el DAO de Hibernate
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // 1. Capturar parámetros del formulario
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2. Validar credenciales con el DAO
        UsuarioVO usuario = usuarioDAO.validarLogin(username, password);

        if (usuario != null) {
            // 3. Autenticación exitosa: Crear sesión de usuario
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", usuario);
            session.setAttribute("nombreUsuario", usuario.getUsername());

            // Redirigir al panel principal o dashboard
            response.sendRedirect("dashboard.jsp");
        } else {
            // 4. Autenticación fallida: Enviar mensaje a la vista
            request.setAttribute("error", "Error en la autenticación: Credenciales incorrectas.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}