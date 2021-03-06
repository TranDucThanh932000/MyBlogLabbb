<%-- 
    Document   : header
    Created on : Jan 11, 2021, 10:38:00 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrap">
            <div class="preheader">
                <h3 class="name-page">My blogs</h3>
            </div>
            <div class="menu">
                <ul class="h_ul">
                    <li class="h_li">
                        <div>
                            <div>
                                <a href="../MyBlog/HomePage?indexMenu=1">Home</a>
                            </div>
                            <div class="h-img">
                                <c:if test ="${indexMenu==1}">
                                    <img class="h_img" src="image/img02.jpg"/>
                                </c:if>
                            </div>   
                        </div>
                    </li>
                    <li class="h_li">
                        <div>
                            <div>
                                <a href="../MyBlog/Contact">Contact</a>
                            </div>
                            <div class="h-img">
                                <c:if test ="${indexMenu==2}">
                                    <img class="h_img" src="image/img02.jpg"/>
                                </c:if>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>
