<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="/register" method="post" class="needs-validation">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" required>
                <div class="invalid-feedback">
                    Please enter a valid username.
                </div>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" required>
                <div class="invalid-feedback">
                    Please enter a valid email.
                </div>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control is-invalid" type="password" required>
                <div class="invalid-feedback">
                    Please enter a valid password.
                </div>
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password" required>
                <div class="invalid-feedback">
                    Please enter a matching valid password.
                </div>
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
<script>
    (function () {
        'use strict'

        var forms = document.querySelectorAll('.needs-validation')

        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
</body>
</html>
