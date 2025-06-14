import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import feedtheneedy.DonationDAO;
import model.Donation;

@WebServlet("/donationHistory")
public class DonationHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DonationDAO donationDAO;

    @Override
    public void init() throws ServletException {
        donationDAO = new DonationDAO(); // Initialize DAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve organization ID from session
        String organizationId = (String) request.getSession().getAttribute("organizationId");

        if (organizationId == null || organizationId.isEmpty()) {
            // Handle case where organizationId is not available
            response.sendRedirect("login.jsp");  // Redirect to login if no organizationId
            return;
        }

        try {
            // Fetch donation history from DAO
            List<Donation> donations = donationDAO.selectDonationsByOrgId(Integer.parseInt(organizationId));

            // Set the donation history in request attribute
            request.setAttribute("donations", donations);

            // Forward to the JSP page for displaying the donation history
            request.getRequestDispatcher("organization_history.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            // Handle invalid organizationId format
            e.printStackTrace();
            throw new ServletException("Invalid organization ID format", e);
        }
    }
}
