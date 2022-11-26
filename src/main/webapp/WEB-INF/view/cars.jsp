<%@ include file="common/header.jsp"%>

            <div class="col-9">
                <div class="row">
                    <div class="text-muted text-left">
                       ${message}
                    </div>
                </div>

                <div class="row">
                    <div class="mx-auto">
                        <h3>CAR LIST</h3>
                    </div>
                </div>

                <div class="row">
                    <%@ include file="common/filterCarButtons.jsp"%>
                </div>

                <div class="row p-2">
                    <div class="mx-auto">
                        <div class="col">
                            <a href="<c:url value="/cars/carNew"/>"><button class="login">Add New Car</button></a>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <br>
                    </div>
                </div>


                <div class="row">
                    <%@ include file="common/filterCar.jsp"%>
                </div>
            </div>


</div>










    </body>
</html>







