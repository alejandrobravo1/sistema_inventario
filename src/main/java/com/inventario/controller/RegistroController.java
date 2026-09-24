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

    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        // 1. Obtener parámetros enviadas desde registro.jsp
        String username = request.getParameter("username");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // 2. Validar campos vacíos
        if (username == null || correo == null || password == null || 
            username.trim().isEmpty() || correo.trim().isEmpty() || password.trim().isEmpty()) {
            
            request.setAttribute("error", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("/registro.jsp").forward(request, response);
            return;
        }

        // 3. Validar coincidencia de contraseñas
        if (confirmPassword != null && !password.equals(confirmPassword)) {
            request.setAttribute("error", "Las contraseñas no coinciden.");
            request.getRequestDispatcher("/registro.jsp").forward(request, response);
            return;
        }

        RolVO rolPredeterminado = new RolVO(1, null, null);
         
        // 4. Crear objeto de dominio
        UsuarioVO nuevoUsuario = new UsuarioVO();
        nuevoUsuario.setUsername(username.trim());
        nuevoUsuario.setCorreo(correo.trim());
        nuevoUsuario.setPassword(password);
        nuevoUsuario.setEstado("Activo");
        nuevoUsuario.setRol(rolPredeterminado);

        // 5. Intentar guardar en la Base de Datos
        boolean registrado = usuarioDAO.registrarUsuario(nuevoUsuario);

        if (registrado) {
            // Éxito: Redirigir al inicio de sesión (login.jsp)
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
            // Error en BD o usuario/correo duplicado: Devolver al registro con el error
            request.setAttribute("error", "Error al registrar el usuario en la base de datos.");
            request.getRequestDispatcher("/registro.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirigir al registro si entran por GET
        response.sendRedirect(request.getContextPath() + "/registro.jsp");
    }
}