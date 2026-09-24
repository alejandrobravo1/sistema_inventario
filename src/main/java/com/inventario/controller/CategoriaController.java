package com.inventario.controller;

import com.inventario.dao.CategoriaDAO;
import com.inventario.modelo.CategoriaVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/CategoriaController")
public class CategoriaController extends HttpServlet {

    private CategoriaDAO categoriaDAO;

    @Override
    public void init() throws ServletException {
        // Inicializamos el DAO al arrancar el Servlet
        categoriaDAO = new CategoriaDAO();
    }

 // ==========================================
    // 2. CREAR Y GUARDAR DATO (Peticiones POST)
    // ==========================================
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        // Captura el name="nombre" del formulario en registrarCategoria.jsp
        String nombreCat = request.getParameter("nombre");

        if (nombreCat != null && !nombreCat.trim().isEmpty()) {
            
            CategoriaVO categoria = new CategoriaVO();
            categoria.setNombre_categoria(nombreCat.trim());

            // Llama a tu método en CategoriaDAO
            boolean insertado = categoriaDAO.registrarCategoria(categoria);
            

        if (insertado) {
            System.out.println("3. Guardando mensaje en la Sesión y redirigiendo...");

            // 1. Guardamos el mensaje en la sesión del usuario
            HttpSession session = request.getSession();
            session.setAttribute("exito", "Categoría creada exitosamente.");

            // 2. Redirigimos de forma limpia a la vista (Patrón PRG: Post/Redirect/Get)
            response.sendRedirect(request.getContextPath() + "/registrarCategoria.jsp");
        } else {
            System.out.println("3. Falló la inserción en la BD.");
            request.setAttribute("error", "Ocurrió un fallo al intentar registrar la categoría en la BD.");
            request.getRequestDispatcher("/registrarCategoria.jsp").forward(request, response);
        }

        } else {
            request.setAttribute("error", "El nombre de la categoría es obligatorio.");
            request.getRequestDispatcher("/registrarCategoria.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        // Si no se pasa ninguna acción por defecto lista las categorías
        if (accion == null || accion.trim().isEmpty()) {
            accion = "listar";
        }

        switch (accion) {
            case "listar":
                List<CategoriaVO> categorias = categoriaDAO.listarCategorias();
                request.setAttribute("categorias", categorias);
                request.getRequestDispatcher("/verCategorias.jsp").forward(request, response);
                break;

            case "nuevo":
                request.getRequestDispatcher("/registrarCategoria.jsp").forward(request, response);
                break;

            default:
                response.sendRedirect(request.getContextPath() + "/CategoriaController?accion=listar");
                break;
        }
    }
}