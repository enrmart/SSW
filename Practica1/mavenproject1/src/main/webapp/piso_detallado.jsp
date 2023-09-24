
<%@page import="modelo.PisoDB"%>
<%@page import="modelo.Foto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.UsuarioDB"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Piso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>piso_detallado</title>
        <link rel="stylesheet" href="piso_detallado.css?5.0"  type="text/css" media="all">
        <!-- API MAPA -->
        <link rel="stylesheet" href="https://unpkg.com/leaflet-control-geocoder/dist/Control.Geocoder.css" />
        <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css" />
        <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
        <script src="https://unpkg.com/leaflet-control-geocoder/dist/Control.Geocoder.js"></script>
        <!-- widget Calendario -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
    </head>
    <body>
        
        <%
            Usuario usuario =(Usuario)session.getAttribute("user");
            usuario = UsuarioDB.selectUser(usuario.getUsuario());
            
            Piso pisoDet =(Piso)session.getAttribute("pisoDetallado");
            int id_piso = PisoDB.setId(pisoDet);
        %>
        <ul>
            <li>
                <div class = "cuerpoDatos">
                    <div class="cabecera_1">
                        <a href="indexPerfil.jsp"><img src="img/IMG_0118.png" class="lobby" alt="lobby image"></a>
                        <div class="perfil ">
                            <img src="img/png-transparent-computer-icons-user-user-icon.png" class="avatar" alt="Avatar Image">
                            <div class="dropdown">
                                <button class="desplegable"><%=usuario.getUsuario()%></button>
                                <div class="dropdown-content">
                                    <form action="modificar_perfil.jsp">
                                        <input class="optionsPerfil" type="submit" name="drop" value="Mi perfil" id="perfil">
                                    </form>
                                    <form id="form1" action="logoutServlet" method="post">
                                        <input class="optionsPerfil" type="submit" name="drop" value="Cerrar Sesion" id="logout">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class = datos>
                        <div class="col_1">
                            <h1><%=pisoDet.getCalle()%>, <%=pisoDet.getCiudad()%>, <%=pisoDet.getPais()%></h1>
                            
                        </div>
                        <div class ="col_2">
                            <h2>Valoracion</h2>
                            <h2 id="valor">5/5</h2>
                        </div>
                    </div>
                    <div class="imagenes">
                        
                        <div class="imagenes_restantes">
                            <%
                               
                            ArrayList<Foto>fotos= new ArrayList<Foto>();
                            fotos=(ArrayList)session.getAttribute("fotosPiso");
                            if(!fotos.isEmpty()){
                                for(int i=0;i<fotos.size();i++){
                 
                                 
                    %>
                    
                    
                    <img class=img_casa src="data:image/png;base64,<%=fotos.get(i).getContenidoBase64()%>" alt="FotoImagen" onclick="seleccionarFoto(${fotos.get(i).getIdFoto()})">
                         
                    <%
                                }
}
                    %>
                        </div>
                    </div>
                    <div class ="varios">
                        <h1><%=pisoDet.getPrecio()%><text style="font-size: 20px">€/mes</text></h1>
                        <div class = check_fav>
                            <input class="Favorito" type="checkbox" name="Favorito">
                            <img class=img_favorito src="img/corazon.png" alt="Favorito">
                        </div>
                        <button class="varios_btn">Compartir</button>
                        <form action="alquilarPisoServlet" method="post">
                            <p>¿Hasta cuando quieres reservar? </p>
                            <input type="text" id="datepicker" name="fecha">
                            <input class="reservar" type="submit" value="Reservar piso">
                            <%
                                String mensajeConfirmacion =(String)session.getAttribute("mensajeConfirmacion"); 
                                if(!"".equals(mensajeConfirmacion) && mensajeConfirmacion!=null){
                                    
                                
                            %>
                            <p style="color: #16f361"><%=mensajeConfirmacion%></p>
                            <%
                                }
                            %>
                             
                            <input type="hidden" name="idUser" value="1">
                            <input type="hidden" name="usuario" value="<%=usuario.getUsuario()%>">
                            <input type="hidden" name="idPiso" value="<%=id_piso%>">
                            <script>
                                $( function() {
                                  $( "#datepicker" ).datepicker();
                                } );
                            </script>

                        </form>
                    </div>
                    <div class="caracteristicas_importantes">
                        <text>  <% if (pisoDet.isCompartido()){ %>
                                    <%= "Compartido" %>
                                    <% } else { %>
                                    <%= "No compartido" %>
                                    <% } %></text>
                        <text style="color: orange;"> &nbsp;|&nbsp; </text>
                        <text>
                        <%if(pisoDet.getNumHab()==1){%> 
                        <%=pisoDet.getNumHab()+" habitacion"%> 
                        <% } else { %>
                        <%=pisoDet.getNumHab()+" habitaciones"%> 
                        <% } %>
                        </text>
                        <text style="color: orange;"> &nbsp;|&nbsp; </text>
                        <text>
                            <%if(pisoDet.getNumBan()==1){%> 
                            <%=pisoDet.getNumBan()+" baño"%> 
                            <% } else { %>
                            <%=pisoDet.getNumBan()+" baños"%> 
                            <% } %>
                        </text>
                        <text style="color: orange;"> &nbsp;|&nbsp; </text>
                        <text><%=pisoDet.getSuperficie()%> m<sup>2</sup></text>
                        <text style="color: orange;"> &nbsp;|&nbsp; </text>
                        <text> piso <%=pisoDet.getPiso()%></text>
                    </div>
                
                    
                    <div class ="descripcion">
                        <textarea  class=descripcion_txt readonly name="descripcion_txt" rows="10" cols="40"><%=pisoDet.getDescripcion()%></textarea>
                    </div>
                    <h2 class="text-divider" style="text-align: center;">Características</h2>
                    <div class="caracteristicas_totales">
                                <output name="mascotas">
                                    <% if (pisoDet.allowsMascotas()) { %>
                                    <%= "Mascotas" %>
                                    <% } else { %>
                                    <%= "" %>
                                    <% } %>
                                </output>
                                <output name="fumar"><b>
                                    <% if (pisoDet.allowsFumar()){ %>
                                    <%= "Fumar" %>
                                    <% } else { %>
                                    <%= "" %>
                                    <% } %>
                                </b></output>
                                <output name="ascensor">
                                    <% if (pisoDet.hasAscensor()) { %>
                                    <%= "Ascensor" %>
                                    <% } else { %>
                                    <%= "" %>
                                    <% } %>
                                </output>
                                <output name="calefaccion"><b>
                                        <% if (pisoDet.hasCalefaccion()) { %>
                                    <%= "Calefaccion" %>
                                    <% } else { %>
                                    <%= "" %>
                                    <% } %>
                                </b></output>
                                <output name="internet"><b>
                                    <% if (pisoDet.hasInternet()) { %>
                                    <%= "Internet" %>
                                    <% } else { %>
                                    <%= "" %>
                                    <% } %>
                                </b></output>
                                <output name="parking">
                                    <% if (pisoDet.hasParking()) { %>
                                    <%= "Parking" %>
                                    <% } else { %>
                                    <%= "" %>
                                    <% } %>
                                </output>
                    </div>
                    <h2 class="text-divider" style="text-align: center;">Localizacion</h2>
                    <div id ="map" style = "width:100%; height:450px">
                       
                       <!-- <iframe src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d1539.7823845638995!2d-0.3435101607131959!3d39.479160115809286!3m2!1i1024!2i768!4f13.1!5e0!3m2!1ses!2ses!4v1678983815703!5m2!1ses!2ses" width="100%" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>-->
                    </div>

                    <script>
