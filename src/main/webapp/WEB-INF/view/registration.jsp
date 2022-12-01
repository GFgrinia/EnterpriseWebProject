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
        <div class="container">
            <div class="row">
                <div class="col-2">

                </div>
                <div class="col-4">
                    <a href="<c:url value="/cars"/>"><button class="login">#MainPage</button></a>
                </div>

                <div class="col-4">
                    <a href="<c:url value="/login"/>"><button class="login">Log in</button></a>
                </div>

            </div>


            <div class="row">
                <hr style="height:2px;border-width:0;color:lightblue;background-color:lightblue;"><br>
            </div>
        </div>



    <div class="container">


        <div class="row">

            <div class="col-9">

                <div class="row">
                    <div class="mx-auto">
                        <h3>Registration Form</h3>
                    </div>
                </div>


                <c:forEach items="${messages}" var = "message">
                    <div class="row">
                        <div class="text-danger mx-auto">
                            <h5>${message}<br></h5>
                        </div>
                    </div>
                </c:forEach>

                <div class="row"><br></div>


            <c:url value="/registration" var="registrationPage"/>
            <spring-form:form action="${registrationPage}" modelAttribute="loginDto"  method="post">

            <div class="row">
                <div class="col-5" align="right">
                    <spring-form:label path="name">Username: </spring-form:label>
                </div>
                <div class="col-6">
                    <spring-form:input type="text" path="name" placeholder="Enter username"/>
                </div>
            </div>


            <div class="row">
                <div class="col-5" align="right">
                    <spring-form:label path="password">Password: </spring-form:label>
                </div>
                <div class="col-6">
                    <spring-form:input type="password" path="password" placeholder="Enter password"/>
                </div>
            </div>




            <div class="row">
                <div class="col-5" align="right">
                    <spring-form:label path="passport">Passport #: </spring-form:label>
                </div>
                <div class="col-6">
                    <spring-form:input type="text" path="passport" placeholder="Enter Passport #"/>
                </div>
            </div>

            <div class="row">
                <div class="col-5" align="right">
                    <spring-form:label path="email">E-mail: </spring-form:label>
                </div>
                <div class="col-6">
                    <spring-form:input type="text" path="email" placeholder="Enter e-mail"/>
                </div>
            </div>


            <div class="row p-3">
                <div class="mx-auto">
                    <input type="submit" value="Register" class="login">
                </div>
            </div>

             </spring-form:form>


         </div>
        </div>

    </div>








</body>
</html>


