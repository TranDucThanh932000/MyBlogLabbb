<%-- 
    Document   : contact
    Created on : Jan 12, 2021, 3:18:42 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/left.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/right.css" rel="stylesheet" type="text/css"/>
        <script src="js/newjavascript.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="all">
            <div class="wrap-all">
                <jsp:include page="component/header.jsp"></jsp:include>
                    <div class="main">
                        <div class="border-form">
                            <p class="name-form">All fields are required</p>
                            <div class="form-info">
                                <div class="name-input">
                                    <p>Name:</p>
                                    <p>Email:</p>
                                    <p>Phone:</p>
                                    <p>Company:</p>
                                    <p>Message:</p>
                                </div>
                                <form class="info" action="../MyBlog/Contact" method="POST">
                                    <input class="inputshort" type="text" name="name" required placeholder="" value="${name}"/></br>
                                <input class="inputshort" type="text" name="email" required placeholder="" value="${email}"/></br>
                                <input class="inputshort" id="phone" type="text" name="phone" required placeholder="" value="${phone}"/></br>
                                <input class="inputshort" type="text" name="company" required placeholder="" value="${company}"/></br>
                                <input class="inputlong" type="text" name="cmt" required placeholder="" value="${mess}"/></br>
                                    <button class="btn">send</button>
                                </form>
                            </div>
                        </div>
                    <jsp:include page="component/right.jsp"></jsp:include>
                </div>
            </div>
        </div>
    </body>
</html>
