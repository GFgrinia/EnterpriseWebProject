


<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <c:if test="${userRole == admin}">
            <th scope="col">Username</th>
        </c:if>
        <th scope="col">Model</th>
        <th scope="col">Status</th>
        <th scope="col">Details</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${requests}" var = "request">
        <tr>
            <th scope="row">${request.id}</th>
            <c:if test="${userRole == admin}">
                <td>${request.username}</td>
            </c:if>
            <td>${request.model}</td>
            <td>${request.status}</td>
            <td><a href="<c:url value="/requests?id=${request.id}"/>"><button class="detailsButton">Details</button></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
