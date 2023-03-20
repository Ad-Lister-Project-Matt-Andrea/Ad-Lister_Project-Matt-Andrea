<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post" class="needs-validation" >
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text" required>
                <div class="invalid-feedback">
                    Please enter a title.
                </div>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text" required></textarea>
                <div class="invalid-feedback">
                    Please enter a description.
                </div>
                <label for="price">Price</label>
                <span>$</span><input id="price" name="price" class="form-control" type="text" required>
                <div class="invalid-feedback">
                    Please enter a price.
                </div>
                <label for="location">General Location</label>
                <input id="location" name="location" class="form-control" type="text" required>
                <div class="invalid-feedback">
                    Please enter general location.
                </div>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>

<script><jsp:include page="/WEB-INF/partials/bootstrap_script.jsp"></jsp:include></script>

<script><jsp:include page="/WEB-INF/js/user_validation.js"></jsp:include></script>

</body>
</html>
