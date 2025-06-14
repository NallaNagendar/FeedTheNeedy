<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Donor Login</title>
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,500;1,600&family=Open+Sans:wght@600&family=Poppins:wght@700&family=Roboto+Condensed:wght@700&family=Roboto:wght@400;700&family=Salsa&display=swap");
        * {
            margin: 0;
            padding: 0;
        }
        body {
            height: 100vh;
            background-image: url("https://static.vecteezy.com/system/resources/previews/010/742/835/non_2x/paper-cut-style-design-for-branding-advertising-with-abstract-shapes-modern-background-for-covers-invitations-posters-banners-flyers-placards-illustration-free-vector.jpg");
            background-size: cover;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        .info {
            text-align: center;
            color: white;
            margin-bottom: 20px;
        }
        .info h1 {
            font-family: Arial, Helvetica, sans-serif;
        }
        .info p {
            width: 500px;
            color: gray;
            text-align: justify;
            font-family: Arial, Helvetica, sans-serif;
        }
        .container {
            height: auto; /* Adjusted to fit content */
            width: 700px;
            padding: 20px;
            border: 2px solid white;
            border-radius: 20px;
            background: linear-gradient(to left, black 10%, rgba(0, 0, 0, 0.3));
            display: flex;
            flex-direction: column;
            align-items: center;
            position: relative;
        }
        .container h3 {
            color: white;
            font-size: 20px;
            font-family: Arial, Helvetica, sans-serif;
        }
        .container h4 {
            color: white;
            font-family: Arial, Helvetica, sans-serif;
            margin-bottom: 10px;
        }
        .container form {
            width: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        .container form .input_box p {
            color: gray;
            font-family: Arial, Helvetica, sans-serif;
            text-align: left;
        }
        .container form input {
            height: 30px;
            width: 300px;
            padding: 10px;
            border-radius: 5px;
            border: 2px solid rgb(92, 92, 255);
            font-weight: bold;
            margin-bottom: 10px;
        }
        .container form input:focus {
            outline: none;
            box-shadow: 0px 0px 5px 1px rgba(174, 111, 255, 0.932);
        }
        .container form .button input {
            height: 50px;
            width: 322px;
            padding: 10px;
            background-color: rgb(28 180 165);
            border: none;
            color: white;
            font-weight: bold;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 1px 1px 3px gray;
        }
        .container form .button input:hover {
            background-color: rgb(68, 160, 151);
        }
        #reg_link {
            text-align: center;
            margin: 20px;
            color: white;
        }
        #reg_link a {
            color: skyblue;
            text-decoration: none;
        }
        #reg_link a:hover {
            text-decoration: underline;
        }
        .org_button {
            position: absolute;
            bottom: -65px;
            width: 100%;
            text-align: center;
        }
        .org_button a {
            display: inline-block;
            height: 50px;
            width: 310px;
            border: 2px solid orange;
            background-color: rgba(250, 128, 114, 0.082);
            color: orange;
            font-weight: bold;
            border-radius: 5px;
            text-align: center;
            line-height: 50px;
            text-decoration: none;
        }
        .org_button a:hover {
            cursor: pointer;
            background-color: rgba(250, 128, 114, 0.311);
            box-shadow: 1px 1px 5px orange;
            color: white;
        }
        #back {
            height: 50px;
            width: 50px;
            position: absolute;
            bottom: -20px;
            left: 30px;
            border-radius: 50%;
            background-color: white;
            box-shadow: 1px 1px 4px black;
            border: none;
            cursor: pointer;
        }
        .flashmsg {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 2px solid rgb(255, 0, 0);
            background-color: rgba(255, 82, 56, 0.379);
            color: white;
            font-family: Arial, Helvetica, sans-serif;
            font-weight: bold;
            border-radius: 8px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="info">
        <h1>Donation Organization</h1>
        <p>
            We are a country that prides itself on power and wealth, yet there are
            millions of children who go hungry every day. It is our responsibility,
            not only as a nation, but also as individuals, to get involved. So, next
            time you pass someone on the street who is in need, remember how lucky
            you are, and don't turn away.
        </p>
    </div>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="flashmsg">
        <span><%= request.getAttribute("errorMessage") %></span>
    </div>
    <% } %>
    <div class="container">
        <h3>Donor</h3>
        <h4>Login</h4>
        <form action="don_login_submit" method="post">
            <div class="input_box">
                <p>Email</p>
                <input
                    type="email"
                    name="email"
                    placeholder="Enter Email"
                    required
                />
            </div>
            <div class="input_box">
                <p>Password</p>
                <input
                    type="password"
                    name="password"
                    placeholder="Enter Password"
                    required
                />
            </div>
            <div class="button">
                <input type="submit" value="Login" />
            </div>
        </form>
        <p id="reg_link">
            Register New as Donor?
            <a href="donor_registration.jsp">Register</a>
        </p>
        <div class="org_button">
            <a href="organisation_login.html">Organization Login</a>
        </div>
    </div>
   
</body>
</html>
