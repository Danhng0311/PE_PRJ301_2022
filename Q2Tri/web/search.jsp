
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, td {
                border:1px solid black;

            }
            .header-text {
                text-align: center;
                /*font-weight: bold;*/
            }
        </style>
    </head>
    <body>
        <form action="search" method="post">
            Name <input type="text" name="txtSearch"/>
            <input type="submit" value="Search"/>
        </form>
        <br>
        <%
        if(request.getSession().getAttribute("st") != null) {
        %>
        <table style="width: 50%">
            <tr class="header-text">
                <td>sid</td>
                <td>name</td>
                <td>gender</td>
                <td>dob</td>
            </tr>
            <c:forEach items="${st}" var="st">
                <tr>               
                    <td>${st.getSid()}</td>
                    <td>${st.getName()}</td>
                    <td><c:out value="${st.isGender() eq true?1:0}"/></td>
                    <td>${st.getDob()}</td>

                </tr>
            </c:forEach> 
        </table>
        <%
            }
        %>

    </body>
</html>
