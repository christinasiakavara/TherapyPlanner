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
        .about-us {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 50px 0;
            background-color: #f8f9fa;
        }

        .about-us h2 {
            font-size: 2.5rem;
            font-weight: bold;
            color: #333;
        }

        .about-us p {
            color: #666;
            line-height: 1.8;
        }

        .about-us img {
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>

<%@include file="navbar.jsp" %>

<!-- About Us Section -->
<section class="about-us">
    <div class="container">
        <div class="row align-items-center">
            <!-- Text Content -->
            <div class="col-md-6">
                <h2 class="mb-4">About Us</h2>
                <p>
                    Welcome to <strong>Therapy Planner</strong>, your trusted platform for mental health and personal
                    growth.
                    We understand that life's challenges can sometimes feel overwhelming, and finding the right support
                    is essential.
                    That’s why we are dedicated to providing a space where individuals can connect with experienced and
                    compassionate therapists, explore their feelings, and achieve a sense of balance and well-being.
                </p>
                <p>
                    Our mission is simple: to make quality mental health care accessible and approachable for everyone.
                    Whether you’re dealing with stress, anxiety, relationship issues, or simply seeking personal growth,
                    Therapy Planner is here to guide you every step of the way. With a focus on convenience and
                    customization,
                    we ensure you can find the right therapist who understands your unique needs and goals.
                </p>
                <p>
                    What sets us apart is our commitment to inclusivity, professionalism, and innovation.
                    We offer a variety of therapeutic approaches, allowing you to choose what resonates most with you.
                    Our therapists are carefully vetted, ensuring you have access to skilled professionals who are
                    passionate about helping you thrive.
                    We believe mental health is a journey, and we’re here to walk alongside you, providing the tools and
                    resources you need to succeed.
                </p>
                <p>
                    Thank you for choosing Therapy Planner. We’re honored to be part of your journey toward a healthier
                    and more fulfilling life.
                </p>
            </div>

            <!-- Image Content -->
            <div class="col-md-6 text-center">
                <img src="assets/therapy.png" alt="About Us" class="img-fluid rounded shadow-sm"
                     style="max-width: 90%;">
            </div>
        </div>
    </div>
</section>

<!-- Bootstrap JS -->
<%@include file="footer.jsp" %>
</body>
</html>
