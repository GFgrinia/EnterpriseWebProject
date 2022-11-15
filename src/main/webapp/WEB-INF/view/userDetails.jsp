<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>User Details</title>
</head>

<body>
User Info <br> <br>



ID: ${user.id}<br>
NAME: ${user.name}<br>
PASSPORT: ${user.passport} <br>
EMAIL: ${user.email} <br>
ROLE: ${user.role.name}[${user.role.access}] <br>
---><a href="<c:url value="/userRequests?id=${user.id}"/>">Show user requests</a> <br>
---><a href="<c:url value="/userRequests?id=${user.id}"/>">Show user payments</a> <br>


<br>

<a href= "<c:url  value = "/users"/>">Back to Users</a>

</body>

</html>