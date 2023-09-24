

<%@page import="modelo.filtro"%>
<%@page import="modelo.UsuarioDB"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Uflat</title>
    <!--FONT AWESOME-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    <!--FONT OSWALD-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200;300;400&display=swap" rel="stylesheet">
   
    <!--CUSTOM CSS-->
<a href="search_perfil.jsp"></a>
<link rel="stylesheet" href="indexPerfil.css?2.0"  type="text/css" media="all">
</head>
<body>
<%
            Usuario usuario =(Usuario)session.getAttribute("user");
            usuario = UsuarioDB.selectUser(usuario.getUsuario());
        %>
    <div class="barras">
        <i class="fas fa-bars fa-2x"></i>
    </div>
    <!--NavMenu-->
    <div class="container">
        <nav class="navMain">
            <img src="img/IMG_0118.png" alt="LOGO" class="brand">
            <ul class="navMenu show">
                <form action="sinFiltroServlet" method="post">
                    <li>
                        <input class="form-submit-button" type="submit" value="Buscar piso">
                    </li>
                    <input type="hidden" name="idUser" value="1">
                </form>
           
                <li>
                    <a href="anuncia.jsp">Oferta tu piso</a>
                </li>
                
                <form action="filtroServlet" method="post">
                    <li>
                        <input class="form-submit-button" type="submit" value="Piso compartido">
                        <input type="hidden" name="idUser" value="1">
                        <input type="hidden" name="num" value="0">
                    </li>
                </form>
                <li>
                    <a href="indexPerfil.jsp#Social">Más sobre nosotros</a>
                </li>
            </ul>
            <!--Perfil desplegable-->
            <ul class="navMenuR">
                <a href="modificar_perfil.jsp"><img src="img/png-transparent-computer-icons-user-user-icon.png"></a>
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
            </ul>

        </nav>
        <hr>

        <!--SHOWCASE-->
        <header class="showcase">
            <h1 style="font-size: 100px">UFLAT</h1>
            <h2>¿Eres Estudiante y Buscas Piso?</h2>
            <h3>Que la matrícula sea tu único problema</h3>
            <p>En esta página encontrarás lo que buscas ya que anunciamos pisos tanto individuales como compartidos distritribuidos tanto en España como en el resto de Europa para aquellos que se van de ERASMUS o estudian en una ciudad diferente a la suya y necesitan una vivienda a un precio más económico. Ya que toda nuestra oferta está directamente preparada para vosotros.
            </p>
            <form action="filtroServlet" method="post">
                <input class="btn" type="submit" value="Pisos en España>>">
                <input type="hidden" name="idUser" value="1">
                <input type="hidden" name="num" value="2">
                <input type="hidden" name="paisNav" value="España">
            </form>
        </header>
        <!--News Cards-->
        <div class="newsCards">
            
            <div>
                <img src="img/que-ver-en-madrid-via.jpg" alt="News 1">
                <h3>Madrid</h3>
                <p>Al ser la capital consta de un gran numero de universidades como : Complutense,Autónoma,Politecnica... Busca tu piso más adecuado y cercano al campus donde vayas a realizar tus estudios y experimenta la vida social de la propia capital.</p>
                <form action="filtroServlet" method="post">
                    <input class="form-submit-button" type="submit" value="Buscar pisos>>">
                    <input type="hidden" name="idUser" value="1">
                    <input type="hidden" name="num" value="1">
                    <input type="hidden" name="ciudadNav" value="Madrid">
                </form> 
            </div>
            
            <div>
                <img src="img/GettyImages-1392907424.webp" alt="News 2">
                <h3>Barcelona.</h3>
                <p>Es una universidad urbana, abierta y cosmopolita como la misma ciudad de Barcelona. La UB es la primera universidad pública de Cataluña en número de estudiantes, 87.486, y en oferta formativa. Es centro líder en investigación universitaria en España y uno de los más importantes de Europa.</p>
                 <form action="filtroServlet" method="post">
                    <input class="form-submit-button" type="submit" value="Buscar pisos>>">
                    <input type="hidden" name="idUser" value="1">
                    <input type="hidden" name="num" value="1">
                    <input type="hidden" name="ciudadNav" value="Barcelona">
                </form> 
            </div>
            <div>
                <img src="img/pexels-photo-6813023.jpeg" alt="News 3">
                <h3>Valladolid.</h3>
                <p>Valladolid es un municipio y ciudad española situada en el cuadrante noroeste de la península ibérica, capital de la provincia de Valladolid y sede de las Cortes y el Gobierno autonómicos de Castilla y León, consta de la tercera universidad más antigua de España</p>
                 <form action="filtroServlet" method="post">
                    <input class="form-submit-button" type="submit" value="Buscar pisos>>">
                    <input type="hidden" name="idUser" value="1">
                    <input type="hidden" name="num" value="1">
                    <input type="hidden" name="ciudadNav" value="Valladolid">
                </form> 
                
            </div>
            <div>
                <img src="img/plaza-mayor-salamanca-3.jpg" alt="News 4">
                <h3>Salamanca.</h3>
                <p>La Universidad de Salamanca, fundada en 1218, es una de las universidades más antiguas del mundo. Cuenta con una larga tradición humanística y científica y está presente en cuatro ciudades (Salamanca, Zamora, Ávila y Béjar). Cuenta con 26 facultades y escuelas universitarias que acogen a más de 30.000 alumnos. Además de que la propia ciudad tiene la fama de ser universitaria.</p>
                 <form action="filtroServlet" method="post">
                    <input class="form-submit-button" type="submit" value="Buscar pisos>>">
                    <input type="hidden" name="idUser" value="1">
                    <input type="hidden" name="num" value="1">
                    <input type="hidden" name="ciudadNav" value="Salamanca">
                </form> 
                
            </div>
        </div>

        <section class="cards-banner1">
            <div class="content">
                <p></p>
                 <h2 style="font-size: 50px">Pisos de Erasmus.</h2>
                <p>Este año te toca vivir fuera de tu país ya que vas a estudiar en otro país incluso en otro idioma nosotros te ayudamos a encontrar piso a tu gusto de gente que vive allí.</p>
                <form action="sinFiltroServlet" method="post">
                    <input class="btn" type="submit" value="Erasmus>>">
                    <input type="hidden" name="idUser" value="1">
                </form> 
            </div>

        </section>
        <div class="newsCards">
            <div>
                <img src="img/paris_37bc088a_1280x720.jpg" alt="News 1">
                <h3>París.</h3>
                <p>París es la capital de Francia y una de las grandes ciudades europeas. Es para muchos el destino turístico más romántico y popular de todo el planeta. Situada en el centro norte de Francia, París es una de las ciudades más visitadas del mundo, además de ser cuna de algunos movimientos vanguardistas.</p>
               <form action="filtroServlet" method="post">
                    <input class="form-submit-button" type="submit" value="Buscar pisos>>">
                    <input type="hidden" name="idUser" value="1">
                    <input type="hidden" name="num" value="1">
                    <input type="hidden" name="ciudadNav" value="París">
                </form>
            </div>
            <div>
                <img src="img/london_skyline_vb34141644.jpg" alt="News 2">
                <h3>Londres.</h3>
                <p>Londres es la ciudad más grande de Europa y una de las más grandes del mundo,cada año recibe a miles de turistas que llegan a ella con el deseo de conocer el punto de control de uno de los imperios más destacados de la historia de la humanidad.</p>
                <form action="filtroServlet" method="post">
                    <input class="form-submit-button" type="submit" value="Buscar pisos>>">
                    <input type="hidden" name="idUser" value="1">
                    <input type="hidden" name="num" value="1">
                    <input type="hidden" name="ciudadNav" value="Londres">
                </form>
            </div>
            <div>
                <img src="img/amsterdam_m.jpg.image.694.390.low.jpg" alt="News 3">
                <h3>Amsterdam.</h3>
                <p>Amsterdam es una ciudad abierta y tolerante, combina una sólida cultura con gentes de hábitos sencillos. Esta Ciudad conserva y ofrece su historia, tiene una oferta permanente de variados entretenimientos y hace su visita fácil con un eficiente sistema urbano de transporte.</p>
                <form action="filtroServlet" method="post">
                    <input class="form-submit-button" type="submit" value="Buscar pisos>>">
                    <input type="hidden" name="idUser" value="1">
                    <input type="hidden" name="num" value="1">
                    <input type="hidden" name="ciudadNav" value="Amsterdan">
                </form>
            </div>
            <div>
                <img src="img/6-h.webp" alt="News 4">
                <h3>Roma.</h3>
                <p>Roma es una ciudad italiana, capital de la región del Lacio y de Italia. Con una población de 2 857 321 habitantes,​ es el municipio más poblado de Italia y la tercera ciudad más poblada de la Unión Europea. </p>
                <form action="filtroServlet" method="post">
                    <input class="form-submit-button" type="submit" value="Buscar pisos>>">
                    <input type="hidden" name="idUser" value="1">
                    <input type="hidden" name="num" value="1">
                    <input type="hidden" name="ciudadNav" value="Roma">
                </form>
            </div>

          



        
    </div>
    <section class="cards-banner2">
        <div class="content">
            <h2>Ofertar Piso Para Universitarios.</h2>
            <p>¿Tienes un piso en desuso y quieres obtener un beneficio? Nosotros te ayudamos a ofertarlo en uno de los mayores mercados existentes que siempre va a tener demanda, además podrás realizar una gestión y contacto directo con quien esté interesado en su vivienda.
            </p>
            <a href="anuncia.jsp" class="btn">Anuncia tu piso <i class="fas fa-angle-double-right"></i></a>
        </div>

    </section>

   

    </div> 
    <!--Footer-->
    <div class="footer-links">
        <div class="footer-container">
            <ul>
                <li>
                    
               <img src="img/IMG_0119.png" alt="LOGO" class="brand2">
                       
                    
                </li>
                <li>
                    <a href="https://www.skype.com/es/"><i class="fa-solid fa-phone"></i> 913353535</a>
                </li>
                <li>
                    <a href="https://www.google.es/maps/search/Edificio+PCUVa+Paseo+de+Bel%C3%A9n+10A+47011+Valladolid+Spain/@41.6629812,-4.7076225,17z/data=!3m1!4b1"><i class="fa-solid fa-location-dot"></i> Edificio PCUVa, Paseo de Belén 10A, 47011, Valladolid, Spain. </a>
                </li>
                <li>
                    <a href="https://mail.google.com"><i class="fa-solid fa-envelope"></i> UflatContact@gmail.com</a>
                </li>
                
            </ul>
            
            <ul>
                <section class="social">
                    <a name="Social"></a>
                    <p>Síguenos</p>
                    <div class="links">
                        <a href="https://www.facebook.com/profile.php?id=100090898849552"><i class="fab fa-facebook-f"></i></a>
                        <a href="https://twitter.com/UflatContact"><i class="fab fa-twitter"></i></a>
                        <a href="https://es.linkedin.com/"><i class="fab fa-linkedin"></i></a>
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </section>
            </ul>
        </div>
    </div>
<%
 // initialize the current year that's used in the copyright notice
 GregorianCalendar currentDate = new GregorianCalendar();
 int currentYear = currentDate.get(Calendar.YEAR);
%>
    <footer class="footer">
        <h3><i class="fa-solid fa-copyright"></i> Copyright <%= currentYear %> Uflat Proudly powered by Group 12</h3>
    </footer>
     
    <!-- ScrollReveal-->
     <script src="https://unpkg.com/scrollreveal"></script>
    
    <script src="main.js"></script>
</body>
</html>
