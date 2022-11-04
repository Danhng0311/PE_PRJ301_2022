<%-- 
    Document   : Chat
    Created on : Oct 25, 2022, 1:57:52 AM
    Author     : Anh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dal.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="models.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <c:forEach items="${ths}" var="ths">
            <form action="discuss?id=${ths.getTid()}&userid=${username}" method="post">  
                Thread: ${ths.getTcontent()}<br>


                <c:forEach items="${cmt}" var="c">
                    <c:forEach items="${ac2}" var="ac">

                        <c:if test="${c.getUserid() == ac.getUserid()}">
                            <c:if test="${c.getTid() == ths.getTid()}">
                                ${ac.getDisplayname()}
                                ${c.getCtitle()}<br>
                            </c:if>

                        </c:if>

                    </c:forEach>
                </c:forEach>
                <input type="text" name="txtName"/>
                <input type="submit" value="Save"/>
                <br>
            </form>
        </c:forEach>


    </body>
</html>
