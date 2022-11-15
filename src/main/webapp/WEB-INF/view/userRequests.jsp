<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>User Requests</title>
</head>

<body>
User Requests <br> <br>





<c:forEach items="${requests}" var = "request">
    ${request.id} - ${request.user.name} - ${request.car.vendor} - ${request.car.model} - ${request.startDate} - ${request.requestStatus.status}<br>
</c:forEach>

<br>

---><a href="<c:url value="/user?id=${userId}"/>">Back to User Details</a> <br>

</body>

</html>