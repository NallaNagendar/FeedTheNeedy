<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Donor Dashboard</title>
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
    <style>
      .con {
        display: flex;
        align-items: center;
      }
      .con2 {
        margin-top: 40px;
        height: 100vh;
        background-image: url("https://i.ibb.co/k2szXKz/bg-img.jpg");
        background-attachment: fixed;
        background-size: contain;
        background-position: right;
        background-repeat: no-repeat;
      }
      .bg_col {
        height: 100%;
        width: 100%;
        background: linear-gradient(to right, black 20%, rgba(0, 0, 0, 0.258));
        display: flex;
        align-items: center;
        gap: 20px;
      }
      h2 {
        font-weight: bold;
      }
      .food {
        text-indent: 10%;
        width: 24%;
        height: 60%;
        background-color: #eaeaea;
        border-radius: 5px;
        box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
        padding: 20px;
        margin-left: 80px;
        display: flex;
        flex-direction: column;
        justify-content: space-around;
      }
      .foodhead {
        text-indent: 0px;
      }
      .groceryhead {
        text-indent: 0px;
      }
      .grocery {
        border-radius: 5px;
        text-indent: 10%;
        color: #eaeaea;
        border: 2px solid;
        box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
        width: 24%;
        height: 60%;
        padding: 20px;
        display: flex;
        flex-direction: column;
        justify-content: space-around;
      }
      .bt {
        padding: 0px 20px 0px 0px;
        display: flex;
        justify-content: end;
      }
      .btb {
        width: 130px;
        height: 40px;
        background-color: rgb(32 180 32);
        border-radius: 5px;
        box-shadow: 0 0 5px gray;
        border: none;
        color: white;
        text-align: center;
        line-height: 40px; /* Center the text vertically */
        text-decoration: none; /* Remove underline from anchor tags */
      }
      .btb:hover {
        background-color: rgba(255, 255, 255, 0.25);
        color: rgb(32 180 32);
        font-weight: bold;
        transition: 0.3s;
        border: 2px solid rgb(32 180 32);
      }
      p {
        text-align: justify;
      }
    </style>
</head>
<body>
    <nav class="navbar navbar-dark bg-dark fixed-top">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">FOOD DONATION</a>
        <div class="con">
         
          <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
        <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">MENU</h5>
            <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
          </div>
          <div class="offcanvas-body">
            <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="donor_dashboard.jsp" style="background-color: #666699; padding-left: 20px; border-radius: 5px;">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/don_profile">Profile</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="don_history">History</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="donor_login.jsp">LogOut</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>
    <div class="con2">
      <div class="bg_col">
        <div class="food">
          <h2 class="foodhead">DONATE FOOD</h2>
          <p>
            Food donation serves a dual purpose by reducing food wastage and providing essential sustenance to individuals and families facing economic challenges. Food donation fosters a sense of community and solidarity, encouraging people to come together to tackle the critical issue of food insecurity, ensuring that no one goes to bed hungry.
          </p>
          <div class="bt">
            <a class="btb" href="donate_food.jsp">Donate</a>
          </div>
        </div>
        <div class="grocery">
          <h2 class="groceryhead">DONATE GROCERY</h2>
          <p>
            This charitable gesture aims to support individuals and families facing financial hardship or crisis by providing them with the necessary resources to meet their basic needs. Grocery donations can take place through organized food drives, community initiatives, or direct contributions to food banks, shelters, and charitable organizations.
          </p>
          <div class="bt">
            <a class="btb" href="donate_Grocery.jsp">Donate</a>
          </div>
        </div>
      </div>
    </div>
</body>
</html>
