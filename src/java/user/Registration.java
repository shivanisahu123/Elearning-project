/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import common.DbConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class Registration extends HttpServlet {

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
            String fName = request.getParameter("fName");
            Connection con = DbConnect.connectMySql();
            String query = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, 0);
                ps.setString(2, fName);
                ps.setString(3, request.getParameter("lName"));
                ps.setString(4, request.getParameter("emailId"));
                ps.setString(5, request.getParameter("pass"));
                ps.setString(6, request.getParameter("aLine1"));
                ps.setString(7, request.getParameter("aLine2"));
                ps.setString(8, request.getParameter("city"));
                ps.setString(9, request.getParameter("state"));
                ps.setString(10, request.getParameter("pinCode"));

                int insert = ps.executeUpdate();
                if (insert == 0) {
                    out.println("<script>");
                    out.println("alert('Signup fail')");
                    out.println("window.location = 'create.html'");
                    out.println("</script>");
                } else {
                    out.println("<script>");
                    out.println("alert('Signup Successfully')");
                    out.println("window.location = 'login.html'");
                    out.println("</script>");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
