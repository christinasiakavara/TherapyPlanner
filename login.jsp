<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script crossorigin="anonymous" src="https://kit.fontawesome.com/d885a307c3.js">
    </script>
    <link rel="stylesheet" href="css/auth.css" />
    <link rel="stylesheet" href="css/login.css" />
    <title>Register</title>
  </head>
  

  <body>
    <div class="container">
      <div class="forms-container">
        <div class="signin-signup">
        
          <% if(request.getAttribute("message") != null) { %>		
            <div class="alert alert-danger text-center" role="alert"><%=(String)request.getAttribute("message") %></div>
        <% } %>

          <form action="#" class="sign-in-form">
            <h1 class="title">Welcome to <b>THERAPY</b>planner</h1>
            <div class="input-field">
              <i class="fas fa-user"></i>
              <input type="text" placeholder="Username" />
            </div>
            <div class="input-field">
              <i class="fas fa-lock"></i>
              <input type="password" placeholder="Password" />
            </div>
            <input type="submit" value="Connect" class="btn solid" />
            <p class="social-text">OR CONTINUE WITH</p>
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
            <h3>Do you have an account?</h3>
            <p>
              Κάνε τώρα έναν για να απολαμβάνεις περισσότερα εργαλεία. Σου υπόσχομαι δεν θα πάρει ώρα!
            </p>
            <button class="btn transparent" id="sign-up-btn">
              REGISTER
            </button>
          </div>
          <img src="cats-and-dogs-removebg-preview.png" class="image" alt="" />
        </div>
        <div class="panel right-panel">
          <div class="content">
            <h3>Είσαι ήδη μέλος μας; </h3>
            <p>
              Τέλεια! Πάτα Σύνδεση και συμπλήρωσε τα στοιχεία σου.
            </p>
            <button class="btn transparent" id="sign-in-btn">
                Συνδεθείτε
            </button>
          </div>
          <img src="cats-and-dogs-signup-removebg-preview.png" class="image" alt="" />
        </div>
      </div>
    </div>

    <script src="js/index.js"></script>
  </body>
</html>