<%@ page import="DETsCode.User.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Metadata -->
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!-- Custom Styles -->
    <link rel="stylesheet" href="css/index.css"/>

    <!-- Bootstrap CSS & JS -->
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"
    />
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />

    <!-- Fontawesome CDN -->
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
            integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
    />
</head>

<body>

<!-- Fixed navbar -->
<header>
    <div class="container">
        <!-- Logo -->
        <a href="index.jsp" class="logo"><b>THERAPY</b> Planner</a>

        <!-- Navigation Menu -->
        <nav class="navbar">
            <li><a href="about.jsp">About Us</a></li>
            <li><a href="therapists.jsp">Therapists</a></li>
            <li><a href="prices.jsp">Prices</a></li>
            <li><a href="prices.jsp">Prices</a></li>
            <li><a href="prices.jsp">Prices</a></li>
            <li><a href="prices.jsp">Prices</a></li>


            <!-- Search Bar -->
            <div class="extended-input-wrapper">
                <i class="fa fa-search"></i>
                <input id="global-search" class="extended-input" type="text" placeholder="Search..."/>
            </div>
            <!-- Authentication Links (Aligned to the right) -->
            <%
                User user = (User) session.getAttribute("userObj2024");
                if (session.getAttribute("userObj2024") == null) {
            %>
            <div class="auth-links">
                <a href="login.jsp">Log In</a>
                <a href="register.jsp">Register</a>
            </div>
            <%} else {%>

            <div class="auth-links">
                <p>Welcome, <%= user.getFirstname() %>
                </p>
                <div id="profile-icon">
                    <% String firstInitial = user.getFirstname().charAt(0) + ""; %>          </a>
                    <a href="usersettings.jsp">
                            <%=firstInitial%>
                        <div class="user-menu">
                            <ul>
                                <li><a href="#profile">Profile Settings</a></li>
                                <li><a href="#logout">Logout</a></li>
                            </ul>
                        </div>
                </div>
            </div>
            <%}%>

        </nav>
    </div>
</header>

<div class="container theme-showcase" role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <h1>2η Ατομική Άσκηση</h1>
    </div>

    <!-- Page Title -->
    <div class="page-header">
        <h1>Oops something went wrong</h1>
    </div>

    <div class="row">

        <div class="col-xs-12">

            <h2>Description</h2>


            <% if (exception != null) { %>
            <p><code><%=exception %>
            </code></p>
            <% } %>

        </div>

    </div>

</div>
<!-- /container -->

<!-- footer -->
<footer class="navbar-inverse">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <p class="text-center">&copy; Copyright 2024 by ismgroupY</p>
            </div>
        </div>
    </div>
</footer>
<!-- End footer -->

<!-- =================== Place all javascript at the end of the document so the pages load faster =================== -->
<!-- jQuery library -->
<script src="js/jquery.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>


