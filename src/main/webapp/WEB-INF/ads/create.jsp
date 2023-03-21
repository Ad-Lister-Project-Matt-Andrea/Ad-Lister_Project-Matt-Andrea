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
        <form action="/ads/create" method="post" class="requires-validation" >
            <div class="form-group">
                <label for="title" class="form-label">Title</label>
                <input id="title" name="title" class="form-control is-invalid" type="text" required>
                <div id="titleValid" class="valid-feedback ">
                    Looks good!
                </div>
                <div class="invalid-feedback">
                    Please enter a title.
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="form-label">Description</label>
                <textarea id="description" name="description" class="form-control is-invalid" type="text" required></textarea>
                <div id="descriptionValid" class="valid-feedback ">
                    Looks good!
                </div>
                <div class="invalid-feedback">
                    Please enter a description.
                </div>
            </div>
            <div class="form-group">
                <label for="price" class="form-label">Price</label>
                <span>$</span><input id="price" name="price" class="form-control is-invalid" type="text" required>
                <div id="priceValid" class="valid-feedback ">
                    Looks good!
                </div>
                <div class="invalid-feedback">
                    Please enter a price.
                </div>
            </div>
            <div class="form-group">
                <label for="location" class="form-label">General Location</label>
                <input id="location" name="location" class="form-control is-invalid" type="text" required>
                <div id="locationValid" class="valid-feedback ">
                    Looks good!
                </div>
                <div class="invalid-feedback">
                    Please enter a general location.
                </div>
            </div>
            <div class="form-group">
                <label for="category" class="form-label">Category</label>
                <select id="category" name="category" class="form-select is-invalid" aria-label="Default select example">
                    <option disabled selected value="">Choose a category</option>
                    <option value="free">Free</option>
                    <option value="helpWanted">Help Wanted</option>
                    <option value="services">Services</option>
                    <option value="furniture">Furniture</option>
                    <option value="electronics">Services</option>
                    <option value="wallDecor">Wall Decor</option>
                    <option value="collectables">Collectables</option>
                    <option value="pets">Pets</option>
                    <option value="clothes">Clothes</option>
                </select>
                <div id="categoryValid" class="valid-feedback ">
                    Looks good!
                </div>
                <div class="invalid-feedback">
                    Please select a category.
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
