<%-- 
    Document   : Login.jsp
    Created on : Oct 21, 2022, 8:35:43 AM
    Author     : Anh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post">
            <div>Username: <input type="text" name="username"/><br></div>
            <div>Password: <input type="password" name="password"/><br></div>
            <div><input type="submit" value="Login"/></div>
        </form>
        
        <c:out value="${msg}"/>
    </body>
</html>
