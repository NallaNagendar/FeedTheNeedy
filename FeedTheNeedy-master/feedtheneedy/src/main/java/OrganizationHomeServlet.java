import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Organization;
import model.Donation;
import feedtheneedy.DonationDAO;
import feedtheneedy.OrganizationDAO;

@WebServlet("/OrganizationHome")
public class OrganizationHomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private OrganizationDAO organizationDAO;
    private DonationDAO donationDAO;

    @Override
    public void init() {
        organizationDAO = new OrganizationDAO(); // Initialize OrganizationDAO
        donationDAO = new DonationDAO(); // Initialize DonationDAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String organizationId = (String) session.getAttribute("organizationId"); // Get org ID from session

        if (organizationId == null) {
            response.sendRedirect("login.jsp"); // Redirect to login if no session
            return;
        }

        // Fetch organization using string ID
        Organization organization = organizationDAO.selectOrganizationByOrgId(organizationId);

        if (organization != null) {
            // Fetch donations using string ID
            List<Donation> donations = donationDAO.selectDonationsByOrgId(Integer.parseInt(organizationId));

            request.setAttribute("organization", organization);
            request.setAttribute("donations", donations); // Send donations data to JSP

            request.getRequestDispatcher("organization_dashboard.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp"); // Redirect to error page if or not found
        }
    }
}
