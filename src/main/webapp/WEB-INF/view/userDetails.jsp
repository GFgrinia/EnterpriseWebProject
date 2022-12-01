<%@ include file="common/header.jsp"%>

<div class="col-9">
    <div class="row">
        <div class="mx-auto">
            <h3>USER DETAILS</h3>
        </div>
    </div>


        <div class="row">
            <div class="col-6">
                <table class="table">
                    <tbody>
                        <tr>
                            <th scope="col">ID</th>
                            <td>${userById.id}</td>
                        </tr>
                        <tr>
                            <th scope="col">Name</th>
                            <td>${userById.name}</td>
                        </tr>
                        <tr>
                            <th scope="col">E-mail</th>
                            <td>${userById.email}</td>
                        </tr>
                        <tr>
                            <th scope="col">Passport #</th>
                            <td>${userById.passport}</td>
                        </tr>

                    <c:if test="${user.roleName == userAsAdmin}">
                            <th scope="col">Role</th>
                            <td>${userById.roleName}</td>
                        </tr>
                        <tr>
                            <th scope="col">Access Level</th>
                            <td>${userById.accessLevel}</td>
                        </tr>
                    </c:if>

                    </tbody>
                </table>

            </div>



            <div class="col-6">
                <div class="row" >
                    <div class="mx-auto">
                        <a href="<c:url value="/requests?userId=${userById.id}"/>"><button class="menu">Requests</button></a>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <br>
                        <br>
                    </div>
                </div>

                <div class="row">
                    <div class="mx-auto">
                        <a href="<c:url value="/payments?userId=${userById.id}"/>"><button class="menu">Payments</button></a>
                    </div>
                </div>
            </div>
        </div>



    <div class="row">
        <div class="col">
            <br>
            <br>
            <br>
        </div>
    </div>



</div>


</div>

</body>
</html>


