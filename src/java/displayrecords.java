/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import WebDBApp.myclasses.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mathekga M. Emmanuel
 */
@WebServlet(urlPatterns = {"/displayrecords"})
public class displayrecords extends HttpServlet {

    String query; 
    Connection conn;
    Statement st; 
    ResultSet rs; 
    DatabaseConnection dbconn;  
    List list = new ArrayList(); 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        try {
            dbconn = new DatabaseConnection();  
            conn = dbconn.setConnection(); 
            st = conn.createStatement(); 
            query = "select * from s_student"; 
            rs = dbconn.getResults(query, conn); 
            
            while(rs.next())
            {
                list.add( rs.getString("studnr") );
                list.add( rs.getString("surname") );
                list.add( rs.getString("initials") );
                list.add( rs.getString("sex") );
                list.add( rs.getString("birthdate") );           
            }
            
            rs.close();     
        }
        
        catch(Exception ex)
        {
          request.setAttribute("Error", ex);
          RequestDispatcher rd = request.getRequestDispatcher("error.jsp"); 
          rd.forward(request, response);       
        }
        
        finally
        {
            request.setAttribute("StudentData", list);
            RequestDispatcher  rd = request.getRequestDispatcher("/displayrecord.jsp"); 
            rd.forward(request, response); 
            out.close();
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
