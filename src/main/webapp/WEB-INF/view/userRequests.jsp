<%@ include file="common/header.jsp"%>

<div class="col-9">


    <div class="row">
        <div class="mx-auto">
            <h3>USER REQUEST LIST</h3>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <br>
        </div>
    </div>


    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Model</th>
                <th scope="col">Rent</th>
                <th scope="col">Duration</th>
                <th scope="col">Date</th>
                <th scope="col">Status</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${requests}" var = "request">
                <tr>
                    <th scope="row">${request.id}</th>
                    <td>${request.model}</td>
                    <td>${request.rent}</td>
                    <td>${request.rentDuration} d.</td>
                    <td>${request.date}</td>
                    <td>${request.status}</td>
                    <td><a href="<c:url value="/requests/pay/${userId}/${request.id}"/>"><button class="detailsButton">Pay</button></a></td>
                    <td><a href="<c:url value="/requests/return/${userId}/${request.id}"/>"><button class="detailsButton">Return</button></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</div>




</body>

</html>