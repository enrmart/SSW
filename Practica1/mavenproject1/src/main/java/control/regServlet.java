/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import modelo.Usuario;
import modelo.UsuarioDB;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name="regServlet", urlPatterns={"/regServlet"})
public class regServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");//Poner en cada servlet
    response.setCharacterEncoding("UTF-8");
    
    String Nombre = request.getParameter("nombre");
    String Apellidos = request.getParameter("apellidos");
    String Telefono= request.getParameter("telefono");
    String Usuario = request.getParameter("usuario");
    String Contraseña= request.getParameter("password");
    String ContraseñaRep = request.getParameter("passwordRep");

    Usuario user = new Usuario(Nombre,Apellidos,Telefono,Usuario,Contraseña);
    
    String url = "";
        
        if(!Contraseña.equals(ContraseñaRep)){
            String mensajeConfirmacion = "Las Contraseñas no coinciden";
            HttpSession session = request.getSession();
            session.setAttribute("mensajeUsuarioExistente", mensajeConfirmacion);
            url = "/registro.jsp";
        }else{
            if (UsuarioDB.usuarioExists(user.getUsuario())) {
                String mensajeConfirmacion = "Usuario ya existente";
                HttpSession session = request.getSession();
                session.setAttribute("mensajeUsuarioExistente", mensajeConfirmacion);
                url = "/registro.jsp";
                } 
            else {

                UsuarioDB.insert(user);
                user = UsuarioDB.selectUser(Usuario);

                url = "/indexPerfil.jsp";
                // store the user in the session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
            }
        }
            // forward the request and response to the view
            RequestDispatcher dispatcher = /*getServletContext()*/request.getRequestDispatcher(url);
            dispatcher.include(request, response);
    } 
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para registrar un usuario";
    }
}