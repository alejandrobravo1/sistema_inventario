<%-- 
    Document   : categoria
    Created on : 21/09/2026, 6:33:25 p. m.
    Author     : osals
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css.css"/>
    </head>
    <body>
        
        <h2>Categorias</h2>
        
           <!-- Mostrar mensaje de error si el Servlet lo devuelve -->
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red; text-align: center;"><%= request.getAttribute("error") %></p>
    <% } %>

                <div class="btnregresar">
            <a href="dashboard.jsp" class="btn">Regresar</a>
        </div>
        
         <div class="btnCategoria">
             
            <a href="${pageContext.request.contextPath}/registrarCategoria.jsp" class="btn">Registrar Categoria</a>                
            <a href="${pageContext.request.contextPath}/CategoriaController?accion=listar" class="btn">Ver categorias</a>
    
        </div>

        

    </body>
</html>
