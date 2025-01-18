<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.sql.*" %>
<%@ page import="DETsCode.User.User" %>

<%
    User user = (User) session.getAttribute("userObj2024");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="header.jsp" %>
    <style>
        .booking-section {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #f9f9f9;
        }

        .booking-form {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            width: 100%;
        }

        .booking-form h2 {
            text-align: center;
            margin-bottom: 20px;
            font-size: 2rem;
            font-weight: bold;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .btn-primary {
            background-color: #095d44;
            border-color: #095d44;
            color: white;
            padding: 10px 15px;
            border-radius: 5px;
            width: 100%;
        }

        .btn-primary:hover {
            background-color: #407942;
            border-color: #2b652e;
        }
    </style>
</head>
<body>
<%@include file="navbar.jsp" %>
<!-- Booking Section -->
<section class="booking-section">
    <div class="container">
        <form class="booking-form" action="bookServlet" method="POST">
            <h2>Book a Therapy Session</h2>

            <div class="form-group">
                <label for="startDate">Start Date and Time</label>
                <input type="datetime-local" id="startDate" name="startDate" required>
            </div>

            <div class="form-group">
                <label for="endDate">End Date and Time</label>
                <input type="datetime-local" id="endDate" name="endDate" required>
            </div>

            <button type="submit" class="btn btn-primary">Book Now</button>
        </form>
    </div>
</section>

<!-- Footer -->
<%@include file="footer.jsp" %>
</body>
</html>
