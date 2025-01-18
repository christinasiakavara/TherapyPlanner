<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="therplanner.*" %>
<%@ page import="java.util.*, java.sql.*" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <%@include file="header.jsp" %>
  <link rel="stylesheet" href="css/index.css" />

  
</head>

<body>
  
 
  
  <%
  if(session.getAttribute("userObj2024") == null){
    request.setAttribute("message", "You are not authorized to access this resource. Please login.");
    %>
    <jsp:forward page="login.jsp"/>
  <%
  
  }
  User user = (User) session.getAttribute("userObj2024");

    // Initialize therapist variables
    Therapist assignedTherapist = null;
    List<Therapist> availableTherapists = new ArrayList<Therapist>();

    try {
        UserDAO userDAO = new UserDAO();
        assignedTherapist = userDAO.getAssignedTherapist(user.getId());
        
        if (assignedTherapist == null) {
            availableTherapists = userDAO.getAvailableTherapists();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<!-- Header -->

<%@include file="navbar.jsp" %>

<div class="container py-5 mt-5" style="padding-top: 150px !important;">
  <%
  if (assignedTherapist != null) {
  %>
  <h1 class="text-center mb-4">Your personal therapist</h1>
  <div class="card w-75 mb-3 mx-auto border-0">
    <div class="row align-items-center g-0">
      <div class="col-md-4 d-flex justify-content-center">
        <img src="assets/<%= assignedTherapist.getPhoto() %>" class="img-fluid rounded-circle" 
             alt="<%= assignedTherapist.getName() %>'s Photo" 
             style="width: 150px; height: 150px; object-fit: cover;">
             
      </div>
      <div class="col-md-8">
        <div class="card-body">
          <h5 class="card-title mb-2"><%= assignedTherapist.getName() %> <%= assignedTherapist.getLastName() %></h5>
          <p class="card-text mb-1">
            <strong>Specialties:</strong> <%= assignedTherapist.getSpecialties() %><br>
            <strong>Approach:</strong> <%= assignedTherapist.getApproach() %>
          </p>
          <p class="card-text mb-3">
            <strong>Bio:</strong> <%= assignedTherapist.getBio().substring(0, Math.min(assignedTherapist.getBio().length(), 100)) %>...
          </p>
          <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#assignedTherapistModal">
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
  <div class="modal fade" id="assignedTherapistModal" tabindex="-1" aria-labelledby="assignedTherapistModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header border-0">
          <h1 class="modal-title fs-4 mx-auto text-center" id="assignedTherapistModalLabel">
            
          </h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="text-center">
            <img src="assets/<%= assignedTherapist.getPhoto() %>" alt="<%= assignedTherapist.getName() %>'s Photo" 
                 class="rounded-circle mb-3" style="width: 120px; height: 120px; object-fit: cover;">
                 <h2 class="fw-bold mb-1"><%= assignedTherapist.getName() %> <%= assignedTherapist.getLastName() %></h2>
                 <small><i class="bi bi-arrow-repeat">change therapist</i></small>
            <p class="text-muted mb-1"><%= assignedTherapist.getTitle() %></p>
            <button class="btn btn-light border mb-3"><%= assignedTherapist.getApproach() %></button>
          </div>
          <h4 class="fw-bold mt-4">Short Bio</h4>
          <p class="text-muted"><%= assignedTherapist.getBio() %></p>
          <ul class="list-inline">
            <% String[] specialties = assignedTherapist.getSpecialties().split(","); 
               for (String specialty : specialties) { 
            %>
              <li class="list-inline-item">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" class="me-2">
                  <path fill="#2db5b2" d="M19.3 0 8.5 10.8 4.1 6.4 0 10.5 8.5 19l15-15Z"></path>
                </svg>
                <span><%= specialty.trim() %></span>
              </li>
            <% } %>
          </ul>
          <h4 class="fw-bold mt-4">Degree</h4>
          <p class="text-muted"><%= assignedTherapist.getEducation() %></p>
          <h4 class="fw-bold mt-4">Training</h4>
          <p class="text-muted"><%= assignedTherapist.getTraining() %></p>
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
    <!-- Display Available Therapists -->
    <h1 class="text-center mb-4">Available Therapists (<%= availableTherapists.size() %>)</h1>
    <p class="text-center mb-5 text-muted">Select the therapist who best fits your needs.</p>
    <div class="row justify-content-center">
      <%
      if (availableTherapists.isEmpty()) {
      %>
        <div class="col-12 text-center">
          <p class="text-muted">No therapists are currently available. Please check back later.</p>
        </div>
      <%
      } else {
        int index = 0; // Unique index for modals
        for (Therapist therapist : availableTherapists) {
          index++;
      %>
        <div class="card w-75 mb-3 mx-auto border-0">
          <div class="row align-items-center g-0">
            <div class="col-md-4 d-flex justify-content-center">
              <img src="assets/<%= therapist.getPhoto() %>" class="img-fluid rounded-circle" 
                   alt="<%= therapist.getName() %>'s Photo" 
                   style="width: 150px; height: 150px; object-fit: cover;">
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title mb-2"><%= therapist.getName() %> <%= therapist.getLastName() %></h5>
                <p class="card-text mb-1">
                  <strong>Specialties:</strong> <%= therapist.getSpecialties() %><br>
                  <strong>Approach:</strong> <%= therapist.getApproach() %>
                </p>
                <p class="card-text mb-3">
                  <strong>Bio:</strong> <%= therapist.getBio().substring(0, Math.min(therapist.getBio().length(), 100)) %>...
                </p>
                <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#therapistModal<%= index %>">
                  View Details
                </button>
              </div>
            </div>
          </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="therapistModal<%= index %>" tabindex="-1" aria-labelledby="therapistModalLabel<%= index %>" aria-hidden="true">
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
              <div class="modal-header border-0">
                <h1 class="modal-title fs-4 mx-auto text-center" id="therapistModalLabel<%= index %>">
                  <%= therapist.getName() %> <%= therapist.getLastName() %>
                </h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <div class="text-center">
                  <img src="assets/<%= therapist.getPhoto() %>" alt="<%= therapist.getName() %>'s Photo" 
                       class="rounded-circle mb-3" style="width: 120px; height: 120px; object-fit: cover;">
                  <h2 class="fw-bold mb-1"><%= therapist.getName() %> <%= therapist.getLastName() %></h2>
                  <p class="text-muted mb-1"><%= therapist.getTitle() %></p>
                  <button class="btn btn-light border mb-3"><%= therapist.getApproach() %></button>
                </div>
                <h4 class="fw-bold mt-4">Short Bio</h4>
                <p class="text-muted"><%= therapist.getBio() %></p>
                <ul class="list-inline">
                  <% String[] specialties = therapist.getSpecialties().split(","); 
                     for (String specialty : specialties) { 
                  %>
                    <li class="list-inline-item">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" class="me-2">
                        <path fill="#2db5b2" d="M19.3 0 8.5 10.8 4.1 6.4 0 10.5 8.5 19l15-15Z"></path>
                      </svg>
                      <span><%= specialty.trim() %></span>
                    </li>
                  <% } %>
                </ul>
                <h4 class="fw-bold mt-4">Degree</h4>
                <p class="text-muted"><%= therapist.getEducation() %></p>
                <h4 class="fw-bold mt-4">Training</h4>
                <p class="text-muted"><%= therapist.getTraining() %></p>
              </div>
              <div class="modal-footer border-0">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <form action="assignTherapist.jsp" method="POST">
                  <input type="hidden" name="therapistId" value="<%= therapist.getId() %>">
                  <button type="submit" class="btn btn-success">Choose Therapist</button>
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
