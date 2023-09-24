

<%@page import="modelo.UsuarioDB"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <link rel="stylesheet" href="registro.css?2.0"  type="text/css" media="all">
    </head>
    <body>
        <!-- elementos cuadro edicion de perfil usuario-->
        <%
            Usuario usuario =(Usuario)session.getAttribute("user");
            usuario=UsuarioDB.selectUser(usuario.getUsuario());
        %>
        <div class = "container">
            <div class="cabecera_1">
                <!--<a href="indexPerfil.html"><img src="img/IMG_0118.png" class="lobby" alt="lobby image"></a>-->
                <!--<img src="img/png-transparent-computer-icons-user-user-icon.png" class="avatar" alt="Avatar Image">-->
            </div>
            <div class="login-box">
                <a href="indexPerfil.jsp"><img src="img/IMG_0118.png" class="avatar" alt="Avatar Image"></a>
                <h1>Buenas, <%=usuario.getNombre()%></h1>
                <div>
                  
                  <form action="modificarPerfilServlet" method="post">
                  <!-- NAME INPUT -->
                  <label for="name">Nombre</label>
                  <input type="text" name="nombre" value="<%=usuario.getNombre()%>">
                  <!-- 1Apell INPUT -->
                  <label for="1apell">Apellidos</label>
                  <input type="text" value="<%=usuario.getApellidos()%>" name="apellidos">
                  <!-- 2apell INPUT -->
                  <label for="Correo">Teléfono</label>
                  <input type="text" value="<%=usuario.getTelefono()%>" name="telefono">
                  <!-- USERNAME INPUT -->
          
                  <label for="username">Usuario</label>
                  <input type="text" value="<%=usuario.getUsuario()%>" name="usuario">
                  <input type="hidden" name="UsuarioViejo" value="<%=usuario.getUsuario()%>">
                  <!-- PASSWORD INPUT -->
                  <label for="password">Contraseña</label>
                  <input type="password" value="<%=usuario.getContraseña()%>" name="contrasenna">
                  <%
            String mensajeConfirmacion =(String)session.getAttribute("mensajeMod"); 
            if(!"".equals(mensajeConfirmacion) && mensajeConfirmacion!=null){ 
        %>
            <p style="color: #f70d1a"><%=mensajeConfirmacion%></p>
        <%
            }
        %>
        
                </div>  
                <div>
                    <input type="submit" value="Guardar y Salir" id="CTA">
                </div>        
            </form>
                
                
               <form action="borrarCuentaServlet" method="post">
                   
                <div>
                    <input type="submit" value="Borrar Cuenta">
                </div>
                <input type="hidden" name="idUser" value="<%=usuario.getUsuario()%>">
                </form>     
                  
                  
        </div>
                
</html>
