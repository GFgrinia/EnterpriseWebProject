<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>List of Users</title>
</head>

<body>
List of Users
<a href="<c:url value="/"/>">Back to Main</a> <br>
<br>
<c:forEach items="${users}" var = "user">
    ${user.id} - ${user.name} - ${user.email} - ${user.role.name} - Access: ${user.role.access}
    ---><a href="<c:url value="/user?id=${user.id}"/>">Show user details</a> <br>
</c:forEach>

</body>

</html>