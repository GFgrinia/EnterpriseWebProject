<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <body>

    <form action="/registration" method="post">
        <div>
            <label>Username</label>
            <input type="text" name="username" placeholder="Enter username">
        </div>
        <div>
            <label>Passport</label>
            <input type="text" name="passport" placeholder="Enter passport#">
        </div>
        <div>
            <label>E-mail</label>
            <input type="number" name="email" placeholder="Enter email">
        </div>

        <div>
            <label>Password</label>
            <input type="number" name="password" placeholder="Enter password">
        </div>
        <div>
            <label>Confirm Password</label>
            <input type="number" name="confirm" placeholder="Confirm password">
        </div>
        <button>Submit</button>
    </form>


    </body>
</html>