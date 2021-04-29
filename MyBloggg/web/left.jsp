<%-- 
    Document   : left
    Created on : Jan 11, 2021, 11:05:49 PM
    Author     : asus
--%>

<%@page import="java.util.List"%>
<%@page import="model.Blog"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/left.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/right.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="all">
            <div class="wrap-all">
                <jsp:include page="component/header.jsp"></jsp:include>
                    <div class="main">
                        <div class="left">
                            <div class="preleft">
                                <span class="cato">Category ${current.category} • </span>
                                <span>Full Category</span>
                            </div>
                            <div class="title">
                                <h2>${current.title}</h2>
                            </div>
                            <div class="time">
                                <span class="time-release">Posted on ${current.convertDate()} • </span>
                                <span>Full Article</span>
                            </div>
                            <div class="content">
                                <div class="content-left">
                                    <img src="image/img03.jpg"/>
                                </div>
                                <div class="content-right">${current.content}
                                </div>
                            </div>
                            <hr class="hr"/>
                        <jsp:include page="component/footer.jsp"></jsp:include>
                        </div>
                    <jsp:include page="component/right.jsp"></jsp:include>
                </div>
            </div>
        </div>
    </body>
</html>
