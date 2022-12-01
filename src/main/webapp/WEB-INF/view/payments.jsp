<%@ include file="common/header.jsp"%>

        <div class="col-9">
            <div class="row">
                <div class="text-muted text-left">
                    ${message}
                </div>
            </div>

            <div class="row">
                <div class="mx-auto">
                    <h3>PAYMENT LIST</h3>
                </div>
            </div>




                <div class="row">
                    <%@ include file="common/filterPaymentButtons.jsp"%>
                </div>



            <div class="row">
                <div class="col">
                    <br>
                </div>
            </div>


            <div class="row">
                <%@ include file="common/filterPayment.jsp"%>
            </div>
        </div>


    </div>










</body>
</html>







