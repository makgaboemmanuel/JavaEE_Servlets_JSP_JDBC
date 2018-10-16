<%-- 
    Document   : displayrecord
    Created on : 06 Sep 2018, 10:29:06 PM
    Author     : Mathekga M. Emmanuel
--%>


<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Details</title>
    </head>
    <body>
        
        <%-- the editing java script --%>
        
        <script type="text/javascript">
            function editRecord(studnr)
            {
                url = "EditRecord"; 
                window.location.href = "http://localhost:8080/WebDBApp/EditRecord" + "?studnr=" + studnr;
            }
        </script>
        
        <%-- the editing java script --%>
        
        <table align="center" border="1px" width="80%">
            <tr> <th> Student Number:</th> <th> Surname </th> 
                <th> Initials</th>  <th> Gender</th> 
                <th> Birthdate</th>
                <th> Edit Record</th>
                <th> Delete Record</th>
            </tr>
            <%Iterator itr;%>
            <%List data = (List) request.getAttribute("StudentData");
            for(itr = data. iterator(); itr.hasNext(); )
            { %>
              
            <tr>
                <% String s = (String) itr.next(); %>
                <td align="center"> <%=s%> </td>
                <td align="center"> <%=itr.next()%> </td>
                <td align="center"> <%=itr.next()%> </td>
                <td align="center"> <%=itr.next()%> </td> 
                <td align="center"> <%=itr.next()%> </td>   
                <td align="center"> <input type="submit" value="Edit" name="edit" onclick="editRecord(<%=s%>);"> </td> 
                <td align="center"> <input type="submit" value="Delete" name="delete" onclick="deleteRecord(<%=s%>);"> </td>
           <% } %>
            
            </tr> 
            
        </table>
    </body>
</html>
