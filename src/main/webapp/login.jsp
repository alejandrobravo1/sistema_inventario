<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Iniciar Sesión - MAVITECH</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css.css"/>
</head>
<body>
    
    
    <h2>Inicio de Sesión</h2>

    <!-- Mostrar mensaje de error si el Servlet lo devuelve -->
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red; text-align: center;"><%= request.getAttribute("error") %></p>
    <% } %>

    <form class="form_1" action="${pageContext.request.contextPath}/loginController" method="POST">
        <div>
            <label>Usuario:</label>
            <input type="text" name="username" required>
        </div>
        <br>
        <div>
            <label>Contraseña:</label>
            <input type="password" name="password" required>
        </div>
        <br>
        <button type="submit">Ingresar</button>
    </form>
        
    <div class="ycuenta">
        <br>
    <a href="${pageContext.request.contextPath}/registro.jsp">¿NO tienes cuenta? Registrarse</a>
    </div>
</body>
</html>