import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import feedtheneedy.DBConnection;

@WebServlet("/don_login_submit")
public class DonorLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection conn = DBConnection.getConnection()) {
            // Query to check email and password, and retrieve donor details
            String sql = "SELECT * FROM donors WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Retrieve donor details
                String donorName = rs.getString("user_name");
                String phoneNumber = rs.getString("phone_number");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String district = rs.getString("district");
                String state = rs.getString("state");
                String pinCode = rs.getString("pin_code");
                

                // Store donor details in session
                HttpSession session = request.getSession();
                session.setAttribute("user_name", donorName);
                session.setAttribute("phone_number", phoneNumber);
                session.setAttribute("city", city);
                session.setAttribute("street", street);
                session.setAttribute("district", district);
                session.setAttribute("state", state);
                session.setAttribute("pin_code", pinCode);
                session.setAttribute("email", email);

                // Redirect to donor dashboard after successful login
                response.sendRedirect("donor_dashboard.jsp");
            } else {
                // Login failed, set error message
                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("donor_login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred during login.");
            request.getRequestDispatcher("donor_login.jsp").forward(request, response);
        }
    }
}
