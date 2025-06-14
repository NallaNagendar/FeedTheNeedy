import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;

@WebServlet("/donateGrocery")
public class DonateGroceryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection details
    private String jdbcURL = "jdbc:mysql://localhost:3306/feedtheneedy";
    private String jdbcUsername = "root";  // Change to your DB username
    private String jdbcPassword = "root";  // Change to your DB password

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve donor's session attributes
        String donorName = (String) request.getSession().getAttribute("user_name");
        String phone = (String) request.getSession().getAttribute("phone_number");
        String city = (String) request.getSession().getAttribute("city");
        String street = (String) request.getSession().getAttribute("street");
        String dist = (String) request.getSession().getAttribute("district");
        String state = (String) request.getSession().getAttribute("state");
        String pincode = (String) request.getSession().getAttribute("pin_code");

        // Get form data from the request
        String[] items = request.getParameterValues("item[]");
        String[] quantities = request.getParameterValues("quantity[]");
        String donation = request.getParameter("donation");
        int organizationId = Integer.parseInt(request.getParameter("organizationId"));

        // Debugging output to check if items and quantities are retrieved correctly
        System.out.println("Items: " + Arrays.toString(items));
        System.out.println("Quantities: " + Arrays.toString(quantities));
        System.out.println("Organization ID: " + organizationId);

        // Insert each item into the database
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
            String insertQuery = "INSERT INTO grocery_storage (donor_name, item, quantity, donation, organization_id, phone, city, street, dist, state, pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            for (int i = 0; i < items.length; i++) {
                // Set values for each item being donated
                preparedStatement.setString(1, donorName);
                preparedStatement.setString(2, items[i]);
                preparedStatement.setString(3, quantities[i]);
                preparedStatement.setString(4, donation);
                preparedStatement.setInt(5, organizationId);
                preparedStatement.setString(6, phone);
                preparedStatement.setString(7, city);
                preparedStatement.setString(8, street);
                preparedStatement.setString(9, dist);
                preparedStatement.setString(10, state);
                preparedStatement.setString(11, pincode);

                // Execute insert for each item
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("donor_dashboard.jsp");
            
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error: " + e.getMessage());
        }
    }
}
