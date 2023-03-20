<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Edit Ad</h1>
    <form method="post" action="/edit">
        <input type="hidden" name="id" value="${ad.id}">
        <label>Title:</label>
        <input type="text" name="title" class="form-control" value="${ad.title}">
        <br>
        <label>Description:</label>
        <input type="text" name="description" class="form-control" rows="3" value="${ad.description}">
        <br>
        <label>Price:</label>
        <input type="text" name="price" class="form-control" value="${ad.price}">
        <br>    <label>Location:</label>
        <input type="text" name="location" class="form-control" value="${ad.location}">
        <br>
        <button type="submit" class="btn btn-primary">Save Changes</button>
    </form>
    <form method="post" action="/delete">
        <input type="hidden" name="id" value="${ad.id}">
        <button type="submit" class="btn btn-danger">Delete listing</button>
    </form>

</div>
</body>
</html>
