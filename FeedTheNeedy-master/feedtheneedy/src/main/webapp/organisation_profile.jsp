<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Organization" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Organization Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
    body {
    font-family: 'DM Sans', sans-serif;
    background-image: url("https://static.vecteezy.com/system/resources/previews/003/359/042/non_2x/modern-abstract-flat-geometric-liquid-shapes-background-free-vector.jpg");
    background-attachment: fixed;
    background-repeat: no-repeat;
    background-size: cover;
    color: #343a40;
}

.container {
    margin-top: 80px; /* To avoid overlap with the navbar */
    background-color: rgba(255, 255, 255, 0.8);
    border-radius: 10px;
    padding: 20px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.card {
    border: none;
    margin-bottom: 20px;
}

.card-title {
    font-size: 2rem;
    font-weight: 700;
    color: #2a2525db; /* Dark color for titles */
}

.card-text {
    font-size: 1.2rem;
    margin-bottom: 10px;
}

.btn {
    background-color: #2a2525db;
    color: white;
    border-radius: 5px;
    padding: 10px 20px;
    font-size: 1rem;
}

.btn:hover {
    background-color: rgba(255, 255, 255, 0.25);
    color: black;
    transition: 0.3s;
    border: 2px solid #666699;
}

.navbar {
    background-color: #343a40; /* Dark navbar color */
}

.navbar-brand {
    font-size: 1.5rem;
    color: #ffffff;
}

.offcanvas {
    background-color: #343a40; /* Offcanvas menu color */
}

.offcanvas-header {
    border-bottom: 1px solid #dee2e6;
}

.offcanvas-body {
    color: #ffffff;
}

.one-item-one {
    background-color: #eaeaea;
    border-radius: 5px;
    padding: 10px;
    text-align: center;
    box-shadow: 1.3px 1.3px 3px gray;
}
    
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2>Organization Profile</h2>
        <%
            Organization organization = (Organization) request.getAttribute("organization");
            if (organization != null) {
        %>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title"><%= organization.getOrgName() %></h5>
                <p class="card-text"><strong>Email:</strong> <%= organization.getEmail() %></p>
                <p class="card-text"><strong>Phone:</strong> <%= organization.getPhoneNumber() %></p>
                <p class="card-text"><strong>Address:</strong> <%= organization.getStreet() %>, <%= organization.getCity() %>, <%= organization.getDistrict() %>, <%= organization.getState() %> - <%= organization.getPinCode() %></p>
            </div>
        </div>
        <%
            } else {
        %>
            <p>No organization details available.</p>
        <%
            }
        %>
        <a href="OrganizationHome" class="btn btn-primary mt-3">Back to Dashboard</a>
    </div>
</body>
</html>
