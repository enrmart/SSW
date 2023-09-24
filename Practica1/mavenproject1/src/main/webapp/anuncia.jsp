

<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="modelo.UsuarioDB"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Uflat | Anunciate</title>
   
    <link rel="stylesheet" href="anuncia.css?3.0" type="text/css" media="all">
</head>
<body>
    <%
            Usuario usuario =(Usuario)session.getAttribute("user");
            usuario = UsuarioDB.selectUser(usuario.getUsuario());
        %>
    <div class="todo">
    <div class="logos">

        <nav class="navMain">
            <ul class="navMenu show">
                <a href="indexPerfil.jsp"><img src="img/IMG_0118.png" alt="LOGO" class="brand1"></a>
            </ul>
            
           
            <ul class="navMenuR">
                <div class="fondo">
                    <img src="img/png-transparent-computer-icons-user-user-icon.png" alt="LOGO" class="user">
                    <div class="dropdown">
                        <button class="desplegable"><%=usuario.getUsuario()%></button>
                        <div class="dropdown-content">
                             <form action="modificar_perfil.jsp">
                            <input type="submit" name="drop" value="Mi perfil" id="perfil">
                        </form>
                   
                        <form id="form1" action="logoutServlet" method="post">
                            <input type="submit" name="drop" value="Cerrar Sesion" id="logout">
                        </form>
                        </div>
                    </div>
                </div>  
            </ul>

        </nav>  
        </div>
        <h1 class="Titulo">Buenos días, <%=usuario.getNombre()%></h1>
        <h2 class="descripcion">Datos del piso a anunciar</h2>
        <form action="insertarPisoServlet" method="post" enctype='multipart/form-data'>
        <div class="datos">
            
            
            <ul class="izquierdo">
                <li>
                      <!-- Direccion INPUT -->
                <label for="Direccion">Calle:</label>
                <input type="text" name="Calle" placeholder="Introduzca Direccion">

                </li>
                <li>
                    <!-- Ciudad INPUT -->
                <label for="ciudad">Ciudad:</label>
                <input type="text" name="Ciudad" placeholder="Introduzca Ciudad">
                    
                </li>
                <li>
                    <!-- Pais INPUT -->
                <label for="Pais">País:</label>
                <input type="text" name="Pais" placeholder="Introduzca Pais">
                    
                </li>
                <li>
                    <!-- Superficie INPUT -->
                <label for="Superficie">Superficie en m<sup>2</sup>:</label>
                <input type="text" name="Superficie" placeholder="Introduzca Superficie">
                    
                </li>
                <li>
                    <!-- Descripcion INPUT -->
                <label for="Descripcion">Descripción:</label>
                <input type="text" name="Descripcion" placeholder="Introduzca Descripcion">
                    
                </li>
                <li>
                       <!-- Descripcion INPUT -->
                       <label id="pa"  class="container">Parking
                        <input type="checkbox" name="Parking">
                        <span class="checkmark"></span>
                      </label>
                      <label  id="in"  class="container">Internet
                        <input type="checkbox" name="Internet">
                        <span class="checkmark"></span>
                      </label>
                      <label  id="ca" class="container">Calefacción
                        <input type="checkbox" name="Calefaccion">
                        <span class="checkmark"></span>
                      </label>
                      <label id="fu"  class="container">Fumar
                        <input type="checkbox" name="Fumar">
                        <span class="checkmark"></span>
                      </label>
                      <label id="ma"  class="container">Mascotas
                        <input type="checkbox" name="Mascotas">
                        <span class="checkmark"></span>
                      </label>
                       <label id="as"  class="container">Ascensor
                        <input type="checkbox" name="Ascensor">
                        <span class="checkmark"></span>
                      </label>
                       <label id="as"  class="container">Compartido
                        <input type="checkbox" name="Compartido">
                        <span class="checkmark"></span>
                      </label>
                    
                    
                 </li>

            </ul>

            
        </ul>
       
        <ul class="derecho">
            <li>
                 <!-- Precio INPUT -->
            <label for="Direccion">Precio/mes:</label>
            <input type="text" name="Precio" placeholder="Introduzca Precio">

            </li>
            <li>
                 <!-- Habitaciones INPUT -->
            <label for="numHab">Número de habitaciones:</label>
            <input type="text" name="numHab" placeholder="Introduzca numero de habitaciones">
                
            </li>
            <li>
                 <!-- Baños INPUT -->
            <label for="numbañ">Número de baños:</label>
            <input type="text" name="numBa" placeholder="Introduzca numero de baños">
                
            </li>
            <li>
                <!-- Piso INPUT -->
            <label for="Piso">Piso:</label>
            <input type="text" name="Piso" placeholder="Introduzca Piso">
                
            </li>
        
        </ul>


        </div>

        <div class="img">
            <input type="file" name ="foto" multiple id="file-input">
             <label id="custom-button" for="file-input">Agregar fotos</label>

        </div>
        <div class="opciones">
            <ul>
                <a href="indexPerfil.jsp">
                    <input id="cancelar" type="button" value="Cancelar" class="opcionesBtn">
                </a>
                
            </ul>
            <ul>
                <input id="aceptar" type="submit" value="Confirmar"class="opcionesBtn">
            </ul>
        </div>
    </form>
    </div>
</body>

<%
 // initialize the current year that's used in the copyright notice
 GregorianCalendar currentDate = new GregorianCalendar();
 int currentYear = currentDate.get(Calendar.YEAR);
%>
<footer class="footer">
    <h3><i class="fa-solid fa-copyright"></i> Copyright <%= currentYear %> Uflat Proudly powered by Group 12</h3>
</footer>


</html>