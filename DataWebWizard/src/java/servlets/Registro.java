/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
public class Registro extends HttpServlet {

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
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession mySession = request.getSession();
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/Omega","root","root");
            Statement query = con.createStatement();
            String nombre=request.getParameter("nombre");
            String contra=request.getParameter("contrasena");
            ResultSet rs = query.executeQuery("SELECT nombre FROM USUARIOS WHERE nombre = '" + nombre + "'");
            if(rs.next()){
                out.println("Nombre de usuario inválido, intentar otro usuario");
                out.println("<a href='registro.jsp'>Volver a registro</a>");
            } else{
                rs = query.executeQuery("SELECT MAX(ID) AS MAXID FROM USUARIOS");
                int id;
                if(rs.next()){
                    id= rs.getInt("MAXID") + 1;
                } else{
                    id= 1;
                }
                query.executeUpdate("INSERT INTO Usuarios VALUES (" + id + ", '" + nombre + "', '" + contra + "')"); 
                out.println("Registro exitoso, ve a tu perfil para comenzar a crear tablas");
                out.println("<a href='usuario.jsp'>Perfil</a>");
                mySession.setAttribute("nombre", nombre);
                mySession.setAttribute("contrasena", contra);
                mySession.setAttribute("idUsuario", id);
            }
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
