<%@ page import="model.Donation" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Donation History</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    .status-pending {
    background-color: #f5c6cb !important; /* Darker red background for Pending */
    color: #721c24 !important; /* Text color for Pending */
}

.status-accepted {
    background-color: #c3e6cb !important; /* Darker green background for Accepted */
    color: #155724 !important; /* Text color for Accepted */
}

        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            background-color: white;
        }
        h1 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table th, table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        table th {
            background-color: #666699;
            color: white;
            border-radius: 5px;
        }
        .no-data {
            text-align: center;
            font-size: 1.2em;
            color: red;
            margin-top: 20px;
        }
        .btn-back {
            margin-top: 20px;
            display: flex;
            justify-content: center;
        }
        /* Status-specific colors */
       
    </style>
</head>
<body>
    <div class="container">
        <h1>Donation History</h1>

        <%
            List<Donation> donations = (List<Donation>) request.getAttribute("donations");

            if (donations == null || donations.isEmpty()) {
        %>
            <p class="no-data">No donations found.</p>
        <%
            } else {
        %>
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Donor Name</th>
                        <th>Item</th>
                        <th>Quantity</th>
                        <th>Donation</th>
                        <th>Phone</th>
                        <th>City</th>
                        <th>Street</th>
                        <th>District</th>
                        <th>State</th>
                        <th>Pincode</th>
                        <th>Email</th>
                        <th>Status</th> <!-- Added Status Column -->
                    </tr>
                </thead>
                <tbody>
                     <%
        for (Donation donation : donations) {
            String currentStatus = donation.getStatus();
            System.out.println("Current Status: " + currentStatus); // Debugging output
            
            // Determine the status class based on the donation status
            String statusClass = "";
            if ("Pending".equalsIgnoreCase(currentStatus)) {
                statusClass = "status-pending";
            } else if ("Accepted".equalsIgnoreCase(currentStatus)) {
                statusClass = "status-accepted";
            }
    %>
                        <tr>
                            <td><%= donation.getDonorName() %></td>
                            <td><%= donation.getItem() %></td>
                            <td><%= donation.getQuantity() %></td>
                            <td><%= donation.getDonation() %></td>
                            <td><%= donation.getPhone() %></td>
                            <td><%= donation.getCity() %></td>
                            <td><%= donation.getStreet() %></td>
                            <td><%= donation.getDist() %></td>
                            <td><%= donation.getState() %></td>
                            <td><%= donation.getPincode() %></td>
                            <td><%= donation.getEmail() %></td>
                            <td class="<%= statusClass %>"><%= donation.getStatus() %></td> <!-- Conditional Formatting -->
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        <%
            }
        %>
        <div class="btn-back">
            <a href="donor_dashboard.jsp" class="btn btn-primary">Back to Home</a>
        </div>
    </div>
</body>
</html>
