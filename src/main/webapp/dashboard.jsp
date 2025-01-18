<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.sql.*" %>
<%@ page import="DETsCode.User.User" %>
<%@ page import="DETsCode.User.UserDAO" %>
<%@ page import="DETsCode.Psychologist.Psychologist" %>
<%@ page import="DETsCode.Psychologist.PsychologistDAO" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <%@include file="header.jsp" %>
    <link rel="stylesheet" href="css/index.css"/>


</head>

<body>


<%
    if (session.getAttribute("userObj2024") == null) {
        request.setAttribute("message", "You are not authorized to access this resource. Please login.");
%>
<jsp:forward page="login.jsp"/>
<%

    }
    User user = (User) session.getAttribute("userObj2024");

    // Initialize Psychologist variables
    Psychologist assignedPsychologist = null;
    List<Psychologist> availablePsychologists = new ArrayList<>();

    try {
        UserDAO userDAO = UserDAO.getInstance();
        assignedPsychologist = userDAO.getPsychologistFromUser(user);
        if (assignedPsychologist == null) {
            availablePsychologists = PsychologistDAO.getInstance().getAvailablePsychologists();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<!-- Header -->

<%@include file="navbar.jsp" %>

<div class="container py-5 mt-5" style="padding-top: 150px !important;">
    <%
        if (assignedPsychologist != null) {
    %>
    <h1 class="text-center mb-4">Your personal Psychologist</h1>
    <div class="card w-75 mb-3 mx-auto border-0">
        <div class="row align-items-center g-0">
            <div class="col-md-4 d-flex justify-content-center">
                <img src="assets/<%= assignedPsychologist.getPhoto() %>" class="img-fluid rounded-circle"
                     alt="<%= assignedPsychologist.getFirstname() %>'s Photo"
                     style="width: 150px; height: 150px; object-fit: cover;">

            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title mb-2"><%= assignedPsychologist.getFirstname() %> <%= assignedPsychologist.getLastname() %>
                    </h5>
                    <p class="card-text mb-1">
                        <strong>Specialties:</strong> <%= assignedPsychologist.getSpecialties() %><br>
                        <strong>Approach:</strong> <%= assignedPsychologist.getApproach() %>
                    </p>
                    <p class="card-text mb-3">
                        <strong>Bio:</strong> <%= assignedPsychologist.getBio().substring(0, Math.min(assignedPsychologist.getBio().length(), 100)) %>
                        ...
                    </p>
                    <button type="button" class="btn btn-success" data-bs-toggle="modal"
                            data-bs-target="#assignedPsychologistModal">
                        View Details
                    </button>
                </div>
            </div>
        </div>
    </div>

    <!-- Session Details Section -->
    <!-- Session Details Section -->
    <div class="card w-75 mb-3 mx-auto border-0">
        <div class="card-body">
            <h4 class="card-title mb-3">Session Details</h4>
            <p class="card-text">
                <strong>Completed Sessions:</strong> <%= request.getAttribute("completedSessions") %><br>
                <strong>Pending Sessions:</strong> <%= request.getAttribute("pendingSessions") %><br>
                <strong>Total Sessions:</strong> <%= request.getAttribute("totalSessions") %>
            </p>
        </div>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="assignedPsychologistModal" tabindex="-1"
         aria-labelledby="assignedPsychologistModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header border-0">
                    <h1 class="modal-title fs-4 mx-auto text-center" id="assignedPsychologistModalLabel">

                    </h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="text-center">
                        <img src="assets/<%= assignedPsychologist.getPhoto() %>"
                             alt="<%= assignedPsychologist.getFirstname() %>'s Photo"
                             class="rounded-circle mb-3" style="width: 120px; height: 120px; object-fit: cover;">
                        <h2 class="fw-bold mb-1"><%= assignedPsychologist.getFirstname() %> <%= assignedPsychologist.getLastname() %>
                        </h2>
                        <small><i class="bi bi-arrow-repeat">change Psychologist</i></small>
                        <p class="text-muted mb-1"><%= assignedPsychologist.getTitle() %>
                        </p>
                        <button class="btn btn-light border mb-3"><%= assignedPsychologist.getApproach() %>
                        </button>
                    </div>
                    <h4 class="fw-bold mt-4">Short Bio</h4>
                    <p class="text-muted"><%= assignedPsychologist.getBio() %>
                    </p>
                    <ul class="list-inline">
                        <% String[] specialties = assignedPsychologist.getSpecialties().split(",");
                            for (String specialty : specialties) {
                        %>
                        <li class="list-inline-item">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 class="me-2">
                                <path fill="#2db5b2" d="M19.3 0 8.5 10.8 4.1 6.4 0 10.5 8.5 19l15-15Z"></path>
                            </svg>
                            <span><%= specialty.trim() %></span>
                        </li>
                        <% } %>
                    </ul>
                    <h4 class="fw-bold mt-4">Degree</h4>
                    <p class="text-muted"><%= assignedPsychologist.getEducation() %>
                    </p>
                    <h4 class="fw-bold mt-4">Training</h4>
                    <p class="text-muted"><%= assignedPsychologist.getTraining() %>
                    </p>
                </div>
                <div class="modal-footer border-0">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>


    <%
    } else {
    %>
    <!-- Display Available Psychologists -->
    <h1 class="text-center mb-4">Available Psychologists (<%= availablePsychologists.size() %>)</h1>
    <p class="text-center mb-5 text-muted">Select the Psychologist who best fits your needs.</p>
    <div class="row justify-content-center">
        <%
            if (availablePsychologists.isEmpty()) {
        %>
        <div class="col-12 text-center">
            <p class="text-muted">No Psychologists are currently available. Please check back later.</p>
        </div>
        <%
        } else {
            int index = 0; // Unique index for modals
            for (Psychologist Psychologist : availablePsychologists) {
                index++;
        %>
        <div class="card w-75 mb-3 mx-auto border-0">
            <div class="row align-items-center g-0">
                <div class="col-md-4 d-flex justify-content-center">
                    <img src="assets/<%= Psychologist.getPhoto() %>" class="img-fluid rounded-circle"
                         alt="<%= Psychologist.getFirstname() %>'s Photo"
                         style="width: 150px; height: 150px; object-fit: cover;">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title mb-2"><%= Psychologist.getFirstname() %> <%= Psychologist.getLastname() %>
                        </h5>
                        <p class="card-text mb-1">
                            <strong>Specialties:</strong> <%= Psychologist.getSpecialties() %><br>
                            <strong>Approach:</strong> <%= Psychologist.getApproach() %>
                        </p>
                        <p class="card-text mb-3">
                            <strong>Bio:</strong> <%= Psychologist.getBio().substring(0, Math.min(Psychologist.getBio().length(), 100)) %>
                            ...
                        </p>
                        <button type="button" class="btn btn-success" data-bs-toggle="modal"
                                data-bs-target="#PsychologistModal<%= index %>">
                            View Details
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="PsychologistModal<%= index %>" tabindex="-1"
             aria-labelledby="PsychologistModalLabel<%= index %>" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header border-0">
                        <h1 class="modal-title fs-4 mx-auto text-center" id="PsychologistModalLabel<%= index %>">
                            <%= Psychologist.getFirstname() %> <%= Psychologist.getLastname() %>
                        </h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="text-center">
                            <img src="assets/<%= Psychologist.getPhoto() %>"
                                 alt="<%= Psychologist.getFirstname() %>'s Photo"
                                 class="rounded-circle mb-3" style="width: 120px; height: 120px; object-fit: cover;">
                            <h2 class="fw-bold mb-1"><%= Psychologist.getFirstname() %> <%= Psychologist.getLastname() %>
                            </h2>
                            <p class="text-muted mb-1"><%= Psychologist.getTitle() %>
                            </p>
                            <button class="btn btn-light border mb-3"><%= Psychologist.getApproach() %>
                            </button>
                        </div>
                        <h4 class="fw-bold mt-4">Short Bio</h4>
                        <p class="text-muted"><%= Psychologist.getBio() %>
                        </p>
                        <ul class="list-inline">
                            <% String[] specialties = Psychologist.getSpecialties().split(",");
                                for (String specialty : specialties) {
                            %>
                            <li class="list-inline-item">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                     class="me-2">
                                    <path fill="#2db5b2" d="M19.3 0 8.5 10.8 4.1 6.4 0 10.5 8.5 19l15-15Z"></path>
                                </svg>
                                <span><%= specialty.trim() %></span>
                            </li>
                            <% } %>
                        </ul>
                        <h4 class="fw-bold mt-4">Degree</h4>
                        <p class="text-muted"><%= Psychologist.getEducation() %>
                        </p>
                        <h4 class="fw-bold mt-4">Training</h4>
                        <p class="text-muted"><%= Psychologist.getTraining() %>
                        </p>
                    </div>
                    <div class="modal-footer border-0">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <form action="assignPsychologist.jsp" method="POST">
                            <input type="hidden" name="PsychologistId" value="<%= Psychologist.getPsychologistId() %>">
                            <button type="submit" class="btn btn-success">Choose Psychologist</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
    <%
        }
    %>
</div>


<%@include file="footer.jsp" %>

</body>
</html>
