<%@ include file="common/header.jsp" %>

    <div class="col-9">

        <c:url value="/carNew" var="addNewCarAction"/>
        <spring-form:form action="${addNewCarAction}" modelAttribute="carDto"  method="post">

        <div class="row">
            <div class="col-5" align="right">
                <spring-form:label path="vendor">Vendor: </spring-form:label>
            </div>
            <div class="col-6">
                <spring-form:input type="text" path="vendor" placeholder="Enter Vendor"/>
            </div>
        </div>


        <div class="row">
            <div class="col-5" align="right">
                <spring-form:label path="model">Model: </spring-form:label>
            </div>
            <div class="col-6">
                <spring-form:input type="text" path="model" placeholder="Enter Model"/>
            </div>
        </div>


        <div class="row">
            <div class="col-5" align="right">
                <spring-form:label path="rent">Rent: </spring-form:label>
            </div>
            <div class="col-6">
                <spring-form:input type="number" path="rent" placeholder="Enter Rent amount"/>
            </div>
        </div>


        <div class="row">
            <div class="col-5" align="right">
                <spring-form:label for="cars" path="status">Select car status:</spring-form:label>
            </div>
            <div class="col-6">
                <spring-form:select name="cars" id="cars" path="status">
                    <option value="Free">Free</option>
                    <option value="Reserved">Reserved</option>
                    <option value="Repair">Repair</option>
                </spring-form:select>
            </div>
        </div>



        <div class="row p-3">
            <div class="mx-auto">
                <input type="submit" value="Add new Car" class="login">
            </div>
        </div>
        </spring-form:form>


    </div>
        <br>
        <br>


    </div>










</body>
</html>

