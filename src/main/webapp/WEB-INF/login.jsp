<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Please Log In</h1>
        <form action="/login" method="POST" class="needs-validation">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" required>
                <div class="invalid-feedback">
                    Please enter a valid username.
                </div>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password" required>
                <div class="invalid-feedback">
                    Please enter a valid password.
                </div>
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
        <a href="/register"><input type="submit" class="btn btn-warning btn-block" value="Don't Have An Account?"></a>
    </div>

    <script><jsp:include page="/WEB-INF/js/user_validation.js"></jsp:include></script>

</body>
</html>
