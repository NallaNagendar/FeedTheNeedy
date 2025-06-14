<%@ page import="model.Donation" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
    <title>Donation History</title>
    <style>
      body {
        background-image: url("https://static.vecteezy.com/system/resources/previews/004/227/842/non_2x/modern-abstract-background-with-minimal-cover-design-colorful-and-cute-geometric-background-for-web-banner-poster-illustration-hand-drawn-various-shapes-and-doodle-objects-vector.jpg");
        background-repeat: no-repeat;
        background-size: cover;
        background-position: center;
        background-attachment: fixed;
      }
      .container {
        margin-top: 60px;
      }
      .container h3 {
        text-align: center;
        font-weight: bold;
      }
      .his_list {
        width: 100%;
        border-radius: 10px;
        margin-bottom: 15px;
      }
      p {
        margin: 0;
      }
      .connn {
        display: flex;
        justify-content: space-between;
        align-items: center;
        box-shadow: 0 0 5px gray;
        margin: 1% 5%;
        padding: 2%;
        background-color: #ffffff;
        border-radius: 10px;
      }
      .one-items {
        height: auto;
        margin-top: 1%;
        display: flex;
        flex-wrap: wrap;
        gap: 10px;
      }
      .one-item-one {
        box-shadow: 1.3px 1.3px 3px gray;
        padding: 0.5% 5%;
        margin-right: 2%;
        border-radius: 5px;
        display: flex;
        align-items: center;
        flex-direction: column;
      }
      .status_info {
        display: flex;
        flex-direction: column;
        align-items: flex-end;
      }
      #status1 {
        height: 50px;
        width: 150px;
        padding: 10px;
        text-align: center;
        border-radius: 5px;
        color: rgb(255, 255, 255);
        background-color: rgb(0, 0, 0);
        border: none;
        font-weight: bold;
        cursor: pointer;
      }
      #status1:hover {
        color: rgb(0, 0, 0);
        background-color: white;
        border: 2px solid black;
        transition: 0.3s;
      }
      #status2 {
        height: 50px;
        width: 150px;
        padding: 10px;
        text-align: center;
        border-radius: 5px;
        border: 2px solid rgb(33, 194, 44);
        color: rgb(49, 174, 47);
        background-color: rgba(49, 174, 47, 0.151);
        font-weight: bold;
      }
      #orderid {
        border-radius: 5px;
        padding: 4px;
        border: 1px solid gray;
      }
    </style>
  </head>
  <body>
    <nav class="navbar navbar-dark bg-dark fixed-top">
      <div class="container-fluid">
        <h5 style="color: white">FOOD DONATION</h5>
        <div style="display: flex; align-items: center">
          <h6 style="color: rgb(161, 161, 161); margin-right: 10px">
            <%= request.getAttribute("name") %>
          </h6>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="offcanvas"
            data-bs-target="#offcanvasDarkNavbar"
            aria-controls="offcanvasDarkNavbar"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
        <div
          class="offcanvas offcanvas-end text-bg-dark"
          tabindex="-1"
          id="offcanvasDarkNavbar"
          aria-labelledby="offcanvasDarkNavbarLabel"
        >
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Menu</h5>
            <button
              type="button"
              class="btn-close btn-close-white"
              data-bs-dismiss="offcanvas"
              aria-label="Close"
            ></button>
          </div>
          <div class="offcanvas-body">
            <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
              <li class="nav-item">
                <a class="nav-link active" href="/org_home">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="/org_profile">Profile</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="#" style="background-color: #666699; padding-left: 20px; border-radius: 5px;">History</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>
    <div class="container">
      <h3>Donation History</h3>
      <div class="his_list">
        <%
        List<Donation> donations = (List<Donation>) request.getAttribute("donations");
        for (Donation donation : donations) {
        %>
          <div class="connn">
            <div>
              <p><b>Donor Name:</b> <%= donation.getDonorName() %></p>
              <p><b>Donation:</b> <%= donation.getDonation() %></p>
              <p><b>Address:</b></p>
              <p><%= donation.getStreet() + ", " + donation.getCity() + ", " + donation.getDist() + ", " + donation.getState() + " - " + donation.getPincode() %></p>
              <b>Email:</b> <%= donation.getEmail() %>
            </div>
            <div class="con2">
             
              <p class="ph"><b>Phone:</b> <%= donation.getPhone() %></p>
            </div>
          </div>
        <%
        }
        %>
      </div>
    </div>
  </body>
</html>
