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

@WebServlet(name="sinFiltroServlet", urlPatterns={"/sinFiltroServlet"})
public class sinFiltroServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");//Poner en cada servlet
        response.setCharacterEncoding("UTF-8");
        
        ArrayList<Piso> muestraPisos;
        filtro f= new filtro("","","","","",false,false,false,false,false,false,false,"");
        int us = Integer.parseInt(request.getParameter("idUser"));
        String url = "";
        muestraPisos= new ArrayList<Piso>();
        muestraPisos= PisoDB.selectPisoSinFiltro();
       // if (muestraPisos != null && !muestraPisos.isEmpty() ){
            if (us==0){
              url="search.jsp"; 
             
            }
            else{
              url="search_perfil.jsp";
              
            }
            HttpSession session = request.getSession();
            session.setAttribute("filtrosValue", f);
            session.setAttribute("pisoFiltro", muestraPisos);
        
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
        return "Servlet para mostrar sin filtros";
    }

}
