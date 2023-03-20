<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container mt-3">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <div class="container">
            <h1 class="text-center">My Ads</h1>
            <c:forEach var="ad" items="${ads}">
                <div class="row">
                <div class="card container-fluid border shadow-lg p-2 col-md-6">
                    <div class="card-body">
                    <a href="/edit?id=${ad.id}"><h2>${ad.title}</h2>
                        <p class="card-text">${ad.description}</p>
                    </div>
                </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>