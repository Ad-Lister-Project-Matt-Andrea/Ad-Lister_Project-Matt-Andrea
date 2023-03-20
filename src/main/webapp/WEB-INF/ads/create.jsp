<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container mt-3">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post" class="needs-validation" >
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control is-invalid" type="text" required>
                <div id="titleValid" class="valid-feedback ">
                    Looks good!
                </div>
                <div class="invalid-feedback">
                    Please enter a title.
                </div>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control is-invalid" type="text" required></textarea>
                <div id="descriptionValid" class="valid-feedback ">
                    Looks good!
                </div>
                <div class="invalid-feedback">
                    Please enter a description.
                </div>
            </div>
            <div class="d-grid gap-2 mt-3">
                <input type="submit" class="btn btn-block btn-primary">
            </div>
        </form>
    </div>

<script><jsp:include page="/WEB-INF/partials/bootstrap_script.jsp"></jsp:include></script>

<script><jsp:include page="/WEB-INF/js/new_ad_validation.js"></jsp:include></script>

</body>
</html>
