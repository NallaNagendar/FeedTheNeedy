import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;  // Import HttpSession
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import feedtheneedy.DBConnection;

@WebServlet("/DonorRegistrationServlet")
public class DonorRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String userName = request.getParameter("user_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        String phoneNumber = request.getParameter("phone_number");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String district = request.getParameter("district");
        String state = request.getParameter("state");
        String pinCode = request.getParameter("pin_code");

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match!");
            request.getRequestDispatcher("donor_registration.jsp").forward(request, response);
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            // Insert donor information into the database
            String sql = "INSERT INTO donors (user_name, email, password, phone_number, city, street, district, state, pin_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);
            stmt.setString(2, email);
            stmt.setString(3, password);  // Consider hashing the password for security
            stmt.setString(4, phoneNumber);
            stmt.setString(5, city);
            stmt.setString(6, street);
            stmt.setString(7, district);
            stmt.setString(8, state);
            stmt.setString(9, pinCode);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                // On successful registration, store donor info in session
                HttpSession session = request.getSession();
                session.setAttribute("donorName", userName);
                session.setAttribute("phoneNumber", phoneNumber);
                session.setAttribute("street", street);
                session.setAttribute("city", city);
                session.setAttribute("dist", district);
                session.setAttribute("state", state);
                session.setAttribute("pincode", pinCode);

                // Optionally, redirect to the donor's home page or a success page
                response.sendRedirect("donor_login.jsp");  // Redirect to donor home or relevant page
            } else {
                // If insertion failed, show error message
                request.setAttribute("errorMessage", "Registration failed, please try again.");
                request.getRequestDispatcher("donor_registration.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception and show error message on the registration page
            request.setAttribute("errorMessage", "An error occurred during registration.");
            request.getRequestDispatcher("donor_registration.jsp").forward(request, response);
        }
    }
}
