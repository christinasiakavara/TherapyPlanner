<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script crossorigin="anonymous" src="https://kit.fontawesome.com/d885a307c3.js">
    </script>
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
            <h2 class="title">Registration</h2>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" name="username" id="username" placeholder="username" />
            </div>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="name" name="firstName" id="firstName" placeholder="First name" />
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
              <input type="password" name="verifyPassword" id="verifyPassword" placeholder="Password verification" />
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