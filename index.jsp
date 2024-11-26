<!DOCTYPE html>
<html lang="en-US">
  <head>
    <title>THERAPYPlanner - Home</title>

    <!-- Metadata -->
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- Custom Styles -->
    <link rel="stylesheet" href="css/index.css" />

    <!-- Bootstrap CSS & JS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />

    <!-- Fontawesome CDN -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
      integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
  </head>

  <body>
<!-- Header -->
<header id="main-header" class="header">
  <div class="container">
    <!-- Logo -->
    <a href="index.jsp" class="logo"><b>THERAPY</b> Planner</a>
    
    <!-- Navigation Menu -->
    <nav class="navbar">
      <li><a href="about.jsp">About Us</a></li>
      <li><a href="therapists.jsp">Therapists</a></li>
      <li><a href="prices.jsp">Prices</a></li>
      <li><a href="prices.jsp">Prices</a></li>
      <li><a href="prices.jsp">Prices</a></li>
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
    </nav>
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
        <b>Therapy Planner connects users with experienced therapists to improve their well-being. Our mission is to make therapy accessible and convenient for everyone.</b>
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
        <p><b>Choose a therapist and schedule your session.</b></p>
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
        <p>"The platform is easy to use and has helped me connect with amazing therapists."</p>
        <h5>- John Doe</h5>
      </div>
      <div class="col-md-4">
        <p>"I love the flexibility of booking sessions online!"</p>
        <h5>- Jane Smith</h5>
      </div>
      <div class="col-md-4">
        <p>"Therapy Planner has made therapy more accessible to me."</p>
        <h5>- Michael Brown</h5>
      </div>
    </div>
  </div>
</section>

<!-- Choose Your Therapist Section -->
<section class="choose-therapist py-5 bg-light">
  <div class="container text-center">
    <h2 class="mb-4">Choose Your Therapist</h2>
    <p class="mb-5">Find the perfect therapist to guide you on your journey.</p>
    <div class="row g-4">
      <!-- Therapist 1 -->
      <div class="col-md-4">
        <div class="card border-0 shadow-sm h-100">
          <img src="assets/peter.jpg" class="card-img-top rounded-circle mx-auto mt-4" alt="Therapist 1" style="width: 100px; height: 100px;">
          <div class="card-body">
            <h5 class="card-title">Dr. Sarah Johnson</h5>
            <p class="card-text">Specialist in Cognitive Behavioral Therapy</p>
            <a href="#" class="btn ">View Profile</a>
          </div>
        </div>
      </div>
      <!-- Therapist 2 -->
      <div class="col-md-4">
        <div class="card border-0 shadow-sm h-100">
          <img src="assets/peter.jpg" class="card-img-top rounded-circle mx-auto mt-4" alt="Therapist 2" style="width: 100px; height: 100px;">
          <div class="card-body">
            <h5 class="card-title">Dr. John Smith</h5>
            <p class="card-text">Expert in Family Therapy</p>
            <a href="#" class="btn ">View Profile</a>
          </div>
        </div>
      </div>
      <!-- Therapist 3 -->
      <div class="col-md-4">
        <div class="card border-0 shadow-sm h-100">
          <img src="assets/peter.jpg" class="card-img-top rounded-circle mx-auto mt-4" alt="Therapist 3" style="width: 100px; height: 100px;">
          <div class="card-body">
            <h5 class="card-title">Dr. Emily Davis</h5>
            <p class="card-text">Licensed Clinical Psychologist</p>
            <a href="#" class="btn ">View Profile</a>
          </div>
        </div>
      </div>
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
      <footer class="lool bg-dark text-white pt-5 pb-4 ">
        <div class="container text-center text-md-left ">
          <div class="row text-center text-md-left">
            
            <div class="col-md-3 col-lg-3 colxl-3 mx-auto mt-3">
              <h5 class="text-uppercase mb-4 font-weight-bold text-success">HULK FITNESS</h5>
              <p> our company is a small organization located in the city of kamatero also this is group 3 project and they are so awesome</p>
            </div>
            
            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
              <h5 class="text-uppercase mb-4 font-weight-bold text-success">products</h5>
                <p>
                  <a href="#" class="text-white" style="text-decoration: none;">TheProviders</a>
                </p>
                <p>
                  <a href="#" class="text-white" style="text-decoration: none;">Creativity</a>
                </p>
                <p>
                  <a href="#" class="text-white" style="text-decoration: none;">Sourcefiles</a>
                </p>
                <p>
                  <a href="#" class="text-white" style="text-decoration: none;">Protein</a>
                </p>
              </div>
              
              <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
                <h5 class="text-uppercase mb-4 font-weight-bold text-success">Usefull links</h5>
                <p>
                  <a href="#" class="text-white" style="text-decoration: none;">How to be huge</a>
                </p>
                <p>
                  <a href="#" class="text-white" style="text-decoration: none;">Eat healthier</a>
                </p>
                <p>
                  <a href="#" class="text-white" style="text-decoration: none;">Best resaults</a>
                </p>
                <p>
                  <a href="#" class="text-white" style="text-decoration: none;">Help</a>
                </p>
              </div>
      
              <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
                <h5 class="text-uppercase mb-4 font-weight-bold text-success ">Contact </h5>
                <p>
                  <i class="bi bi-house-door-fill"></i> Leof. Kamaterou 134, 134 51
                </p>
                <p >
                  <i class="bi bi-envelope-at-fill"></i> Name@gmail.com
                </p>
                <p >
                  <i class="bi bi-telephone-fill"></i> 2102447229
                </p>
      
              </div>
          </div>
          <hr class="mb-4">
          <div class="text-start">
            <div class="col-md-7 com-lg-8">
              <p>copyright @2024 All rights reserved by:
                <a href="#" style="text-decoration: none;">
                <strong class="text-success ">HYLK FITNESS</strong>
              </a>
            </p>
            </div>
          </div>
      
        </div>
      </footer>
      
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6Ey2gwH0DkMbMbIeT97HbY08KNZ7PeXN2jamrPcsxkXopJ1pcV8Qv646cDf1"
      crossorigin="anonymous"
    ></script>
    <script src="js/index.js"></script>
  </body>
</html>
