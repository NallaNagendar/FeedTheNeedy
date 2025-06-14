

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Donation;
import java.io.IOException;
import java.util.List;
import feedtheneedy.DonationDAO;

@WebServlet("/don_history")
public class DonorHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DonationDAO donationDAO;

    public void init() {
        donationDAO = new DonationDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumber = (String) request.getSession().getAttribute("phone_number");
        
        if (phoneNumber != null) {
            List<Donation> donations = donationDAO.selectDonationsByPhoneNumber(phoneNumber);
            request.setAttribute("donations", donations);
            request.getRequestDispatcher("donor_history.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
