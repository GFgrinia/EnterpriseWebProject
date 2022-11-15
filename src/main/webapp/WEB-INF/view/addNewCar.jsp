<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring-form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Add new Car</title>

</head>

<body>
Add new car <br>
<a href="<c:url value="/cars"/>">Back to Cars</a> <br>
<br>
------------------------------------------------------------
<br>

    <c:url value="/addNewCar" var = "addNewCarAction"/>

    <spring-form:form action="${addNewCarAction}" modelAttribute="carSaveDto" method="post">

        <spring-form:label path="vendor">Vendor</spring-form:label>
        <spring-form:input type="text" path="vendor" placeholder="Enter Vendor"/>
        <br>

        <spring-form:label path="model">Model</spring-form:label>
        <spring-form:input type="text" path="model" placeholder="Enter Model"/>
        <br>

        <spring-form:label path="rent">Rent</spring-form:label>
        <spring-form:input type="number" path="rent" placeholder="Enter Rent amount"/>
        <br>

        <spring-form:label for="cars" path="statusId" >Select car status:</spring-form:label>
        <spring-form:select name="cars" id="cars" path="statusId">
            <option value="1">Free</option>
            <option value="3">Reserved</option>
            <option value="4">Repair</option>
        </spring-form:select>
        <br>
        <br>

        <input type = "submit" value = "Add new Car">

    </spring-form:form>


</body>

</html>