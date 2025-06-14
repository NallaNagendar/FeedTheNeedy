import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Organization;
import feedtheneedy.OrganizationDAO;

@WebServlet("/org_profile")
public class OrganizationProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrganizationDAO organizationDAO;

    @Override
    public void init() {
        organizationDAO = new OrganizationDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String organizationId = (String) session.getAttribute("organizationId");

        if (organizationId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Organization organization = organizationDAO.selectOrganizationByOrgId(organizationId);

        if (organization != null) {
            request.setAttribute("organization", organization);
            request.getRequestDispatcher("organisation_profile.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
