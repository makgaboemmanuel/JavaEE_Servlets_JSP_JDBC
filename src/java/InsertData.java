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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mathekga M. Emmanuel
 */
public class InsertData extends HttpServlet {

    String studnr, surname, initials, sex, birthdate; 
    String query; 
    Connection conn;
    Statement st; 
    ResultSet rs; 
    DatabaseConnection dbconn; 
     
     
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
            
            try
            {
            dbconn = new DatabaseConnection(); 
            
            studnr = request.getParameter("STUDNR") ; 
            surname = request.getParameter("SURNAME")  ;
            initials  = request.getParameter("INITIALS")  ;
            sex  = request.getParameter("SEX")  ; 
            birthdate  = request.getParameter("BIRTHDATE")  ;
            
            conn = dbconn.setConnection(); 
            st = conn.createStatement(); 
            query = "insert into s_student values ('" +  studnr + "', '" + surname + "','" 
                    + initials + "','" + sex + "','" + birthdate + "')";
            int i = st.executeUpdate(query); 
            }
            catch(Exception ex)
            {
                request.setAttribute("Error", ex);
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp"); 
                rd.forward(request, response);        
             }
            
            finally
            {
                 RequestDispatcher rd = request.getRequestDispatcher("index.jsp"); 
                 rd.forward(request, response);
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
