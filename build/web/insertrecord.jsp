<%-- 
    Document   : insertrecord
    Created on : 05 Sep 2018, 9:10:45 PM
    Author     : Mathekga M. Emmanuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        
        <title>JSP Page</title>
    </head>
    <body>
        <form  action="InsertData"  method="post">
        <table align="center"  >
            </br></br> 
            <tr>
                <td>Student Number</td>    
                <td> <input type="=text" class="form-control" placeholder="student number"  name="STUDNR"/> </td>
            </tr>
            
             <tr>
                <td>Surname</td>    
                <td> <input type="=text" class="form-control" placeholder="surname" name="SURNAME"/> </td>
            </tr>
            
             <tr>
                <td>Initials</td>    
                <td> <input type="=text" class="form-control" placeholder="initials" name="INITIALS"/> </td>
            </tr>
            
             <tr>
                <td>Sex</td>    
                <td> <input type="=text" class="form-control" placeholder="sex/gender" name="SEX"/> </td>
            </tr>
             <tr>
                <td>Birthdate</td>              
                 <td> <input type="=text"  class="form-control" placeholder="birthdate" name="BIRTHDATE"/> </td>            
            </tr>         
        </table>
        
        <table align="center">
            
        </br></br> 
                <tr> 
                    <td> <input type="submit" class="btn btn-primary" value="Send To Database" align="center"/> </td>
                </tr>
        </table>
            
        </form>
    </body>
</html>
