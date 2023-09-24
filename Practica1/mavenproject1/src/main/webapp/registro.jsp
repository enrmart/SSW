
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    
  <head>
    <meta charset="utf-8">
    <title>Uflat | Registro</title>
    <link rel="stylesheet" href="registro.css?3.0"  type="text/css" media="all">
  </head>
  <body>

    <div class="login-box">
      <a href="index.html"><img src="img/IMG_0118.png" class="avatar" alt="Avatar Image"></a>
      <h1>Registrarse</h1>
      <div>
        <form action="regServlet" method="post">
        <!-- NAME INPUT -->
        <label for="name">Nombre</label>
        <input type="text" placeholder="Introduzca Nombre" name="nombre">
        <!-- 1Apell INPUT -->
        <label for="1apell">Apellidos</label>
        <input type="text" placeholder="Introduzca Apellidos" name="apellidos">
        <!-- 2apell INPUT -->
        <label for="Correo">Teléfono</label>
        <input type="text" placeholder="Introduzca Telefono" name="telefono">
        <!-- USERNAME INPUT -->

        <label for="username">Usuario</label>
        <input type="text" placeholder="Introduzca Usuario" name="usuario">
        <!-- PASSWORD INPUT -->
        <label for="password">Contraseña</label>
        <input type="password" placeholder="Introduzca Contraseña" name="password">
        <input type="password" placeholder="Repita Contraseña" name="passwordRep">
        <%
            String mensajeConfirmacion =(String)session.getAttribute("mensajeUsuarioExistente"); 
            if(!"".equals(mensajeConfirmacion) && mensajeConfirmacion!=null){ 
        %>
            <p style="color: #f70d1a"><%=mensajeConfirmacion%></p>
        <%
            }
        %>
        <a href="indexPerfil.jsp">
          <input type="submit" value="Registrarse">
        </a>
          
      </form>  
        
        <a href="sesion.html">¿Ya tienes cuenta? Iniciar Sesion</a><br>
        <a href="index.html">Seguir sin Registrarse</a>
      </div>
 

    </div>
  </body>
</html>
