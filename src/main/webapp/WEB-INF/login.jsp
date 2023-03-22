<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container ">
        <h1 class="pt-4">Please Log In</h1>
        <form action="/login" method="POST" class="needs-validation" novalidate>
            <div class="form-group has-validation">
                <label for="username" class="form-label">Username</label>
                <input id="username" name="username" class="form-control is-invalid" type="text" required>
                <div id="usernameValid" class="valid-feedback ">
                    Looks good!
                </div>
                <div id="usernameInvalid" class="invalid-feedback ">
                    Please enter a valid username.
                </div>
            </div>
            <div class="form-group has-validation">
                <label for="password" class="form-label">Password</label>
                <input id="password" name="password" class="form-control is-invalid" type="password" required>
                <div id="passwordValid" class="valid-feedback ">
                    Looks good!
                </div>
                <div id="passwordInvalid" class="invalid-feedback ">
                    Please enter a valid password.
                </div>
            </div>
            <div class="d-grid gap-2 mt-3">
                <input id="submitbtn" type="submit" class="btn btn-primary btn-block" value="Log In">
            </div>
        </form>
        <div class="d-grid gap-2">
            <a href="/register" class="d-grid gap-2 text-decoration-none">
                <input type="submit" class="btn btn-warning btn-block text-white" value="Don't Have An Account?">
            </a>
        </div>
    </div>

    <jsp:include page="/WEB-INF/partials/bootstrap_script.jsp"></jsp:include>
    <script><jsp:include page="/WEB-INF/js/user_validation.js"></jsp:include></script>

</body>
</html>
