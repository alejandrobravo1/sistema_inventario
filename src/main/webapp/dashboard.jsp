<%-- 
    Document   : dashboard
    Created on : 14/09/2026, 11:25:06 a. m.
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
                <div class="btnregresar">
            <a href="login.jsp" class="btn-regresar">CERRAR SECION</a>
        </div>
        
        
        <h1>¡Bienvenido, ${sessionScope.nombreUsuario}!</h1>
        <div class="btnCategoria">
            <a href="${pageContext.request.contextPath}/categoria.jsp" class="btn">Categorias</a>
            <a href="${pageContext.request.contextPath}/producto.jsp" class="btn">Productos</a>
            <a href="${pageContext.request.contextPath}/usuario.jsp" class="btn">Usuarios</a>
            <a href="${pageContext.request.contextPath}/configuracion.jsp" class="btn">Configuracion</a>
        </div>
    </body>
</html>
