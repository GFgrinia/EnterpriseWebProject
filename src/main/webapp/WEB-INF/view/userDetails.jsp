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
                            <td>${user.id}</td>
                        </tr>
                        <tr>
                            <th scope="col">Name</th>
                            <td>${user.name}</td>
                        </tr>
                        <tr>
                            <th scope="col">E-mail</th>
                            <td>${user.email}</td>
                        </tr>
                        <tr>
                            <th scope="col">Passport #</th>
                            <td>${user.passport}</td>
                        </tr>
                        <tr>
                            <th scope="col">Role</th>
                            <td>${user.role}</td>
                        </tr>
                        <tr>
                            <th scope="col">Access Level</th>
                            <td>${user.access}</td>
                        </tr>


                    </tbody>
                </table>

            </div>



            <div class="col-6">
                <div class="row" >
                    <div class="mx-auto">
                        <a href="<c:url value="/requests/user/${user.id}"/>"><button class="menu">Requests</button></a>
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
                        <a href="<c:url value="/payments/user/${user.id}"/>"><button class="menu">Payments</button></a>
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


