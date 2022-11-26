<%@ include file="common/header.jsp"%>

        <div class="col-9">


            <div class="row">
                <div class="col-2">
                    <a href="<c:url value="/requests"/>"><button class="filter">All</button></a>
                </div>
                <div class="mx-auto">
                    <h3>REQUEST LIST</h3>
                </div>
            </div>


            <div class="row">
                <%@ include file="common/filterRequestButtons.jsp"%>
            </div>


            <div class="row">
                <div class="col">
                    <br>
                </div>
            </div>


            <div class="row">
                <%@ include file="common/filterRequest.jsp"%>
            </div>
        </div>


</div>






