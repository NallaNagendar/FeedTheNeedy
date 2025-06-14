<%@ page import="java.util.List" %>
<%@ page import="model.Organization" %>
<%@ page import="feedtheneedy.OrganizationDAO" %>
<%
    OrganizationDAO organizationDAO = new OrganizationDAO();
    List<Organization> organizations = organizationDAO.selectAllOrganizations();

    String donorName = (String) session.getAttribute("user_name");
    String phoneNumber = (String) session.getAttribute("phone_number");
    String city = (String) session.getAttribute("city");
    String street = (String) session.getAttribute("street");
    String dist = (String) session.getAttribute("district");
    String state = (String) session.getAttribute("state");
    String pincode = (String) session.getAttribute("pin_code");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Donate Grocery</title>
    <style>
        /* General Styles */
        body {
            background-color: #FCEFEF;
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
        }

        .content {
            width: 400px;
            background-color: white;
            border-radius: 12px;
            padding: 30px;
            margin: 50px auto;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            font-size: 28px;
            color: #333;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            font-size: 18px;
            font-weight: bold;
            color: #333;
            margin-bottom: 8px;
        }

        input[type="text"], input[type="number"], select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #DDD;
            border-radius: 8px;
            font-size: 16px;
        }

        button[type="submit"], button[type="button"] {
            background-color: #76C7C0;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 8px;
            font-size: 18px;
            cursor: pointer;
            width: 100%;
        }

        button[type="submit"]:hover, button[type="button"]:hover {
            background-color: #64B4AE;
        }

        .contact, .address {
            font-size: 18px;
            font-weight: bold;
            color: #555;
            margin-bottom: 20px;
        }

        .address p {
            line-height: 1.5;
            color: #777;
        }

        .popup {
            position: fixed;
            top: 0;
            left: 0;
            height: 100vh;
            width: 100vw;
            background-color: rgba(0, 0, 0, 0.6);
            display: none;
            align-items: center;
            justify-content: center;
        }

        .popChild {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            text-align: center;
        }

        #done {
            display: inline-block;
            height: 40px;
            width: 100px;
            line-height: 40px;
            text-align: center;
            border-radius: 5px;
            border: none;
            background-color: #76C7C0;
            color: white;
            font-weight: bold;
            text-decoration: none;
            cursor: pointer;
        }

        #done:hover {
            background-color: #64B4AE;
        }
    </style>
</head>
<body>
    <div class="content">
        <h1>Donate Grocery</h1>
      <form action="donateGrocery" method="post">
    <div id="donation-items">
        <div class="item-group">
            <label>Item:</label>
            <input type="text" name="item[]" required />

            <label>Quantity:</label>
            <input type="number" name="quantity[]" required />
        </div>
    </div>

    <!-- Button to add more items dynamically -->
    <button type="button" onclick="addItem()">Add another item</button>

    <!-- Organization selection (ensure this is populated dynamically if needed) -->
    <label>Organization:</label>
    <select name="organizationId" required>
        <option value="" hidden>Select Organization</option>
        <% for (Organization org : organizations) { %>
            <option value="<%= org.getId() %>"><%= org.getOrgName() %>, <%= org.getCity() %></option>
        <% } %>
    </select>

    <label>Donation Type:</label>
    <input type="text" name="donation" value ="grocery" required />
    <input type="submit" value="Donate"/>
</form>
</div>
<script>
function addItem() {
    const itemGroup = document.querySelector('.item-group').cloneNode(true);
    document.getElementById('donation-items').appendChild(itemGroup);
}
</script>

</body>
</html>
