<%@ page  isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <link href="<c:url value="/resources/main_style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/collapsible_menu.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/scripts.js" />"></script>

</head>

<body>
<c:set var="userAsAdmin" value="ROLE_ADMIN"/>
<c:set var="userAsUser" value="ROLE_USER"/>
<c:set var="userAsGuest" value="ROLE_GUEST"/>

<c:set var="statusApproval" value="Awaiting approval"/>
<c:set var="statusPayment" value="Awaiting payment"/>
<c:set var="statusActive" value="Active"/>
<c:set var="statusDamaged" value="Damaged"/>

<%--Header--%>
<div class="container">
    <div class="row">
        <div class="col-2">
            <a href="<c:url value="/cars"/>"><button class="login">#MainPage</button></a>
        </div>
        <div class="col-3 text-primary mx-auto" >
            <h2>${headerMessage}</h2>

            <c:choose>
                <c:when test="${user !=  null}"><h3>Hello: ${user.name}</h3></c:when>
                <c:otherwise><h3>Hello: Guest</h3></c:otherwise>
            </c:choose>
        </div>


        <c:choose>
            <c:when test="${user.roleName == userAsAdmin || user.roleName == userAsUser}">
                <div class="col-3">
                    <a href="<c:url value="/logout"/>"><button class="login">Log out</button></a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="col-3">
                    <a href="<c:url value="/registration"/>"><button class="login">Register</button></a>
                </div>
                <div class="col-3">
                    <a href="<c:url value="/login"/>"><button class="login">Log in</button></a>
                </div>
            </c:otherwise>
        </c:choose>

    </div>



    <div class="row">
        <hr style="height:2px;border-width:0;color:lightblue;background-color:lightblue;"><br>
    </div>
</div>



<div class="container">
        <div class="row">
            <div class="col-3">
                <%@ include file="menu.jsp" %>
            </div>

