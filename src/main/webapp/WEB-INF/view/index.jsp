<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Main page</title>
</head>

<body>

<a href="<c:url value="/cars"/>">View cars</a> <br>
<a href="<c:url value="/users"/>">View users</a> <br>
<a href="<c:url value="/requests"/>">View requests</a> <br>
<a href="<c:url value="/payments"/>">View payments</a> <br>
<br>

</body>

</html>