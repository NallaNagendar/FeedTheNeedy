import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import feedtheneedy.DBConnection;

@WebServlet("/OrganizationRegistrationServlet")
public class OrganizationRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String organizationName = request.getParameter("organization_name");
        String ownerName = request.getParameter("owner_name");
        String organizationId = request.getParameter("organization_id");
        String state = request.getParameter("state");
        String district = request.getParameter("district");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String pinCode = request.getParameter("pin_code");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            response.sendRedirect("organisation_register.html?error=password_mismatch");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO organizations (org_name, owner_name, organization_id, state, district, city, street, pin_code, phone_number, email, password) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, organizationName);
            stmt.setString(2, ownerName);
            stmt.setString(3, organizationId);
            stmt.setString(4, state);
            stmt.setString(5, district);
            stmt.setString(6, city);
            stmt.setString(7, street);
            stmt.setString(8, pinCode);
            stmt.setString(9, phoneNumber);
            stmt.setString(10, email);
            stmt.setString(11, password);  // Consider hashing the password for security

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                // Redirect to login page upon successful registration
                response.sendRedirect("organisation_login.html");
            } else {
                response.sendRedirect("organisation_register.html?error=registration_failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("organisation_register.html?error=sql_error");
        }
    }
}
