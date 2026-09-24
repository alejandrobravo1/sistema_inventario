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

    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        // Inicializar el DAO
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // 1. Obtener parámetros del formulario JSP
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2. Validar con el DAO
        UsuarioVO usuario = usuarioDAO.validarLogin(username, password);

        if (usuario != null) {
            // 3. Crear la sesión del usuario
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", usuario);
            session.setAttribute("nombreUsuario", usuario.getUsername());

            // 4. Redirigir al dashboard en lugar de escribir JSON
            response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
        } else {
            // 5. Si las credenciales son incorrectas, volver al login mostrando el error
            request.setAttribute("error", "Error en la autenticación: Credenciales incorrectas.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}