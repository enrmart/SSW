/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Base64;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Foto;
import modelo.FotoDB;
import modelo.Piso;
import modelo.PisoDB;

@WebServlet(name="pisoDetalladoServlet", urlPatterns={"/pisoDetalladoServlet"})
public class pisoDetalladoServlet extends HttpServlet implements Serializable{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");//Poner en cada servlet
        response.setCharacterEncoding("UTF-8");
        
        //Obtenemos los parametros de las peticiones
        String idPiso = request.getParameter("idPiso");
     
        int us = Integer.parseInt(request.getParameter("idUser"));
        String url = "";
        
            Piso pisoDet = PisoDB.selectPiso(Integer.parseInt(idPiso));
            ArrayList<Foto>fotosPiso= FotoDB.selectFoto(Integer.parseInt(idPiso));
            
            //convertimos en base64 el contenido de las imagenes
            for(int i =0;i<fotosPiso.size();i++){
                String imagenBase64 = Base64.getEncoder().encodeToString(fotosPiso.get(i).getContenido());
                fotosPiso.get(i).setContenidoBase64(imagenBase64);
            }
            
            
            if (us==0){
                String mensajeConfirmacion = null;
                url="piso_detallado_sinperfil.jsp"; 
                HttpSession session = request.getSession();
                session.setAttribute("pisoDetallado", pisoDet);
                session.setAttribute("fotosPiso", fotosPiso);
                session.setAttribute("mensajeConfirmacion", mensajeConfirmacion);
            }
            else{
                String mensajeConfirmacion = null; 
                url="piso_detallado.jsp";  
                HttpSession session = request.getSession();
                session.setAttribute("pisoDetallado", pisoDet);
                session.setAttribute("fotosPiso", fotosPiso);
                session.setAttribute("mensajeConfirmacion", mensajeConfirmacion);
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
        return "Servlet para mostrar un piso de forma detallada";
    }
}
