/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modelo.Foto;
import modelo.FotoDB;
import modelo.Piso;
import modelo.PisoDB;
import modelo.Usuario;


@MultipartConfig
@WebServlet(name="insertarPisoServlet", urlPatterns={"/insertarPisoServlet"})
public class insertarPisoServlet extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//Poner en cada servlet
        response.setCharacterEncoding("UTF-8");
        
        //obtengo los parametros del piso a anunciar
        String calle = request.getParameter("Calle");
        String ciudad = request.getParameter("Ciudad");
        String pais = request.getParameter("Pais");
        String superficie = request.getParameter("Superficie");
        String numBañ = request.getParameter("numBa");
        String numHab = request.getParameter("numHab");
        String piso = request.getParameter("Piso");
        String precio = request.getParameter("Precio");
        String descripcion = request.getParameter("Descripcion");
        
        String parking;
        if(request.getParameter("Parking")==null){
             parking ="false";
        }else{
             parking ="true";
        }
        
        String internet;
        if(request.getParameter("Internet")==null){
             internet ="false";
        }else{
             internet ="true";
        }
        String calefaccion;
        if(request.getParameter("Calefaccion")==null){
             calefaccion ="false";
        }else{
             calefaccion ="true";
        }
        String mascotas;
        if(request.getParameter("Mascotas")==null){
             mascotas ="false";
        }else{
             mascotas ="true";
        }
        String fumar;
        if(request.getParameter("Fumar")==null){
             fumar ="false";
        }else{
             fumar ="true";
        }
        String ascensor ;
         if(request.getParameter("Ascensor")==null){
             ascensor ="false";
        }else{
             ascensor ="true";
        }
         String compartido ;
         if(request.getParameter("Compartido")==null){
             compartido ="false";
        }else{
             compartido ="true";
        }
         
        Usuario usuario = (Usuario)request.getSession().getAttribute("user");
        
        //hacer en el piso un blob para guardar la primera foto------------------------------
        String fotos = "aquidebenirlasfotos";

        Piso pisoAnuncio = new Piso(calle,ciudad,Integer.parseInt(numHab),pais,Integer.parseInt(superficie),Integer.parseInt(numBañ),
                Integer.parseInt(piso),Boolean.parseBoolean(ascensor),Boolean.parseBoolean(mascotas),
                    Boolean.parseBoolean(fumar),Boolean.parseBoolean(calefaccion),Boolean.parseBoolean(internet),
                        Boolean.parseBoolean(parking),fotos,Float.parseFloat(precio),descripcion,usuario.getUsuario(),Boolean.parseBoolean(compartido));
        
        String url = "";
        //confirmo que el piso no existe
        if(PisoDB.pisoExists(calle, ciudad, pais)){
            
            PisoDB.insert(pisoAnuncio);
            pisoAnuncio = PisoDB.selectPiso(calle,ciudad,pais);
            pisoAnuncio.setId_Piso(PisoDB.setId(pisoAnuncio));
 
           //insertar fotos............................................       
           List<Part> fileParts = new ArrayList<>(); 
           //Compruebo si los archivos del JSP son archivos y se añaden
           for (Part part : request.getParts()) {
               
                if (part.getName().equals("foto")) {
                    fileParts.add(part);
                }
            }
            boolean hasSelectedFile = false;
            //Compruebo si he seleccionado archivos
            for (Part filePart : fileParts) {
                if (filePart.getSize() > 0) {
                    hasSelectedFile = true;
                    break;
                }
            }
            
            if (hasSelectedFile) {
                // Procesar cada foto
                for (Part filePart : fileParts) {
                        String nombre = filePart.getSubmittedFileName();
                        InputStream fileContent = filePart.getInputStream(); // Obtener el contenido del archivo
                        // Leer el contenido del archivo en un arreglo de bytes
                        byte[] fileBytes = fileContent.readAllBytes();
                        // Crear objeto Foto y agregarlo al ArrayList
                        Foto foto = new Foto(nombre, fileBytes,usuario.getUsuario(),pisoAnuncio.getId_Piso());    
                        //inserto la foto en la bd
                        FotoDB.insertFoto(foto);
                         FotoDB.setId(foto);
                        fileContent.close();
                    }
            }
            
   //.................................................

            url = "/anuncia.jsp";
            // store the user in the session
            HttpSession session = request.getSession();
            session.setAttribute("pisoAnuncio", pisoAnuncio);
           
        }else{
            url="/anuncia.jsp";
             
        }
        
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
        return "Servlet para insertar piso";
    }
}

