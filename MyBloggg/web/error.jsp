<%-- 
    Document   : error
    Created on : Jan 14, 2021, 2:04:18 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/left.css" rel="stylesheet" type="text/css"/>
        <link href="css/error.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="all">
            <div class="wrap-all">
                <jsp:include page="component/header.jsp"></jsp:include>
                <div class="main">
                    <div class="error">
                        <h3>${error}</h3>
                    <h3><a href="Contact">Return</a></h3>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
