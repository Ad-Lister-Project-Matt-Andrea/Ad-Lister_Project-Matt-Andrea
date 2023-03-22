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

        <div class="container mt-2 col">
            <h1 class="text-center">Welcome, ${sessionScope.user.username}!</h1>
            <div class="card border rounded shadow-lg d-flex flex-row align-items-center justify-content-evenly ">
                <img src="https://picsum.photos/200" class="img-thumbnail p-3 m-3" width="200" height="200">
                <div class="flex-column align-items-start">
                    <p class="card-text">${sessionScope.user.username}</p>
                    <p class="card-text">${sessionScope.user.email}</p>
                    <p class="card-text">Joined March 2023</p>
                    <p class="card-text">San Antonio, TX</p>

                </div>
            </div>

            <div class="mt-3 p-4 card border rounded shadow-lg d-flex flex-row justify-content-evenly align-items-center" width="200" height="200">
                <div class="flex-column ">
                    <p class="card-text"><b>100%</b> Positive Feedback</p>
                </div>
                <div class="flex-column ">
                    <p class="card-text"><b>1.4K</b> Items Sold</p>
                </div>
                <div class="flex-column ">
                    <p class="card-text"><b>162</b> Followers</p>
                </div>
            </div>

            <div class="mt-3 p-4 card border rounded shadow-lg d-flex flex-row justify-content-evenly align-items-center" width="200" height="200">
                <div class="flex-column ">
                    <a href="https://facebook.com"><i class="fa-brands fa-facebook fa-lg"></i></a>
                </div>
                <div class="flex-column ">
                    <a href="https://messenger.com"><i class="fa-brands fa-facebook-messenger fa-lg"></i></a>
                </div>
                <div class="flex-column ">
                    <a href="https://instagram.com"><i class="fa-brands fa-instagram fa-lg"></i></a>
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