<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/profile_navbar.jsp" />

    <div class="container-fluid mt-3 row">

        <div class="container mt-4 col">
            <div class="card ">
                <h1 class="text-center">Welcome, ${sessionScope.user.username}!</h1>
                <img src="/WEB-INF/img/profile_pic1.png" class="img-thumbnail" width="200" height="200">
                <div class="card-body" width="200" height="200">
                    <p class="card-text"><b>Username: </b>${sessionScope.user.username}</p>
                    <p class="card-text"><b>Email: </b>${sessionScope.user.email}</p>
                </div>
            </div>
        </div>

        <div class="container w-100 p-2 col">
            <h1 class="text-center">My Ads</h1>
            <c:forEach var="ad" items="${ads}">
                <div class="row">
                    <div class="card container-fluid border rounded shadow-lg p-2">
                        <div class="card-body">
                            <a href="/edit?id=${ad.id}" class="text-decoration-none"><h2>${ad.title}</h2></a>
                            <p class="card-text">${ad.description}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

<%--        <div class="container flex-shrink-1 mt-5 me-2">--%>

<%--        </div>--%>

    </div>
</body>
</html>