<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Username</th>
        <th scope="col">Role</th>
        <th scope="col">Details</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${users}" var = "user">
        <tr>
            <th scope="row">${user.id}</th>
            <td>${user.name}</td>
            <td>${user.roleName}</td>
            <td><a href="<c:url value="/users/${user.id}"/>"><button class="detailsButton">Details</button></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>




