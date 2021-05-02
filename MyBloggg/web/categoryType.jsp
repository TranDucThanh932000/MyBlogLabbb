<%-- 
    Document   : categoryType
    Created on : Jan 13, 2021, 10:23:06 PM
    Author     : asus
--%>
<%@page import="javax.naming.Context"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/left.css" rel="stylesheet" type="text/css"/>
        <link href="css/categoryType.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="all">
            <div class="wrap-all">
                <jsp:include page="component/header.jsp"></jsp:include>
                    <div class="main">
                        <div class="left">
                            <c:if test="${error!=null}">
                                <h3 class="error">${error}</h3>
                            </c:if>
                        <c:if test="${error==null}">
                            <div class="preleft">
                                <span class="cato">Category ${category} • </span>
                            <span>Full Category</span>
                        </div>
                        <c:forEach var="cbt" items="${categorybytype}">
                            <div class="title">
                                <h2><a href="HomePage?id=${cbt.id}">${cbt.title}</a></h2>
                            </div>
                            <div class="time">
                                <span class="time-release">Posted on ${cbt.convertDate()} • </span>
                                <span>Full Article</span>
                            </div>
                            <div class="content-short">
                                <div class="content-left">
                                    <img src="image/img03.jpg"/>
                                </div>
                                <div class="content-right">${cbt.shortdes}</div>
                            </div>
                            <hr class="hr"/>
                        </c:forEach>
                        <div class="paging">
                            <c:forEach begin="1" end="${maxPage}" var="i">
                                <c:choose>
                                    <c:when test="${index==i}">
                                        <button class="canhbao">${i}</button>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="canhbao2" href="CategoryType?index=${i}&category=${category}">${i}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </div>
                            
                        <jsp:include page="component/footer.jsp"></jsp:include>
                        </c:if>
                        </div>
                    <jsp:include page="component/right.jsp"></jsp:include>
                </div>
            </div>
        </div>
    </body>
</html>
