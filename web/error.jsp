<%-- 
    Document   : error
    Created on : 05 Sep 2018, 10:20:13 PM
    Author     : Mathekga M. Emmanuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Error: <%=(String)request.getAttribute("Error") %></h3>
    </body>
</html>
