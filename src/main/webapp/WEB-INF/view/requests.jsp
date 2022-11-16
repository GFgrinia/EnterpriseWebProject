<%@ include file="common/header.jsp"%>



<div class="horizontal-block">

    <div class="table-content">
        <div class="horizontal-menu">
            <a href="<c:url value="/requests"/>"><button class="menu">All</a> <br>
            <a href="<c:url value="/requests?status=Awaiting approval"/>"><button class="menu">Awaiting approval</button></a>
            <a href="<c:url value="/requests?status=Awaiting payment"/>"><button class="menu">Awaiting payment</button></a>
            <a href="<c:url value="/requests?status=Active"/>"><button class="menu">Active</button></a>
            <a href="<c:url value="/requests?status=Completed"/>"><button class="menu">Completed</button></a>
            <a href="<c:url value="/requests?status=Overdue"/>"><button class="menu">Overdue</button></a>
            <a href="<c:url value="/requests?status=Rejected"/>"><button class="menu">Rejected</button></a>
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
        <br>

        <c:forEach items="${requests}" var = "request">
            ${request.id} - ${request.user.name} - ${request.car.vendor} - ${request.car.model} - ${request.startDate} - ${request.requestStatus.status}<br>
        </c:forEach>

    </div>



</div>


</div>

<%@ include file="common/footer.jsp"%>







