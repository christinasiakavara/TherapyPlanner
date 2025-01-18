<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.sql.*" %>
<%@ page import="DETsCode.User.User" %>

<%
    User user = (User) session.getAttribute("userObj2024");
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="header.jsp" %>
    <style>
        .prices-section {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #f9f9f9;
        }

        .prices-section h2 {
            font-size: 2.5rem;
            font-weight: bold;
            margin-bottom: 40px;
            text-align: center;
        }

        .price-card {
            border: 1px solid #ddd;
            border-radius: 10px;
            transition: transform 0.3s, box-shadow 0.3s;
        }

        .price-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        }

        .price-header {
            background-color: #095d44;
            color: white;
            padding: 20px;
            border-radius: 10px 10px 0 0;
            text-align: center;
            font-size: 1.5rem;
            font-weight: bold;
        }

        .price-body {
            padding: 30px;
            text-align: center;
        }

        .price {
            font-size: 2rem;
            font-weight: bold;
            color: #333;
        }

        .btn-success {
            margin-top: 20px;
            background-color: #095d44;
            border-color: #095d44;
        }

        .btn-success:hover {
            background-color: #407942;
            border-color: #2b652e;
        }
    </style>
</head>
<body>
<%@include file="navbar.jsp" %>
<!-- Prices Section -->
<section class="prices-section">
    <div class="container">
        <h2>Our Pricing Plans</h2>
        <div class="row g-4 justify-content-center">
            <!-- Basic Plan -->
            <div class="col-md-4">
                <div class="price-card">
                    <div class="price-header">Basic</div>
                    <div class="price-body">
                        <p class="price">$49/month</p>
                        <p>1 Therapy Session</p>
                        <p>Email Support</p>
                        <p>Access to Resources</p>
                        <a href="book.jsp?plan=basic" class="btn btn-success">Choose Plan</a>
                    </div>
                </div>
            </div>

            <!-- Standard Plan -->
            <div class="col-md-4">
                <div class="price-card">
                    <div class="price-header">Standard</div>
                    <div class="price-body">
                        <p class="price">$99/month</p>
                        <p>4 Therapy Sessions</p>
                        <p>Priority Email Support</p>
                        <p>Access to Premium Resources</p>
                        <a href="book.jsp?plan=standard" class="btn btn-success">Choose Plan</a>
                    </div>
                </div>
            </div>

            <!-- Premium Plan -->
            <div class="col-md-4">
                <div class="price-card">
                    <div class="price-header">Premium</div>
                    <div class="price-body">
                        <p class="price">$199/month</p>
                        <p>Unlimited Therapy Sessions</p>
                        <p>24/7 Support</p>
                        <p>Exclusive Resources</p>
                        <a href="book.jsp?plan=premium" class="btn btn-success">Choose Plan</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Bootstrap JS -->
<%@include file="footer.jsp" %>
</body>
</html>
