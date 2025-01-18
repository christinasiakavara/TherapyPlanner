<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="errorController.jsp" %>
<%@ page import="DETsCode.*" %>
<%@ page import="java.util.*, java.sql.*" %>
<%@ page import="DETsCode.User.UserDAO" %>
<%@ page import="DETsCode.Psychologist.Psychologist" %>
<%@ page import="DETsCode.Psychologist.PsychologistDAO" %>

<!DOCTYPE html>
<html lang="en-US">
<head>
    <title>THERAPYPlanner - Home</title>

    <%@include file="header.jsp" %>

</head>

<body>

<%
    // Fetch available psychologists using UserDAO
    PsychologistDAO psychologistDao = PsychologistDAO.getInstance();
    List<Psychologist> availablePsychologists = null;
    try {
        availablePsychologists = psychologistDao.getAvailablePsychologists();
    } catch (Exception e) {
        e.printStackTrace();
        availablePsychologists = new ArrayList<>();
    }
%>

<!-- Header -->
<header id="main-header" class="header">
    <div class="container">
        <!-- Logo -->
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

</header>


<!-- Hero Section -->
<div class="hero">
    <div class="content">
        <a href="login.jsp" class="btn">Get Started</a>
    </div>
</div>

<!-- About Us Section -->
<section class="about-us py-5" style="background-color: #ccd3cd;">
    <div class="container text-center">
        <h2>About Us</h2>
        <p class="mt-3">
            <b>Therapy Planner connects users with experienced psychologists to improve their well-being. Our mission is
                to
                make therapy accessible and convenient for everyone.</b>
        </p>
    </div>
</section>

<!-- How It Works Section -->
<section class="how-it-works py-5 bg-light">
    <div class="container text-center">
        <h2>How It Works</h2>
        <div class="row mt-5">
            <div class="col-md-4">
        <span class="d-inline-block bg-primary text-white p-4 rounded-circle mb-3">
          <i class="fa fa-user-circle fa-3x"></i>
        </span>
                <h4>1. Sign Up</h4>
                <p><b>Create your free account in a few easy steps.</b></p>
            </div>
            <div class="col-md-4">
        <span class="d-inline-block bg-success text-white p-4 rounded-circle mb-3">
          <i class="fa fa-calendar-alt fa-3x"></i>
        </span>
                <h4>2. Book a Session</h4>
                <p><b>Choose a psychologist and schedule your session.</b></p>
            </div>
            <div class="col-md-4">
        <span class="d-inline-block bg-danger text-white p-4 rounded-circle mb-3">
          <i class="fa fa-video fa-3x"></i>
        </span>
                <h4>3. Start Therapy</h4>
                <p><b>Join your therapy session online from anywhere.</b></p>
            </div>
        </div>
    </div>
</section>

<!-- Testimonials Section -->
<section class="testimonials py-5" style="background-color: #ccd3cd;">
    <div class="container text-center">
        <h2>What Our Users Say</h2>
        <div class="row mt-5">
            <div class="col-md-4">
                <p>"The platform is easy to use and has helped me connect with amazing psychologists."</p>
                <h5>- John Doe</h5>
            </div>
            <div class="col-md-4">
                <p>"I love the flexibility of booking sessions online!"</p>
                <h5>- Jane Smith</h5>
            </div>
            <div class="col-md-4">
                <p>"Therapy Planner has made therapy more accessible to me."</p>
                <h5> Michael Brown</h5>
            </div>
        </div>
    </div>
</section>

<!-- Choose Your psychologist Section -->
<section class="choose-psychologist py-5 bg-light">
    <div class="container text-center">
        <h2 class="mb-4">Choose Your psychologist</h2>
        <div class="row g-4">
            <%
                if (availablePsychologists == null || availablePsychologists.isEmpty()) {
            %>
            <div class="col-12">
                <p class="text-muted">No psychologists are currently available. Please check back later.</p>
            </div>
            <%
            } else {
                for (Psychologist psychologist : availablePsychologists) {
            %>
            <div class="col-md-4">
                <div class="card border-0 shadow-sm h-100">
                    <img src="assets/<%= psychologist.getPhoto() %>" class="card-img-top rounded-circle mx-auto mt-4"
                         alt="<%= psychologist.getFirstname() %>'s Photo" style="width: 100px; height: 100px;">
                    <div class="card-body">
                        <h5 class="card-title"><%= psychologist.getFirstname() %> <%= psychologist.getLastname() %>
                        </h5>
                        <p class="card-text"><%= psychologist.getTitle() %>
                        </p>
                        <a href="login.jsp?redirect=psychologistDetails&id=<%= psychologist.getPsychologistId() %>"
                           class="btn btn-success btn-sm">View Profile</a>
                    </div>
                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
</section>


<!-- Call to Action Section -->
<section class="cta-section text-center py-5 bg-light">
    <div class="container">
        <h2>Ready to Get Started?</h2>
        <p class="mt-3">Sign up today and take the first step towards better mental health.</p>
        <a href="register.jsp" class="btn btn-dark mt-4">Join Now</a>
    </div>
</section>


<!--footer-->
<%@include file="footer.jsp" %>


</body>
</html>
