/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Piso;
import modelo.PisoDB;
import modelo.filtro;

@WebServlet(name="filtroServlet", urlPatterns={"/filtroServlet"})
public class filtroServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");//Poner en cada servlet
        response.setCharacterEncoding("UTF-8");
        ArrayList<Piso> muestraPisos;
        
        filtro f=null;
        String ciudad = null;
        String pais = null;
        String compartido = null ;
        String ascensor="";
        String fumar = null;
        String mascotas = null;
        String calefaccion = null;
        int numBa = -1;
        String precioFiltro="";
        int numHab=-1;
        String numBaFiltro="";
        double precio=9999999999.9;
        String numHabFiltro="";
        int us = Integer.parseInt(request.getParameter("idUser"));
        String lupa = "";
        String parking = null;
        String internet = null;
        
       //Creamos el filtro
       switch (request.getParameter("num")) {
           case "0":
               compartido = "true";
               f= new filtro("","","","","",false,false,false,false,false,false,Boolean.parseBoolean(compartido),"");
               break;
           case "1":
               ciudad = request.getParameter("ciudadNav");
               f= new filtro("",ciudad,"","","",false,false,false,false,false,false,false,"");
               break;
           case "2":
               pais=request.getParameter("paisNav");
               f= new filtro(pais,"","","","",false,false,false,false,false,false,false,"");
               break;
           case "4":
               
                ciudad= request.getParameter("ciudad");
                pais = request.getParameter("pais");

                
                if(request.getParameter("numBa").isEmpty()){
                    numBa = -1;
                }else{
                    numBa = Integer.parseInt(request.getParameter("numBa"));
                    numBaFiltro=String.valueOf(numBa);
                }

                
                if(request.getParameter("numHab").isEmpty()){
                    numHab= -1;
                }else{
                numHab= Integer.parseInt(request.getParameter("numHab"));
                numHabFiltro=String.valueOf(numHab);
                }

                
                if(request.getParameter("precio").isEmpty()){
                    precio= 9999999999.9;
                }else{
                    precio = Double.parseDouble(request.getParameter("precio"));
                    precioFiltro = String.valueOf(precio);
                }

                

                //parking
                if(request.getParameter("parking")==null){
                     parking ="false";
                }else{
                     parking ="true";
                }

                //internet
                if(request.getParameter("internet")==null){
                     internet ="false";
                }else{
                     internet ="true";
                }

                //calefaccion
                if(request.getParameter("calefaccion")==null){
                     calefaccion ="false";
                }else{
                     calefaccion ="true";
                }

                //mascotas
                if(request.getParameter("mascotas")==null){
                     mascotas ="false";
                }else{
                     mascotas ="true";
                }

                //fumar
                if(request.getParameter("fumar")==null){
                     fumar ="false";
                }else{
                     fumar ="true";
                }

                //ascensor
                if(request.getParameter("ascensor")==null){
                     ascensor ="false";
                }else{
                     ascensor ="true";
                }

                //compartido
                if(request.getParameter("compartido")==null){
                    compartido ="false";
                }else{
                    compartido ="true";
                }
                lupa = request.getParameter("lupa");
                f=new filtro(pais,ciudad,numHabFiltro,numBaFiltro,precioFiltro,Boolean.parseBoolean(ascensor),Boolean.parseBoolean(mascotas),Boolean.parseBoolean(fumar),Boolean.parseBoolean(calefaccion),Boolean.parseBoolean(internet),Boolean.parseBoolean(parking),Boolean.parseBoolean(compartido),lupa);
                break;
           }
       
       
        String url = "";
        muestraPisos= null;
        
        //Seleccionamos los pisos con la consulta SQL
        muestraPisos= PisoDB.selectPisoBuscador(pais,ciudad,numHab,numBa,precio,Boolean.parseBoolean(ascensor),Boolean.parseBoolean(fumar),Boolean.parseBoolean(mascotas),Boolean.parseBoolean(calefaccion),Boolean.parseBoolean(internet),Boolean.parseBoolean(parking),Boolean.parseBoolean(compartido),lupa);
        
        //Vemos si hay usuario en la sesion
        if (us==0){
            url="search.jsp"; 
            //System.out.println("el id del piso 3 es: "+muestraPisos.get(2).getId_Piso());
        }
        else{
            url="search_perfil.jsp"; 
        }
        
        //Guardamos los atributos de la sesion
        HttpSession session = request.getSession();
        session.setAttribute("pisoFiltro", muestraPisos);
        session.setAttribute("filtrosValue", f);
            
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.include(request, response); 
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para aplicar un filtro";
    }
}   

  

