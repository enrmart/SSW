/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;


import java.io.IOException;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Alquiler;
import modelo.AlquilerDB;


@WebServlet(name="alquilarPisoServlet", urlPatterns={"/alquilarPisoServlet"})
public class alquilarPisoServlet extends HttpServlet {

    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//Poner en cada servlet
        response.setCharacterEncoding("UTF-8");
        
        String url = "";
        
        // obtengo la fecha del parámetro del formulario
        String fechaString = request.getParameter("fecha");
        // Convertir la fecha de String a Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        java.sql.Date fechaSQL = null;
        try {
            java.util.Date utilDate = dateFormat.parse(fechaString);
            fechaSQL = new java.sql.Date(utilDate.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(alquilarPisoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        //obtenemos si el usuario esta iniciado en el sistema
        int us = Integer.parseInt(request.getParameter("idUser"));
        //obtenemos el id del piso a alquilar
        int idPiso = Integer.parseInt(request.getParameter("idPiso"));
        if(us==1){
            String usuario = request.getParameter("usuario");
            Alquiler alquiler = new Alquiler(fechaSQL,usuario,idPiso);
            AlquilerDB.insert(alquiler);
            url="piso_detallado.jsp";
            String mensajeConfirmacion = "Solicitud confirmada";
            HttpSession session = request.getSession();
            session.setAttribute("mensajeConfirmacion", mensajeConfirmacion);
        }else{
            url="sesion.jsp";
        }

        RequestDispatcher view = request.getRequestDispatcher(url);
        view.include(request, response);
        
      
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para alquilar piso";
    }

}
