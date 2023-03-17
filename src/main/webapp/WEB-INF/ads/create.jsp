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
            </div>
            <input type="submit" class="btn btn-block btn-primary">
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
