<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro - MAVITECH</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css.css">
</head>
<body>
    <h2>Registro de Usuario</h2>

    <!-- Mostrar mensaje de error o éxito -->
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <% if (request.getAttribute("exito") != null) { %>
        <p style="color: green;"><%= request.getAttribute("exito") %></p>
    <% } %>

    <form action="${pageContext.request.contextPath}/RegistroController" method="POST">
        <div>
            <label>Usuario:</label>
            <input type="text" name="username" required>
        </div>
        <br>
        <div>
            <label>correo:</label>
            <input type="email" name="correo" required>
        </div>
        <br>
        <div>
            <label>Contraseña:</label>
            <input type="password" name="password" required>
        </div>
        <br>
        <div>
            <label>Confirmar Contraseña:</label>
            <input type="password" name="confirmPassword" required>
        </div>
        <br>

        <button type="submit">Registrarse</button>
    </form>
   
    <br>
    <div class="ycuenta">
    <a href="${pageContext.request.contextPath}/login.jsp">¿Ya tienes cuenta? Inicia sesión</a>
    </div>
</body>
</html>
