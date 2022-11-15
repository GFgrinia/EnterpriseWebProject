<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring-form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>List of Cars</title>

</head>

<body>
List of cars
<a href="<c:url value="/"/>">Back to Main</a> <br>
<br>
<a href="<c:url value="/cars"/>">All</a> <br>
<a href="<c:url value="/cars?status=free"/>">Free</a> <br>
<a href="<c:url value="/cars?status=service"/>">Service</a> <br>
<a href="<c:url value="/cars?status=reserved"/>">Reserved</a> <br>
<a href="<c:url value="/cars?status=repair"/>">Repair</a> <br>
<a href="<c:url value="/cars?status=in use"/>">In Use</a> <br>
<br>

<c:url value="/cars" var = "carFilter"/>



<spring-form:form action="${carFilter}" modelAttribute="carStatusDto" method="post">

    <spring-form:label path="status">Rent</spring-form:label>
    <spring-form:button type="submit"  name="Free" path="status">
        Filter Free
    </spring-form:button>

    <br>

    Filter:
    Free <spring-form:radiobutton path="status" value="Free"/>
    Reserved <spring-form:radiobutton path="status" value="Reserved"/>
    <%--        --%>
    <%--        <spring-form:label for="statuses" path="statusId" >Select car status:</spring-form:label>--%>
    <%--        <spring-form:select name="cars" id="statuses" path="statusId">--%>
    <%--            <option value="0">All</option>--%>
    <%--            <option value="1">Free</option>--%>
    <%--            <option value="1">Free</option>--%>
    <%--            <option value="3">Reserved</option>--%>
    <%--            <option value="4">Repair</option>--%>
    <%--        </spring-form:select>--%>
    <br>
    <br>

    <input type = "submit" value = "Select">

</spring-form:form>



-----------------------------------------------------------------<br>

<c:forEach items="${cars}" var = "car">
    ${car.id} - ${car.vendor} - ${car.model} - ${car.carStatus.status}<br>
</c:forEach>

<br>
<a href="<c:url value="/addNewCar"/>">Add new Car</a> <br>

</body>

</html>