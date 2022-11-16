<%@ include file="common/header.jsp"%>



<div class="horizontal-block">

    <div class="table-content">
        <div class="horizontal-menu">
            <a href="<c:url value="/cars"/>"><button class="menu">All</button></a>
            <a href="<c:url value="/cars?status=free"/>"><button class="menu">Free</button></a>
            <a href="<c:url value="/cars?status=service"/>"><button class="menu">Service</button></a>
            <a href="<c:url value="/cars?status=reserved"/>"><button class="menu">Reserved</button></a>
            <a href="<c:url value="/cars?status=repair"/>"><button class="menu">Repair</button></a>
            <a href="<c:url value="/cars?status=in use"/>"><button class="menu">In Use</button></a>
        </div>
    </div>


    <div class="table-content">
        <c:choose>
            <c:when test="${status == null}">
                <p>Show: ALL</p>
            </c:when>
            <c:otherwise>
                <p>Show: ${status}</p>
            </c:otherwise>
        </c:choose>


        <br>
        <c:forEach items="${users}" var = "user">
            ${user.id} - ${user.name} - ${user.email} - ${user.role.name} - Access: ${user.role.access}
            ---><a href="<c:url value="/user?id=${user.id}"/>">Show user details</a> <br>
        </c:forEach>

    </div>



</div>


</div>

<%@ include file="common/footer.jsp"%>







