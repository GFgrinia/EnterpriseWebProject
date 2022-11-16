<%@ include file="common/header.jsp" %>


    <div class="horizontal-block">


        <div class="table-content">
            <c:url value="/cars/addNewCar" var="addNewCarAction"/>

            <spring-form:form action="${addNewCarAction}" modelAttribute="carSaveDto"  method="post">

                <spring-form:label path="vendor">Vendor: </spring-form:label>
                <spring-form:input type="text" path="vendor" placeholder="Enter Vendor"/>
                <br>

                <spring-form:label path="model">Model: </spring-form:label>
                <spring-form:input type="text" path="model" placeholder="Enter Model"/>
                <br>

                <spring-form:label path="rent">Rent: </spring-form:label>
                <spring-form:input type="number" path="rent" placeholder="Enter Rent amount"/>
                <br>

                <spring-form:label for="cars" path="statusId">Select car status:</spring-form:label>
                <spring-form:select name="cars" id="cars" path="statusId">
                    <option value="1">Free</option>
                    <option value="3">Reserved</option>
                    <option value="4">Repair</option>
                </spring-form:select>
                <br>
                <br>

                <input type="submit" value="Add new Car">

            </spring-form:form>

        </div>


    </div>


</div>

<%@ include file="common/footer.jsp" %>







