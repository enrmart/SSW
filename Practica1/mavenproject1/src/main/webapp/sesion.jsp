

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <title>Uflat | Inicio Sesion</title>
    <link rel="stylesheet" href="sesion.css?3.0"  type="text/css" media="all">
  </head>
  <body>

    <div class="login-box">
      <a href="index.html"><img src="img/IMG_0118.png" class="avatar" alt="Avatar Image"></a>
      <h1>Identifícate</h1>
      <div>
        <form action="loginServlet" method="post">
        <!-- USERNAME INPUT -->
        <label for="username">Usuario</label>
        <input type="text" placeholder="Introduzca Usuario" name="Usuario">
        <!-- PASSWORD INPUT -->
        <label for="password">Contraseña</label>
        <input type="password" placeholder="Introduzca Contraseña" name="password">
        <%
            String mensajeDatosErroneos =(String)session.getAttribute("mensajeDatosErr"); 
            if(!"".equals(mensajeDatosErroneos) && mensajeDatosErroneos!=null){ 
        %>
            <p style="color: #f70d1a"><%=mensajeDatosErroneos%></p>
        <%
            }
        %>
   
        <input type="submit" value="Iniciar sesión">
       
        </form>

        <a href="olvCont.html">¿No te acuerdas de tu contraseña?</a><br>
        <a href="registro.jsp">¿No tienes cuenta? Registrarse</a>
      </div>
    </div>
  </body>
</html>
