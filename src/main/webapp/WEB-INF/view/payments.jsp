<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>List of Payments</title>
</head>

<body>
List of payments
<a href="<c:url value="/"/>">Back to Main</a> <br>
<br>
<c:forEach items="${payments}" var = "payment">
    ${payment.id} - ${payment.paymentStatus.status} <br>
</c:forEach>

</body>

</html>