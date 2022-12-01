<%@ include file="common/header.jsp"%>

        <div class="col-9">
            <div class="row">
                <div class="text-muted text-left">
                    ${message}
                </div>
            </div>
            <div class="row">
                <c:if test="${user.roleName == userAsAdmin || user.roleName == userAsUser}">
                    <div class="col-2">
                        <a href="<c:url value="/requests"/>"><button class="filter">All</button></a>
                    </div>
                </c:if>
                <div class="mx-auto">
                    <h3>REQUEST LIST</h3>
                </div>
            </div>

            <c:if test="${user.roleName == userAsAdmin || user.roleName == userAsUser}">
                <div class="row">
                    <%@ include file="common/filterRequestButtons.jsp"%>
             </div>
            </c:if>

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






