<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Donation" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Organization Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-image: url("https://static.vecteezy.com/system/resources/previews/003/359/042/non_2x/modern-abstract-flat-geometric-liquid-shapes-background-free-vector.jpg");
            background-attachment: fixed;
            background-repeat: no-repeat;
            background-size: cover;
        }
        .container-custom {
            margin-top: 80px;
            background-color: #f8f8f8;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 1px 1px 10px gray;
            max-width: 1000px;
        }
        .donation-item {
            background-color: white;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        .donhead {
            text-align: center;
            margin-top: 30px;
            margin-bottom: 20px;
        }
        .one-btn {
            height: 40px;
            width: 100%;
            color: white;
            background-color: #2a2525db;
            border-radius: 5px;
            border: none;
        }
        .one-btn:hover {
            background-color: rgba(255, 255, 255, 0.25);
            color: black;
            transition: 0.3s;
            border: 2px solid #666699;
        }
        .accepted-text {
            color: green;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">FOOD DONATION</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="org_profile">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="donationHistory">History</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="organisation_login.html">LogOut</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-10 container-custom">
                <h1 class="text-center mb-4">FOOD DONATION</h1>
                <p class="text-center">"Food donation is a simple act of kindness that can nourish both the body and soul."</p>
            </div>
        </div>
    </div>

    <div class="container">
        <h2 class="donhead">Donation Requests:</h2>
        <div class="row justify-content-center">
            <% List<Donation> donations = (List<Donation>) request.getAttribute("donations"); %>
            <% if (donations != null && !donations.isEmpty()) { %>
                <% for (Donation donation : donations) { %>
                    <div class="col-md-8 donation-item">
                        <p><b>Donor Name:</b> <%= donation.getDonorName() %></p>
                        <p><b>Item:</b> <%= donation.getItem() %></p>
                        <p><b>Quantity:</b> <%= donation.getQuantity() %></p>
                        <p><b>Phone:</b> <%= donation.getPhone() %></p>
                        <p><b>City:</b> <%= donation.getCity() %></p>

                        <% if ("Accepted".equals(donation.getStatus())) { %>
                            <p class="accepted-text">Accepted</p>
                        <% } else { %>
                            <form action="AcceptDonation" method="post">
                                <input type="hidden" name="phone" value="<%= donation.getPhone() %>" />
                                <button class="one-btn">Accept Donation</button>
                            </form>
                        <% } %>
                    </div>
                <% } %>
            <% } else { %>
                <div class="col-md-8">
                    <p>No donations available.</p>
                </div>
            <% } %>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
