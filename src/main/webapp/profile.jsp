<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.sql.*" %>
<%@ page import="DETsCode.User.UserDAO" %>
<%@ page import="DETsCode.User.User" %>
<%@ page import="DETsCode.Psychologist.Psychologist" %>
<%@ page import="DETsCode.Psychologist.PsychologistDAO" %>
<%
    // Retrieve user from session or mock user for testing
    User user = session.getAttribute("userObj2024");
    if (user == null) {
        user = new User(1, "John", "Doe", "john.doe@example.com", "johndoe", "password123");
    }

    // Redirect to login page if user is not logged in
    if (session.getAttribute("userObj2024") == null) {
        request.setAttribute("message", "You are not authorized to access this resource. Please login.");
%>
<jsp:forward page="login.jsp"/>
<%
    }

    // Initialize therapist variables
    Psychologist assignedPsychologist = null;
    List<Psychologist> availablePsychologists = new ArrayList<>();

    try {
        // Use DAO to fetch therapist data
        UserDAO userDAO = UserDAO.getInstance();
        assignedPsychologist = userDAO.getPsychologistFromUser(user);

        if (assignedPsychologist == null) {
            availablePsychologists = PsychologistDAO.getInstance().getAvailablePsychologists();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="header.jsp" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            color: #333;
            line-height: 1.6;
        }

        h1, h2 {
            color: #2c3e50;
            font-weight: 700;
        }

        .section {
            margin-bottom: 30px;
        }

        .section h2 {
            border-bottom: 2px solid #317133;
            padding-bottom: 5px;
            margin-bottom: 15px;
        }

        .section p {
            margin: 10px 0;
        }

        .section p strong {
            color: #2c6d2e;
        }

        .emergency {
            background-color: #ff6b6b;
            color: white;
            padding: 15px;
            border-radius: 8px;
            text-align: center;
            font-weight: bold;
            margin-top: 40px;
        }

        .emergency span {
            font-size: 18px;
        }
    </style>
</head>
<body>
<%@include file="navbar.jsp" %>

<div class="container" style="padding-top: 200px;">

    <!-- Page Header -->
    <header class="profile-header">
        <h1 class="text-center">Your Profile</h1>
    </header>

    <!-- Basic Info Section -->
    <section class="section mt-4">
        <h2>Basic Info</h2>
        <p><strong>Name:</strong> <%= user.getFirstname() %>
        </p>
        <p><strong>Surname:</strong> <%= user.getLastname() %>
        </p>
        <p><strong>Email:</strong> <%= user.getEmail() %>
        </p>
        <p><strong>Username:</strong> <%= user.getUsername() %>
        </p>
    </section>


        <% if (assignedPsychologist != null) { %>
    <!-- Therapist Section -->
    <section class="therapist-section py-5 bg-light">
        <div class="container text-center">
            <h2 class="mb-4">Your Therapist</h2>
            <!-- Show Assigned Therapist -->
            <div class="card border-0 shadow-sm mx-auto" style="max-width: 400px;">
                <img src="assets/<%= assignedPsychologist.getPhoto() %>"
                     class="card-img-top rounded-circle mx-auto mt-4"
                     alt="<%= assignedPsychologist.getFirstname() %>'s Photo"
                     style="width: 100px; height: 100px; object-fit: cover;">
                <div class="card-body">
                    <h5 class="card-title"><%= assignedPsychologist.getFirstname() %> <%= assignedPsychologist.getLastname() %>
                    </h5>
                    <p class="card-text"><%= assignedPsychologist.getTitle() %>
                    </p>
                    <p class="card-text"><strong>Bio:</strong> <%= assignedPsychologist.getBio() %>
                    </p>
                    <a href="therapistDetails.jsp?id=<%= assignedPsychologist.getPsychologistId() %>"
                       class="btn btn-primary btn-sm">View Profile</a>
                </div>
            </div>
        </div>
    </section>
        <% } else { %>
    <!-- Available Therapists Section -->
    <section class="therapist-section py-5 bg-light">
        <div class="container text-center">
            <h2 class="mb-4">Available Therapists</h2>
            <div class="row g-4">
                <% if (availablePsychologists == null || availablePsychologists.isEmpty()) { %>
                <div class="col-12">
                    <p class="text-muted">No therapists are currently available. Please check back later.</p>
                </div>
                <% } else { %>
                <% for (Psychologist psychologist : availablePsychologists) { %>
                <div class="col-md-4">
                    <div class="card border-0 shadow-sm h-100">
                        <img src="assets/<%= psychologist.getPhoto() %>"
                             class="card-img-top rounded-circle mx-auto mt-4"
                             alt="<%= psychologist.getFirstname() %>'s Photo"
                             style="width: 100px; height: 100px; object-fit: cover;">
                        <div class="card-body">
                            <h5 class="card-title"><%= psychologist.getFirstname() %> <%= psychologist.getLastname() %>
                            </h5>
                            <p class="card-text"><%= psychologist.getTitle() %>
                            </p>
                            <a href="chooseTherapist.jsp?id=<%= psychologist.getPsychologistId() %>"
                               class="btn btn-success btn-sm">Choose Therapist</a>
                        </div>
                    </div>
                </div>
                <% } %>
                <% } %>
            </div>
        </div>
    </section>
        <% } %>

</body>
</html>
