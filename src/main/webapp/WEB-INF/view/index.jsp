<%@ page contentType="text/html" isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring-form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>

    <c:if test="${empty page_title}">
        <c:set var="page_title" value="Prototype"/>
    </c:if>
    <title>${page_title}</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <link href="<c:url value="/resources/main_style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/collapsible_menu.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/scripts.js" />"></script>

</head>

<body>

    <%--Header--%>
    <div class="container">
        <div class="row">
            <div class="col">
                <a href="<c:url value="/"/>"><button class="login">#MainPage</button></a>
            </div>
            <div class="col">
                <h3>Car Rental</h3>
            </div>
            <div class="col">
                <h3> </h3>
            </div>
            <div class="col">
                <h3>{username}</h3>
            </div>
            <div class="col">
                <a href="<c:url value="/"/>"><button class="login">#Login</button></a>
            </div>
        </div>
        <div class="row">
            <hr style="height:2px;border-width:0;color:lightblue;background-color:lightblue;"><br>
        </div>
    </div>



    <div class="container">


        <div class="container">
            <div class="r">
                <%@ include file="common/menu.jsp" %>
            </div>
            <div class="horizontal-menu">
                <%@ include file="common/menu.jsp" %>
            </div>
        </div>
    </div>






</body>
</html>





