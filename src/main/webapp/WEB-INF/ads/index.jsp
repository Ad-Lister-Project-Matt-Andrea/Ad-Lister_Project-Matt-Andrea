<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1 class="pt-4">Here Are all the ads!</h1>
    <form action="/ads" method="post">
        <div class="form-group">
            <label for="searchQuery">Search</label>
            <input id="searchQuery" name="searchQuery" class="form-control" type="text">
        </div>
    </form>
    <c:forEach var="ad" items="${ads}">
        <div class="card container-fluid border shadow-lg p-2">
            <div class="card-body">
                <h2 class="card-title">${ad.title}</h2>
                <p class="card-text">${ad.description}</p>
                <a href="/details" class="btn btn-primary">View Ad</a>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
