<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Categoría</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css.css"/>
</head>
<body>

<div class="card-container">

    <!-- Enlace de retorno alineado a la derecha -->
    <a href="${pageContext.request.contextPath}/categoria.jsp" class="btn-regresar">
        &larr; Regresar
    </a>

    <h2>Nueva Categoría</h2>

    <%
        // Lectura de mensajes enviados por el Servlet (soporta request y session)
        String msgExito = (String) request.getAttribute("exito");
        if (msgExito == null) {
            msgExito = (String) session.getAttribute("exito");
        }

        String msgError = (String) request.getAttribute("error");
    %>

    <%-- BLOQUE DE MENSAJE DE ÉXITO --%>
    <% if (msgExito != null) { %>
        <div class="alert-success">
            <%= msgExito %>
        </div>
    <% 
        // Si venía en la sesión, lo removemos para que no vuelva a salir al refrescar
        session.removeAttribute("exito");
    } 
    %>

    <%-- BLOQUE DE MENSAJE DE ERROR --%>
    <% if (msgError != null) { %>
        <div class="alert-danger">
            <%= msgError %>
        </div>
    <% } %>

    <!-- Formulario apuntando obligatoriamente al Servlet CategoriaController con método POST -->
    <form action="${pageContext.request.contextPath}/CategoriaController" method="POST">
        
        <div class="form-group">
            <label for="nombre">Nombre de la Categoría</label>
            <input type="text" id="nombre" name="nombre" placeholder="Ej. Lácteos, Abarrotes..." required autocomplete="off">
        </div>

        <button type="submit" class="btn-submit">Crear Categoría</button>
        
    </form>

</div>

</body>
</html>