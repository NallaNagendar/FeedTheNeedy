package feedtheneedy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Organization;

public class OrganizationDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/feedtheneedy";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    // JDBC SQL Queries
    private static final String INSERT_ORG_SQL = "INSERT INTO organizations (org_name, owner_name, organization_id, state, district, city, street, pin_code, phone_number, email, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ORG_BY_ID = "SELECT * FROM organizations WHERE id = ?;";
    private static final String SELECT_ORG_BY_ORG_ID = "SELECT * FROM organizations WHERE organization_id = ?;";
    private static final String SELECT_ALL_ORGS = "SELECT * FROM organizations;";
    private static final String DELETE_ORG_SQL = "DELETE FROM organizations WHERE id = ?;";
    private static final String UPDATE_ORG_SQL = "UPDATE organizations SET org_name = ?, owner_name = ?, organization_id = ?, state = ?, district = ?, city = ?, street = ?, pin_code = ?, phone_number = ?, email = ?, password = ? WHERE id = ?;";

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

    // Insert an Organization into the database
    public void insertOrganization(Organization organization) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORG_SQL)) {
            preparedStatement.setString(1, organization.getOrgName());
            preparedStatement.setString(2, organization.getOwnerName());
            preparedStatement.setString(3, organization.getOrganizationId());
            preparedStatement.setString(4, organization.getState());
            preparedStatement.setString(5, organization.getDistrict());
            preparedStatement.setString(6, organization.getCity());
            preparedStatement.setString(7, organization.getStreet());
            preparedStatement.setString(8, organization.getPinCode());
            preparedStatement.setString(9, organization.getPhoneNumber());
            preparedStatement.setString(10, organization.getEmail());
            preparedStatement.setString(11, organization.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Select an organization by ID
    public Organization selectOrganizationById(int id) {
        Organization organization = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORG_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String orgName = rs.getString("org_name");
                String ownerName = rs.getString("owner_name");
                String organizationId = rs.getString("organization_id");
                String state = rs.getString("state");
                String district = rs.getString("district");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String pinCode = rs.getString("pin_code");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String password = rs.getString("password");
                
                organization = new Organization(id, orgName, ownerName, organizationId, state, district, city, street, pinCode, phoneNumber, email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return organization;
    }

    // Select an organization by organization_id
    public Organization selectOrganizationByOrgId(String organizationId) {
        Organization organization = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORG_BY_ORG_ID)) {
            preparedStatement.setString(1, organizationId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String orgName = rs.getString("org_name");
                String ownerName = rs.getString("owner_name");
                String state = rs.getString("state");
                String district = rs.getString("district");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String pinCode = rs.getString("pin_code");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String password = rs.getString("password");
                
                organization = new Organization(id, orgName, ownerName, organizationId, state, district, city, street, pinCode, phoneNumber, email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return organization;
    }

    // Select all organizations
    public List<Organization> selectAllOrganizations() {
        List<Organization> organizations = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORGS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String orgName = rs.getString("org_name");
                String ownerName = rs.getString("owner_name");
                String organizationId = rs.getString("organization_id");
                String state = rs.getString("state");
                String district = rs.getString("district");
                String city = rs.getString("city");
                String street = rs.getString("street");
                String pinCode = rs.getString("pin_code");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String password = rs.getString("password");
                
                organizations.add(new Organization(id, orgName, ownerName, organizationId, state, district, city, street, pinCode, phoneNumber, email, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return organizations;
    }

    // Delete an organization by ID
    public boolean deleteOrganization(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORG_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    // Update an organization's details
    public boolean updateOrganization(Organization organization) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORG_SQL)) {
            preparedStatement.setString(1, organization.getOrgName());
            preparedStatement.setString(2, organization.getOwnerName());
            preparedStatement.setString(3, organization.getOrganizationId());
            preparedStatement.setString(4, organization.getState());
            preparedStatement.setString(5, organization.getDistrict());
            preparedStatement.setString(6, organization.getCity());
            preparedStatement.setString(7, organization.getStreet());
            preparedStatement.setString(8, organization.getPinCode());
            preparedStatement.setString(9, organization.getPhoneNumber());
            preparedStatement.setString(10, organization.getEmail());
            preparedStatement.setString(11, organization.getPassword());
            preparedStatement.setInt(12, organization.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
