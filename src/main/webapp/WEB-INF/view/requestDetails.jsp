<%@ include file="common/header.jsp"%>


    <div class="col-9">
        <div class="row">
            <div class="mx-auto">
                <h3>REQUEST DETAILS</h3>
            </div>
        </div>


        <div class="row">
            <div class="col-8">
                <table class="table">
                    <tbody>
                    <tr>
                        <th scope="col">ID</th>
                        <td>${request.id}</td>
                    </tr>

                    <c:if test="${user.roleName == userAsAdmin}">
                        <tr>
                            <th scope="col">Username</th>
                            <td>${request.username}</td>
                        </tr>
                    </c:if>

                    <tr>
                        <th scope="col">Model</th>
                        <td>${request.model}</td>
                    </tr>
                    <tr>
                        <th scope="col">Rent</th>
                        <td>${request.rent}</td>
                    </tr>
                    <tr>
                        <th scope="col">Duration</th>
                        <td>${request.rentDuration}</td>
                    </tr>
                    <tr>
                        <th scope="col">Summary $</th>
                        <td>${request.rent * request.rentDuration}</td>
                    </tr>
                    <tr>
                        <th scope="col">Date</th>
                        <td>${request.date}</td>
                    </tr>
                    <tr>
                        <th scope="col">Status</th>
                        <td>${request.status}</td>
                    </tr>
                        <tr>
                            <th scope="col">Comment</th>
                            <td>${request.comment}</td>
                        </tr>

                    </tbody>
                </table>

            </div>



            <div class="col-6">



                    <c:if test="${request.status == statusApproval && user.roleName == userAsAdmin}">
                        <div class="row" >
                            <div class="mx-auto">
                                <a href="<c:url value="/requests/${request.id}?status=Awaiting payment"/>"><button class="confirmButton">Approve</button></a>
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
                                <a href="<c:url value="/requests/${request.id}?status=Rejected"/>"><button class="alertButton">Reject</button></a>
                            </div>
                        </div>
                    </c:if>


                    <c:if test="${user.roleName == userAsUser}">

                            <c:if test="${request.status == statusActive}">
                                <div class="row" >
                                    <div class="mx-auto">
                                        <a href="<c:url value="/requests/${request.id}?status=Completed"/>"><button class="menu">Return Car</button></a>
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
                                        <a href="<c:url value="/requests/${request.id}?status=Damaged"/>"><button class="alertButton">Return DAMAGED</button></a>
                                    </div>
                                </div>
                            </c:if>


                            <c:if test="${request.status == statusApproval}">
                                <div class="row" >
                                    <div class="mx-auto">
                                        <a href="<c:url value="/requests/${request.id}?status=Canceled"/>"><button class="menu">CANCEL ORDER</button></a>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col">
                                        <br>
                                        <br>
                                    </div>
                                </div>
                            </c:if>


                            <c:if test="${request.status == statusPayment}">
                                <div class="row" >
                                    <div class="mx-auto">
                                        <a href="<c:url value="/requests/${request.id}?status=Active"/>"><button class="menu">Pay $!</button></a>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col">
                                        <br>
                                        <br>
                                    </div>
                                </div>
                            </c:if>
                        <c:if test="${request.status == statusDamaged}">
                            <div class="row" >
                                <div class="mx-auto">
                                    <a href="<c:url value="/requests/${request.id}?status=Completed"/>"><button class="menu">Pay Damage$!</button></a>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col">
                                    <br>
                                    <br>
                                </div>
                            </div>
                        </c:if>
                    </c:if>


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


