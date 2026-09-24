<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.inventario.modelo.CategoriaVO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Categorías</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        h1 { color: #333; }
        .btn { display: inline-block; padding: 8px 12px; background-color: #007bff; color: white; text-decoration: none; border-radius: 4px; margin-bottom: 15px; }
        .btn:hover { background-color: #0056b3; }
        table { width: 100%; border-collapse: collapse; margin-top: 10px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #f4f4f4; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        .sin-datos { text-align: center; color: #777; font-style: italic; }
    </style>
</head>
<body>

    <h1>Gestión de Categorías</h1>

    <!-- Botón para ir al formulario de registro -->
    <a href="${pageContext.request.contextPath}/CategoriaController?accion=nuevo" class="btn">+ Nueva Categoría</a>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre de la Categoría</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Recuperar la lista enviada desde el Servlet CategoriaController
                List<CategoriaVO> categorias = (List<CategoriaVO>) request.getAttribute("categorias");

                if (categorias != null && !categorias.isEmpty()) {
                    for (CategoriaVO cat : categorias) {
            %>
                        <tr>
                            <td><%= cat.getId_categoria() %></td>
                            <td><%= cat.getNombre_categoria() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="2" class="sin-datos">No hay categorías registradas en el sistema.</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>

</body>
</html>