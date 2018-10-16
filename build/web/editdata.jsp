<%-- 
    Document   : editdata
    Created on : 09 Sep 2018, 6:36:28 PM
    Author     : Mathekga M. Emmanuel
--%>

<%-- <%@page import="javax.resource.cci.ResultSet"%> --%>
<%@page  import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Edit Student Details</title>
    </head>
    <body>
        <form action="UpdateData" method="post">
        <table align="center" border="1px" width="80%">
             
                <% ResultSet res = (ResultSet) request.getAttribute("EditData") ; %>
                <% if(res.next())
                    { %>
                    
                    <tr>
                        <td>Student Number </td> <td> <input type="text" name="studnr" value=<%=res.getString("studnr")%>>  </td>
                    </tr>
                    <tr>
                        <td> Surname</td> <td> <input type="text" name="surname" value=<%=res.getString("surname")%>> </td>
                    </tr>
                    <tr>
                        <td> Initials</td> <td> <input type="text" name="initials" value=<%=res.getString("initials")%>> </td>
                    </tr>
                    <tr> 
                        <td> Sex </td> <td> <input type="text" name="sex" value=<%=res.getString("sex")%> > </td>
                    </tr>
                    <tr> 
                         <td> Birthdate </td> <td> <input type="text" name="birthdate" value=<%=res.getString("birthdate")%> > </td>
                    </tr>
                   <% } %>
            
        </table>
                   </br> </br>
                   <table align="center">
                       <tr> 
                           <td> <input type="submit" name="update" value="Update Record" class="btn btn-primary" > </td>
                        </tr>
                   </table>
        </form>
    </body>
</html>
