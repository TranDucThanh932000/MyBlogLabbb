<%-- 
    Document   : right
    Created on : Jan 12, 2021, 10:35:27 AM
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/right.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrap-right">
            <div class="entry">
                <p>Categories</p>
            </div>
            <hr class="hr"/>
            <c:forEach var="i" begin="0" end="${listCategory.size()-1}">
                <div class="category">
                    <img src="image/img01.jpg"/>
                    <a href="../MyBlog/CategoryType?category=${listCategory.get(i)}"><span>${listCategory.get(i)}</span></a>
                </div>
            </c:forEach>

        </div>
    </body>
</html>
