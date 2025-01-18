<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<header id="main-header" class="header">
    <div class="container">
        <!-- Logo -->
        <%
            if (session.getAttribute("userObj2024") == null) {
        %>
        <a href="index.jsp" class="logo"><b>THERAPY</b> Planner</a>

        <!-- Navigation Menu -->
        <nav class="navbar">
            <li><a href="about.jsp">About Us</a></li>
            <li><a href="contact.jsp">contact</a></li>
            <li><a href="prices.jsp">Prices</a></li>


            <!-- Search Bar -->
            <div class="extended-input-wrapper">
                <i class="fa fa-search"></i>
                <input id="global-search" class="extended-input" type="text" placeholder="Search..."/>
            </div>
            <!-- Authentication Links (Aligned to the right) -->

            <div class="auth-links">
                <a href="login.jsp">Log In</a>
                <a href="register.jsp">Register</a>
            </div>
                <%} else{%>
            <a href="dashboard.jsp" class="logo"><b>THERAPY</b> Planner</a>

            <!-- Navigation Menu -->
            <nav class="navbar">
                <li><a href="about.jsp">About Us</a></li>
                <li><a href="contact.jsp">contact</a></li>
                <li><a href="prices.jsp">Prices</a></li>


                <!-- Search Bar -->
                <div class="extended-input-wrapper">
                    <i class="fa fa-search"></i>
                    <input id="global-search" class="extended-input" type="text" placeholder="Search..."/>
                </div>
                <!-- Authentication Links (Aligned to the right) -->

                <!-- User Welcome & Profile -->
                <p class="mb-0 fw-bold text-dark">WELCOME,  <%= user.getFirstname() %> <%= user.getLastname() %>
                </p>

                <div class="dropdown">
                    <!-- Profile Trigger -->
                    <div class="rounded-circle bg-secondary d-flex justify-content-center align-items-center "
                         style="width: 40px; height: 40px; cursor: pointer;"
                         id="profileDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="bi bi-person-fill text-white fs-5"></i>
                    </div>

                    <!-- Dropdown Menu -->
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="profileDropdown">
                        <li><a class="dropdown-item" href="profile.jsp">Profile</a></li>
                        <li><a class="dropdown-item" href="settings.jsp">Settings</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="index.jsp">Logout</a></li>
                    </ul>
                </div>

                <%}%>
            </nav>
    </div>
</header>