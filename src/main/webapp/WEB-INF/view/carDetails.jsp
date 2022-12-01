<%@ include file="common/header.jsp"%>

    <div class="col-9">


        <c:if test="${user.roleName == userAsAdmin}">
                <div class="row">
                    <%@ include file="common/filterCarButtons.jsp"%>
                </div>
        </c:if>


        <c:url value="/carNew" var="addNewCarAction"/>
        <spring-form:form action="${addNewCarAction}" modelAttribute="carDto" method="post">
                <div class="row">
                                <div class="col">
                                    <br>
                                        <div class="row">
                                            <div class="col-2">
                                                <spring-form:label path="id">ID: </spring-form:label>
                                            </div>

                                            <div class="col-4">
                                                <spring-form:input readonly="true" path="id" value="${car.id}"  />
                                            </div>

                                        </div>

                                        <div class="row" align="right">
                                            <div class="col-2">
                                                <spring-form:label path="vendor">Vendor: </spring-form:label>
                                            </div>
                                            <div class="col-4">
                                                <spring-form:input path="vendor" value="${car.vendor}"/>
                                            </div>
                                        </div>

                                        <div class="row" align="right">
                                            <div class="col-2">
                                                <spring-form:label path="model">Model: </spring-form:label>
                                            </div>
                                            <div class="col-4">
                                                <spring-form:input path="model" value="${car.model}"/>
                                            </div>
                                        </div>

                                        <div class="row" align="right">
                                            <div class="col-2">
                                                <spring-form:label path="rent">Rent: </spring-form:label>
                                            </div>
                                            <div class="col-4">
                                                <spring-form:input type="number" path="rent" value="${car.rent}"/>
                                            </div>
                                        </div>
                                </div>



                                <div class="col">
                                    <div class="row">
                                        <div class="col">
                                            <br>
                                            Current car status:
                                        </div>
                                        <div class="col">
                                            <br>
                                                ${car.status}
                                        </div>
                                    </div>

                                    <c:if test="${user.roleName == userAsAdmin}">
                                        <div class="row">
                                            <div class="col">
                                                <br>
                                                <spring-form:label for="cars" path="status">Set status:</spring-form:label>
                                            </div>
                                            <div class="col">
                                                <br>
                                                <spring-form:select name="cars" id="cars" path="status">
                                                    <option value="Service">Service</option>
                                                    <option value="Repair">Repair</option>
                                                    <option value="Free">Free</option>
                                                </spring-form:select>
                                            </div>
                                        </div>


                                        <div class="row">
                                            <div class="col">
                                                <br>
                                                <input type="submit" value="Update Car Info" class="login">
                                            </div>
                                        </div>
                                    </c:if>


                                </div>
                </div>
        </spring-form:form>




                <div class="row">
                    <div class="col">
                        <br>
                        <br>
                        <br>
                    </div>
                </div>

            <c:if test="${user.roleName == userAsUser}">
                <div class="row">
                    <div class="col">
                        <br>
                    </div>
                </div>
                <div class="row">
                    <div class="mx-auto">
                        <a href="<c:url value="/requestNew?carId=${car.id}"/>"><button class="confirmButton">Rent This Car [+]</button></a>
                    </div>
                </div>
            </c:if>

            <c:if test="${user.roleName == userAsAdmin}">
                <div class="row">
                    <div class="mx-auto">
                        <a href="<c:url value="/delete/${car.id}"/>"><button class="alertButton">Remove Car [X]</button></a>
                    </div>
                </div>
            </c:if>





    </div>


</div>

</body>
</html>











