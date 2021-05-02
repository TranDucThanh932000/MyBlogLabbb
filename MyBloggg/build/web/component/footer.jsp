<%-- 
    Document   : footer
    Created on : Jan 12, 2021, 11:02:28 AM
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="footer">
            <ul class="f_ul">
                <c:forEach var="art" items="${list}">
                    <li>
                        <span class="f_title">${art.title}</span>
                        <span class="f_time"> Posted on ${art.convertDate()}</span>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