function initMap() {
  // Dirección a geocodificar (puede ser un parámetro de tu clase)
  var direccion = "<%=pisoDet.getCalle()%>";

  // Crea un objeto de mapa de Leaflet y establece la ubicación inicial
  var map = L.map('map').setView([0, 0], 15);

  // Agrega una capa de OpenStreetMap al mapa
  L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: 'Map data © <a href="https://openstreetmap.org">OpenStreetMap</a> contributors'
  }).addTo(map);

  // Crea un geocodificador de Leaflet para obtener las coordenadas a partir de la dirección
  var geocoder = L.Control.Geocoder.nominatim();

  // Realiza la geocodificación de la dirección
  geocoder.geocode(direccion, function(results) {
    if (results.length > 0) {
      // Obtiene las coordenadas de la primera coincidencia
      var latitud = results[0].center.lat;
      var longitud = results[0].center.lng;

      // Establece la ubicación del mapa en las coordenadas obtenidas
      map.setView([latitud, longitud], 15);

      // Agrega un marcador en la posición del mapa
      L.marker([latitud, longitud]).addTo(map).bindPopup("<%=pisoDet.getCalle()%>,<%=pisoDet.getCiudad()%>,<%=pisoDet.getPais()%>");
    } else {
      // Maneja el caso de dirección no encontrada
      alert('Dirección no encontrada');
    }
  });
}
</script>
<script>
                        // Llama a la función de inicialización del mapa cuando se cargue la página
                        window.onload = function() {
                          initMap();
                        };
                    </script>
                    
                                
                    <!--<h2 class="reseñas_txt" style="text-align: center;">Reseñas</h2>-->
                     <h2 class="text-divider" style="text-align: center;">Reseñas</h2>
                    <div class="reseñas" >
                        <div class="reseña">
                            <h3 class="usuario" >Pedro<text style="font-size: 13px;">&nbsp;&nbsp;28/01/2022</text></h3>
                            <textarea class="comentario" readonly name="comentario" rows="10" cols="40" >Piso agradable e idoneo para los estudiantes. CÃ©ntrico y cerca de las universidades. El casero es una persona muy agradable</textarea>
                        </div>
                        <div class="reseña">
                            <h3 class="usuario" >Alejandro<text style="font-size: 13px;">&nbsp;&nbsp;28/01/2022</text></h3>
                            <textarea class="comentario" readonly name="comentario" rows="10" cols="40" >Piso agradable e idoneo para los estudiantes. CÃ©ntrico y cerca de las universidades. El casero es una persona muy agradable</textarea>
                        </div>
                        <div class="reseña">
                            <h3 class="usuario" >Hector<text style="font-size: 13px;">&nbsp;&nbsp;28/01/2022</text></h3>
                            <textarea class="comentario" readonly name="comentario" rows="10" cols="40" >Piso agradable e idoneo para los estudiantes. CÃ©ntrico y cerca de las universidades. El casero es una persona muy agradable</textarea>
                        </div>
                        <div class="reseña">
                            <h3 class="usuario" >Carlos<text style="font-size: 13px;">&nbsp;&nbsp;28/01/2022</text></h3>
                            <textarea class="comentario" readonly name="comentario" rows="10" cols="40" >Piso agradable cercano a la universidad y a la fiesta, aunque el casero es un poco pesado </textarea>
                        </div>
                        <div class="reseña">
                                <h3 class="usuario" >Fernando<text style="font-size: 13px;">&nbsp;&nbsp;28/01/2022</text></h3>

                            <textarea class="comentario" readonly name="comentario" rows="10" cols="40" >Piso agradable e idoneo para los estudiantes. CÃ©ntrico y cerca de las universidades. El casero es una persona muy agradable</textarea>
                        </div>
                        
                    </div>
                </div>
            </li>
            <li>
                <footer>
                    <h3><i class="fa-solid fa-copyright"></i> Copyright 2023 Uflat Proudly powered by Group 12</h3>
                </footer>
            </li>
        </ul>
    </body>