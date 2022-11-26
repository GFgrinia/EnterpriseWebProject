<%@ include file="common/header.jsp"%>


    <div class="col-9">
        <div class="row">
            <div class="mx-auto">
                <h3>REQUEST DETAILS</h3>
            </div>
        </div>


        <div class="row">
            <div class="col-6">
                <table class="table">
                    <tbody>
                    <tr>
                        <th scope="col">ID</th>
                        <td>${request.id}</td>
                    </tr>

                    <c:if test="${userRole == admin}">
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
                    <c:if test="${userRole == admin}">
                        <tr>
                            <th scope="col">Comment</th>
                            <td>${request.comment}</td>
                        </tr>
                    </c:if>

                    </tbody>
                </table>

            </div>



            <div class="col-6">



                    <c:if test="${request.status == statusApproval && userRole == admin}">
                        <div class="row" >
                            <div class="mx-auto">
                                <a href="<c:url value="/requests/approve/${request.id}"/>"><button class="menu">Approve</button></a>
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
                                <a href="<c:url value="/requests/reject/${request.id}"/>"><button class="alertButton">Reject</button></a>
                            </div>
                        </div>
                    </c:if>


                <c:if test="${ userRole == user}">

                        <c:if test="${request.status == statusActive}">
                            <div class="row" >
                                <div class="mx-auto">
                                    <a href="<c:url value="/requests/return"/>"><button class="menu">Return Car</button></a>
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
                                    <a href="<c:url value="/requests/return"/>"><button class="alertButton">Return DAMAGED</button></a>
                                </div>
                            </div>
                        </c:if>


                        <c:if test="${request.status == statusApproval}">
                            <div class="row" >
                                <div class="mx-auto">
                                    <a href="<c:url value="/requests/return"/>"><button class="menu">CANCEL ORDER</button></a>
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


