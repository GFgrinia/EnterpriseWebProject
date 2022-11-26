<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Model</th>
        <th scope="col">Status</th>
        <th scope="col">Details</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${cars}" var = "car">
        <tr>
            <th scope="row">${car.id}</th>
            <td>${car.vendor} ${car.model}</td>
            <td>${car.status}</td>
            <td><a href="<c:url value="/cars/${car.id}"/>"><button class="detailsButton">Details</button></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>