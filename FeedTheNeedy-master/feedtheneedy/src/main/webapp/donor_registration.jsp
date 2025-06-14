<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Donor Registration</title>
    <style>
      * {
        margin: 0;
        padding: 0;
      }
      body {
        background-image: url("https://img.freepik.com/premium-photo/poor-starving-hungry-boy-looking-camera_1009902-61.jpg");
        background-repeat: no-repeat;
        background-size: cover;
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
      }
      .info {
        height: 30%;
      }
      .info h1 {
        margin: 20px;
        text-align: center;
        color: #c6c1c1;
        font-family: Arial, Helvetica, sans-serif;
        font-size: 40px;
      }
      .container {
        width: 70%;
        background-color: white;
        border-radius: 20px;
        margin-top: 20px;
        padding: 30px;
        display: flex;
        flex-direction: column;
        align-items: center;
      }
      .container h2 {
        font-family: Arial, Helvetica, sans-serif;
        text-align: center;
        margin-bottom: 10px;
      }
      .container form {
        width: 80%;
      }
      .form_data {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
      }
      .form_data .input_box {
        width: 40%;
        margin: 10px;
      }
      .form_data .input_box span {
        font-family: Arial, Helvetica, sans-serif;
        color: rgb(108, 108, 108);
        font-size: 15px;
      }
      .form_data .input_box input {
        height: 30px;
        width: 100%;
        padding: 5px;
        border-radius: 5px;
        border: 2px solid rgb(92, 92, 255);
        font-weight: bold;
      }
      .form_data .button {
        width: 100%;
        margin: 10px;
        display: flex;
        justify-content: center;
      }
      .form_data .button input {
        height: 40px;
        width: 300px;
        border-radius: 5px;
        background-color: rgb(255, 132, 0);
        border: none;
        font-weight: bold;
        color: white;
        cursor: pointer;
      }
      .form_data .button input:hover {
        box-shadow: 1px 1px 6px #06f;
      }
      #errmsg {
        font-family: Arial, Helvetica, sans-serif;
        font-size: 18px;
        font-weight: bold;
        color: red;
      }
      #sccmsg {
        font-family: Arial, Helvetica, sans-serif;
        font-size: 18px;
        font-weight: bold;
        color: rgb(0, 183, 0);
      }
      .login-message {
        margin-top: 20px;
        font-family: Arial, Helvetica, sans-serif;
        font-size: 14px;
        color: #333333;
      }
      .login-message a {
        color: rgb(255, 132, 0);
        text-decoration: none;
        font-weight: bold;
      }
      .login-message a:hover {
        text-decoration: underline;
      }
    </style>
  </head>
  <body>
    <div class="info">
      <h1>Donor Registration</h1>
    </div>

    <div class="container">
      <h2>Create Account</h2>
      <% if (request.getAttribute("successMessage") != null) { %>
      <span id="sccmsg"><%= request.getAttribute("successMessage") %></span>
      <% } %>
      <% if (request.getAttribute("errorMessage") != null) { %>
      <span id="errmsg"><%= request.getAttribute("errorMessage") %></span>
      <% } %>

      <form action="DonorRegistrationServlet" method="post">
        <div class="form_data">
          <div class="input_box">
            <span>Name</span>
            <input type="text" name="user_name" placeholder="Enter Donor Name" required />
          </div>
          <div class="input_box">
            <span>Email</span>
            <input type="email" name="email" placeholder="Enter Email" required />
          </div>
          <div class="input_box">
            <span>Password</span>
            <input type="password" name="password" placeholder="Enter Password" required />
          </div>
          <div class="input_box">
            <span>Confirm Password</span>
            <input type="password" name="confirm_password" placeholder="Re-Enter Password" required />
          </div>
          <div class="input_box">
            <span>Phone Number</span>
            <input type="text" name="phone_number" placeholder="Enter Phone Number" required />
          </div>
          <div class="input_box">
            <span>Street</span>
            <input type="text" name="street" placeholder="Enter Street" required />
          </div>
          <div class="input_box">
            <span>District</span>
            <input type="text" name="district" placeholder="Enter District" required />
          </div>
          <div class="input_box">
            <span>City</span>
            <input type="text" name="city" placeholder="Enter City" required />
          </div>
          <div class="input_box">
            <span>State</span>
            <input type="text" name="state" placeholder="Enter State" required />
          </div>
          <div class="input_box">
            <span>Pin Code</span>
            <input type="text" name="pin_code" placeholder="Enter Pin Code" required />
          </div>
          <div class="button">
            <input type="submit" value="Register" />
          </div>
        </div>
      </form>

      <p class="login-message">
        Already have an account? <a href="donor_login.jsp">Login here</a>
      </p>
    </div>
  </body>
</html>
