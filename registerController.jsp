<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>


<%
      
String username = request.getParameter("username");
String name = request.getParameter("name");
String surname = request.getParameter("surname");
String email = request.getParameter("email");
String password = request.getParameter("password");
String confirm = request.getParameter("confirm");
String phoneNum = request.getParameter("phoneNum");

// Initialize variables for errors
int counter = 0;
List<String> ls = new ArrayList<String>();

// Validation logic
if (name == null || name.trim().length() < 3) {
  ls.add("Name must be at least 3 characters long");
  counter++;
}
if (surname == null || surname.trim().length() < 3) {
  ls.add("Surname must be at least 3 characters long");
  counter++;
}
if (username == null || username.trim().length() < 5) {
  ls.add("Username must be at least 5 characters long");
  counter++;
}
if (email == null || email.trim().length() < 5) {
  ls.add("Email must be at least 5 characters long");
  counter++;
}
if (password == null || password.trim().length() < 5) {
  ls.add("Password must be at least 5 characters long");
  counter++;
}
if (confirm == null || !confirm.equals(password)) {
  ls.add("Password and confirm do not match");
  counter++;
}


if (phoneNum == null || !phoneNum.matches("69\\d{8}")) {
  ls.add("Phone number is wrong");
}

%>

<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script crossorigin="anonymous" src="https://kit.fontawesome.com/d885a307c3.js"></script>
    <link rel="stylesheet" href="css/auth.css" />
    <link rel="stylesheet" href="css/register.css" />
    <title>Register</title>
      </head>



  <body>
    <div class="container sign-up-mode">
      <div class="forms-container">
        <div class="signin-signup">
          <form action="loginController.jsp" method="post" class="sign-in-form">
            <h2 class="title">Welcome to <b>Therapy</b> planner</h2>
            
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" name="username" placeholder="Username" />
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" name="password" placeholder="password" />
            </div>
            <input type="submit" value="Συνδεση" class="btn solid" />
            <p class="social-text">Or continue with:</p>
            <div class="social-media">
              <a href="#" class="social-icon">
                <i class="fab fa-facebook-f"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-twitter"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-google"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-linkedin-in"></i>
              </a>
            </div>
          </form>
          
          <form action="registerController.jsp" method="post" class="sign-up-form">
            <% if (counter > 0) { %>
              <!-- Display Errors -->
              <div class="alert alert-danger" role="alert">
                <h2 class="title">Registration has errors</h2>
                <center>
                <ol>
                  <% for (String error : ls) { %>
                   <li><b><%= error %></b></li>
                  <% } %>
                </ol>
              </center>
              </div>
            <% } else if (name != null) { %>
              <!-- Success Message -->
              <h2 class="title">Registration is complete</h2>
              <div class="alert alert-success" role="alert">
                <center> <b>NOTE: A verification link has been sent to <%= email %>.</b></center>
              </div>
            <% } %>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" name="username" id="username" placeholder="username" />
            </div>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="name" name="name" id="name" placeholder="First name" />
            </div>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="surname" name="surname" id="surname" placeholder="Surname" />
            </div>
            <div class="input-field">
              <i class="fas fa-envelope"></i>
              <input type="email" name="email" id="email" placeholder="Email" />
            </div>
            <div class="input-field">
              <i class="fa fa-key" aria-hidden="true"></i>
              <input type="password" name="password" id="password" placeholder="password" />
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" name="confirm" id="confirm" placeholder="Password verification" />
            </div>
            <div class="input-field">
              <i class="fas fa-phone-alt"></i>
              <input type="phone" name="phoneNum" id="phoneNum" placeholder="telephone number" />
            </div>
            <input type="submit" class="btn" value="register" />
            <p class="social-text">Or continue with: </p>
            <div class="social-media">
              <a href="#" class="social-icon">
                <i class="fab fa-facebook-f"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-twitter"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-google"></i>
              </a>
              <a href="#" class="social-icon">
                <i class="fab fa-linkedin-in"></i>
              </a>
            </div>
          </form>
        </div>
      </div>

      <div class="panels-container">
        <div class="panel left-panel">
          <div class="content">
            <h3>Don't have an account?</h3>
            <p>
              Create one now to enjoy more tools. I promise it won't take long!
            </p>
            <button class="btn transparent" id="sign-up-btn">
              register
            </button>
          </div>
          <img src="images/cats-and-dogs-removebg-preview.png" class="image" alt="" />
        </div>
        <div class="panel right-panel">
          <div class="content">
            <h3>Already a member? </h3>
            <p>
              Great! Click Login and fill in your details.
            </p>
            <a href="login.jsp">
              <button class="btn transparent" id="sign-in-btn">
                Login
              </button>

            </a>
            
          </div>
          <img src="images/cats-and-dogs-signup-removebg-preview.png" class="image" alt="" />
        </div>
      </div>
    </div>

    <script src="js/loginForm.js"></script>
  </body>
</html>