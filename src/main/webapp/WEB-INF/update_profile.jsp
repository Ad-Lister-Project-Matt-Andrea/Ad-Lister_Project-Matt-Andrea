<%--
  Created by IntelliJ IDEA.
  User: andreavarnado
  Date: 3/20/23
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container mt-3">
        <h1>Edit Profile</h1>
        <form action="/profile/edit" method="post" class="needs-validation">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control is-invalid" type="text" value="${user.username}" required>
                <div id="usernameValid" class="valid-feedback ">
                    Looks good!
                </div>
                <div class="invalid-feedback">
                    Please enter a valid username.
                </div>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control is-invalid" type="text" value="${user.email}" required>
                <div id="emailValid" class="valid-feedback ">
                    Looks good!
                </div>
                <div class="invalid-feedback">
                    Please enter a valid email.
                </div>
            </div>
            <div class="d-grid gap-2 mt-3">
                <input type="submit" class="btn btn-primary btn-block" value="Save">
            </div>
        </form>
    </div>

    <jsp:include page="/WEB-INF/partials/bootstrap_script.jsp"></jsp:include>
    <script><jsp:include page="/WEB-INF/js/update_profile_validation.js"></jsp:include></script>


</body>
</html>
