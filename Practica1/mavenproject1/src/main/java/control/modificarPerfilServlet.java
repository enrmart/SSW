/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.UsuarioDB;


@WebServlet(name="modificarPerfilServlet", urlPatterns={"/modificarPerfilServlet"})
public class modificarPerfilServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet modificarPerfilServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet modificarPerfilServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }

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
        
        String nombre=request.getParameter("nombre");
        String apellidos=request.getParameter("apellidos");
        String telefono=request.getParameter("telefono");
        String usuario=request.getParameter("usuario");
        String cont=request.getParameter("contrasenna");
        String userViejo= request.getParameter("UsuarioViejo");
        
        Usuario user=new Usuario(nombre,apellidos,telefono,usuario,cont);
        int res;
        String url= "";
        try {
            HttpSession session = request.getSession();
            
            res=UsuarioDB.update(user,userViejo);
            
            if(res!=-1){
            url="/indexPerfil.jsp";
            session.setAttribute("user", user);
            
            }else{
                
                url="/modificar_perfil.jsp";
                String err="Usuario ya existente";
                session.setAttribute("mensajeMod", err);
            }
        } catch (Exception ex) {
            Logger.getLogger(modificarPerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        return "Servlet para modificar el perfil del usuario";
    }// </editor-fold>

}

