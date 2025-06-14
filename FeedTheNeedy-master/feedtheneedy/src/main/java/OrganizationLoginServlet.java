

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import feedtheneedy.DBConnection;

@WebServlet("/OrganizationLoginServlet")
public class OrganizationLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Retrieve form data
        String organizationId = request.getParameter("organization_id");
        String password = request.getParameter("password");
        
        // Validate inputs (you can add more complex validation as needed)
        if (organizationId == null || password == null || organizationId.isEmpty() || password.isEmpty()) {
            out.println("<h3>Please fill in both fields!</h3>");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            // SQL query to validate login
            String sql = "SELECT * FROM organizations WHERE organization_id = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, organizationId);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // If login is successful, create a session and redirect to dashboard
                HttpSession session = request.getSession();
                session.setAttribute("organizationId", organizationId);
                
                response.sendRedirect("OrganizationHome");  // Redirect to dashboard (assuming it's JSP)
            } else {
                // If login fails, redirect back to the login page with a fail flag
                response.sendRedirect("organisation_login.html?error=true");
            }
        } catch (SQLException e) {
            out.println("<h3>An error occurred: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        }
    }
}


