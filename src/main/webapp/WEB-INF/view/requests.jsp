<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>List of Requests</title>

</head>

<body>
List of requests
<a href="<c:url value="/"/>">Back to Main</a> <br>
<br>
<a href="<c:url value="/requests"/>">All</a> <br>
<a href="<c:url value="/requests?status=Awaiting approval"/>">Awaiting approval</a> <br>
<a href="<c:url value="/requests?status=Awaiting payment"/>">Awaiting payment</a> <br>
<a href="<c:url value="/requests?status=Active"/>">Active</a> <br>
<a href="<c:url value="/requests?status=Completed"/>">Completed</a> <br>
<a href="<c:url value="/requests?status=Overdue"/>">Overdue</a> <br>
<a href="<c:url value="/requests?status=Rejected"/>">Rejected</a> <br>
<br>

<c:forEach items="${requests}" var = "request">
    ${request.id} - ${request.user.name} - ${request.car.vendor} - ${request.car.model} - ${request.startDate} - ${request.requestStatus.status}<br>
</c:forEach>

</body>

</html>