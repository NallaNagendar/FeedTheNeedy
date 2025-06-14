package feedtheneedy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Donation;

public class DonationDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/feedtheneedy";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String SELECT_DONATIONS_BY_ORG_ID = "SELECT * FROM donations WHERE organization_id = ?";
    private static final String SELECT_DONATIONS_BY_PHONE = "SELECT * FROM donations WHERE phone = ?";
    private static final String UPDATE_DONATION_STATUS_BY_PHONE = "UPDATE donations SET status = ? WHERE phone = ?";

    // Database Connection
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Select donations by organization ID
    public List<Donation> selectDonationsByOrgId(int organizationId) {
        List<Donation> donations = new ArrayList<>();
        try (Connection connection = getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DONATIONS_BY_ORG_ID)) {

            preparedStatement.setInt(1, organizationId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                donations.add(mapRowToDonation(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donations;
    }

    // Select donations by phone number
    public List<Donation> selectDonationsByPhoneNumber(String phoneNumber) {
        List<Donation> donations = new ArrayList<>();
        try (Connection connection = getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DONATIONS_BY_PHONE)) {

            preparedStatement.setString(1, phoneNumber);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                donations.add(mapRowToDonation(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donations;
    }

    // Update donation status by phone number
    public boolean updateDonationStatusByPhone(String phone, String status) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DONATION_STATUS_BY_PHONE)) {

            preparedStatement.setString(1, status); // Set new status
            preparedStatement.setString(2, phone);  // Set phone number

            rowUpdated = preparedStatement.executeUpdate() > 0; // Returns true if a row is updated
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    // Helper method to map ResultSet row to Donation object
 // Helper method to map ResultSet row to Donation object
    private Donation mapRowToDonation(ResultSet rs) throws SQLException {
        String donorName = rs.getString("donor_name");
        String item = rs.getString("item");
        int quantity = rs.getInt("quantity");
        String donation = rs.getString("donation");
        String phone = rs.getString("phone");
        String city = rs.getString("city");
        String street = rs.getString("street");
        String dist = rs.getString("dist");
        String state = rs.getString("state");
        String pincode = rs.getString("pincode");
        String email = rs.getString("email");
        String status = rs.getString("status"); // Add status field

        // Assuming Donation class has a constructor with all the fields, including status.
        return new Donation(donorName, item, quantity, donation, phone, city, street, dist, state, pincode, email, status);
    }

}
