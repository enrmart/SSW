/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import static modelo.UsuarioDB.coincide;
import static modelo.UsuarioDB.selectUser;


public class loginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            request.setCharacterEncoding("UTF-8");//Poner en cada servlet
            response.setCharacterEncoding("UTF-8");
            
            String Usuario = request.getParameter("Usuario");
            String Contraseña= request.getParameter("password");
         
            String url = "";
            
            if(coincide(Usuario,Contraseña)){
                HttpSession session = request.getSession();
                Usuario u = selectUser(Usuario);
                session.setAttribute("user", u);
                url = "/indexPerfil.jsp";
            }else{
                String mensajeDatosErr = "Usuario o Contraseña erroneos";
                HttpSession session = request.getSession();
                session.setAttribute("mensajeDatosErr", mensajeDatosErr);
                url = "/sesion.jsp";
                
            }
            
            RequestDispatcher rs = request.getRequestDispatcher(url);
            rs.include(request, response);
    }

/**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para iniciar sesion";
    }
}