<a href="<c:url value="/cars"/>">
    <button class="collapsible"><span>Show Cars</span></button>
</a>
<br>


    <a href="<c:url value="/requests"/>">
        <button class="collapsible"><span>Requests</span></button>
    </a>
    <br>

    <a href="<c:url value="/payments"/>">
        <button class="collapsible"><span>Payment Info</span></button>
    </a>
    <br>



<c:if test="${user.roleName == userAsAdmin}">
    <a href="<c:url value="/users"/>">
        <button class="collapsible"><span>Users</span></button>
    </a>
    <br>
</c:if>


<c:if test="${user.roleName == userAsUser}">
    <a href="<c:url value="/users/${user.id}"/>">
        <button class="collapsible"><span>My Account</span></button>
    </a>
</c:if>