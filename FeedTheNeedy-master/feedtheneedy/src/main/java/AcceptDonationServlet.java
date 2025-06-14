import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import feedtheneedy.DonationDAO;
import model.Donation;

@WebServlet("/AcceptDonation")
public class AcceptDonationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DonationDAO donationDAO;

    @Override
    public void init() {
        donationDAO = new DonationDAO(); // Initialize DonationDAO
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the phone number from the session
        HttpSession session = request.getSession();
        String phone = (String) session.getAttribute("phone_number");

        if (phone == null || phone.isEmpty()) {
            // If phone number is not found in session, redirect to an error page
            response.sendRedirect("error.jsp");
            return;
        }

        // Fetch donations associated with the phone number
        List<Donation> donations = donationDAO.selectDonationsByPhoneNumber(phone);

        if (donations != null && !donations.isEmpty()) {
            // Update the status of the donations to "Accepted"
            boolean isAccepted = donationDAO.updateDonationStatusByPhone(phone, "Accepted");

            if (isAccepted) {
                // Redirect to the same page to show the updated status
                request.setAttribute("donations", donations);
                request.getRequestDispatcher("organization_dashboard.jsp").forward(request, response);
            } else {
                response.sendRedirect("error.jsp");
            }
        } else {
            // No donations found for this phone number, redirect to error page
            response.sendRedirect("error.jsp");
        }
    }
}
