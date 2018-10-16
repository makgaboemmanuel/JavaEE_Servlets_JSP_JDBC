/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import WebDBApp.myclasses.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class UpdateData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /*   global varibles */
    String query; 
    Connection conn;
    Statement st; 
    ResultSet rs; 
    DatabaseConnection dbconn;
    PreparedStatement ps; 
    int i, vb; 
    String studnr, surname, initials, sex, birthdate;  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        try {
          dbconn = new DatabaseConnection(); 
            
            studnr = request.getParameter("studnr") ; 
            surname = request.getParameter("surname")  ;
            initials  = request.getParameter("initials")  ;
            sex  = request.getParameter("sex")  ; 
            birthdate  = request.getParameter("birthdate") ;         
            
            conn = dbconn.setConnection(); 
            st = conn.createStatement(); 
             /* query = "update s_student set surname = '" + surname + "', initials = '" 
                    + initials + "', sex = '" + sex + "', birthdate = '" + birthdate + " where studnr = '" + studnr + "'" ;
            i = st.executeUpdate(query); */
            
            String sql = "update s_student set surname =?, initials=?, sex=?, birthdate=? where studnr=?";
            ps = conn.prepareCall(sql); 
            ps.setString(1, surname );
            ps.setString(2, initials );
            ps.setString(3, sex );
            ps.setString(4, birthdate );
            ps.setString(5, studnr );           
            vb = ps.executeUpdate(); 
            
                      
        }
        
        catch(Exception ex)
        {
            
        }
        
        finally
        {
            if(vb > 0)
            {
               RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
               rd.forward(request, response); 
               out.close(); 
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
