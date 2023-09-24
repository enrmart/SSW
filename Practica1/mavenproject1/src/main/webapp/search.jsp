<%@page import="modelo.FotoDB"%>
<%@page import="modelo.Foto"%>
<%@page import="modelo.PisoDB"%>
<%@page import="modelo.filtro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Piso"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
       <meta charset="utf-8">
       <link rel="stylesheet" href="search.css?7.0" type="text/css" media="all">
       <title>Uflat búsqueda</title>
       
    </head>

    <body>
    <% filtro f=(filtro)session.getAttribute("filtrosValue");%>
        <!--MENÚ SUPERIOR-->
        <div class="container">
            <nav class="navMain">
                <a href="index.html"><img src="img/IMG_0118.png" alt="LOGO" class="brand"></a>

                <ul class="navMenu show">
                    <li>
                    <a href="sesion.jsp">Oferta tu piso</a>
                    </li>

                    <li>
                        <a href="index.html#Social">Más sobre nosotros</a>
                    </li>
                </ul>

                <ul class="navMenuR">
                    <li><a href="registro.jsp"><input type="submit" value="Registrarse" class="botonNaranja" id="logReg"></a>
                        <a href="sesion.jsp"><input type="submit" value="Iniciar Sesión" class="botonNaranja" id="logReg"></a>
                    </li>
                </ul>
            </nav>
        <div class="Medio">
          
            <div class="filtosYpisos">
            <!--ZONA DE FILTROS-->
            
            <div id="filters" class="filters">
                
                <!--CABECERO DE FILTROS-->
                
                    <h1>Filtros</h1>
   
                <!--LISTA DE  FILTROS-->
                
                <form action="filtroServlet" method="post">
                    
                    <ul class="filtros"> 
                        
                        <!--ZONA DE LUPA-->
                        <li>
                        <input type="search" placeholder="Introduce un piso" id="Buscador" name="lupa" value="<%=f.getLupa()%>" />
                        </li>
                        
                        <li>
                            <label for="Pais">País:</label>
                            <input type="text" placeholder="Introduzca Pais" name="pais" value=<%=f.getPais()%>>

                        </li>
                        <li>
                            <label for="ciudad">Ciudad:</label>
                            <input type="text" placeholder="Introduzca Ciudad" name="ciudad"value=<%=f.getCiudad()%>>
                        </li>
                        <li>
                            <label for="nubHab">Número Habitaciones:</label>
                            <input type="text" placeholder="Introduzca Numero Habitaciones" name="numHab" value=<%=f.getNumHab()%>>
                        </li>
                        <li>
                            <label for="numBan">Número Baños:</label>
                            <input type="text" placeholder="Introduzca Numero de Baños" name="numBa" value=<%=f.getNumBa()%>>
                        </li>
                        <li>
                            <label for="Prec">Precio Máximo mes:</label>
                            <input type="text" placeholder="Introduzca Precio Maximo" name="precio" value=<%=f.getPrecio()%>>
                        </li>

                        <li>
                            <label id="Asc" class="container1">Ascensor
                                <input type="checkbox" name="ascensor" <% if(f.isAscensor()) out.print("checked"); %>>
                                <span class="checkmark"></span>
                            </label>

                            <label id="Fum" class="container1">Fumar
                                <input type="checkbox" name="fumar" <% if(f.isFumar()) out.print("checked"); %>>
                                <span class="checkmark"></span>
                            </label>

                            <label id="Mas" class="container1">Mascotas
                                <input type="checkbox" name="mascotas" <% if(f.isMascotas()) out.print("checked"); %>>
                                <span class="checkmark"></span>
                            </label>

                            <label id="Cal" class="container1">Calefacción
                                <input type="checkbox" name="calefaccion" <% if(f.isCalefaccion()) out.print("checked"); %>>
                                <span class="checkmark"></span>
                            </label>

                            <label id="Int" class="container1">Internet
                                <input type="checkbox" name="internet" <% if(f.isInternet()) out.print("checked"); %>>
                                <span class="checkmark"></span>
                            </label>

                            <label id="Par" class="container1">Parking
                                <input type="checkbox" name="parking" <% if(f.isParking()) out.print("checked"); %>>
                                <span class="checkmark"></span>
                            </label>
                            <label id="Par" class="container1">Compartido
                                <input type="checkbox" name="compartido" <% if(f.isCompartido()) out.print("checked"); %>>
                                <span class="checkmark"></span>
                            </label>
                        </li> 
                        <input type="submit" value="Aplicar filtro" class="botonNaranja" id="buscarFiltro">
                        <input type="hidden" name="idUser" value="0">
                        <input type="hidden" name="num" value="4">
                    </ul>
              </form> 

                                  
            </div>

                    <div class="derecho">
                    <ul>
                        
                        <% 
                            ArrayList<Foto>fotos= new ArrayList<Foto>();
                            ArrayList<Piso>pisos= new ArrayList<Piso>();
                            pisos=(ArrayList)session.getAttribute("pisoFiltro");
                            if(pisos.isEmpty()){

                            %>

                            <h1>Sin resultados.</h1>

                            <%
                            }

                        for(int i=0;i<pisos.size();i++){
                            int id_piso = PisoDB.setId(pisos.get(i));
                            fotos = FotoDB.selectFoto(id_piso);
                            %>

                        <li id="Cosa">
                            <form action="pisoDetalladoServlet" method="post">
                                <div class="bann">
                                    <%
                                     if(!fotos.isEmpty()){
                                    %>
                                    <div style="background-image:url('data:image/png;base64,<%=fotos.get(0).getContenidoBase64()%>');"class="foto"></div>
                                    <%
                                        }else{
                                     %>

                                    <div style="background-image:url('img/sin_foto.png');"class="foto"></div>
                                    <%
                                        }
                                    %>
                                    <div class =" der">
                                        <div class="card_first_container">
                                            <div class="card_name">
                                                <h2><%=pisos.get(i).getCalle()%></h2>
                                            </div>
                                            <div class="card_cityCountry">
                                                <p><%=pisos.get(i).getCiudad()%>, <%=pisos.get(i).getPais()%></p>
                                            </div>


                                            <div class="card_rooms">
                                                <text style="font-size: 20px;"> 
                                                <%if(pisos.get(i).getNumHab()==1){%> 
                                                    <%=pisos.get(i).getNumHab()+" habitacion"%> 
                                                    <% } else { %>
                                                    <%=pisos.get(i).getNumHab()+" habitaciones"%> 
                                                    <% } %>
                                                </text>
                                                <text style="color: orange;"> &nbsp;|&nbsp; </text>
                                                <text style="font-size: 20px;">
                                                   <%if(pisos.get(i).getNumBan()==1){%> 
                                                    <%=pisos.get(i).getNumBan()+" baño"%> 
                                                    <% } else { %>
                                                    <%=pisos.get(i).getNumBan()+" baños"%> 
                                                    <% } %>
                                                </text>
                                            </div>
                                            <div class="card_second_container">

                                                <div class="card_rate">
                                                    <h2>5/5</h2>
                                                </div>
                                                <div class="card_price">
                                                    <p style="font-size: 30px"><%=pisos.get(i).getPrecio()%>€</p>
                                                </div>
                                            </div>
                                            <input type="submit" value="" class="boton-transparente" id="pisoDetalladoPerfil">
                                        </div>  
                                        <input type="hidden" name="idUser" value="0">
                                        <input type="hidden" name="Calle" value="<%=pisos.get(i).getCalle()%>">
                                        <input type="hidden" name="Ciudad" value="<%=pisos.get(i).getCiudad()%>">
                                        <input type="hidden" name="Pais" value="<%=pisos.get(i).getPais()%>">
                                        <input type="hidden" name="idPiso" value="<%=id_piso%>">
                                    </div>
                                </div>
                            </form>

                        
                        </li>
                        
                        <%
                            }
                        %>

                    </ul>
                </div>       
                </div>
            </div>            
        </div>
    </body>
    <footer class="footer">
        <h3><i class="fa-solid fa-copyright"></i> Copyright 2023 Uflat Proudly powered by Group 12</h3>
    </footer>
</html>
