package model;

public class Organization {
    private int id;  // Primary key with auto-increment
    private String orgName;  // Organization's name
    private String ownerName;  // Owner's name
    private String organizationId;  // Unique organization ID
    private String state;  // State of the organization
    private String district;  // District of the organization
    private String city;  // City of the organization
    private String street;  // Street address of the organization
    private String pinCode;  // Postal code (Pin code) of the organization
    private String phoneNumber;  // Contact number
    private String email;  // Email address (must be unique)
    private String password;  // Password for login

    // Default constructor
    public Organization() {}

    // Parameterized constructor
    public Organization(int id, String orgName, String ownerName, String organizationId, String state,
                        String district, String city, String street, String pinCode,
                        String phoneNumber, String email, String password) {
        this.id = id;
        this.orgName = orgName;
        this.ownerName = ownerName;
        this.organizationId = organizationId;
        this.state = state;
        this.district = district;
        this.city = city;
        this.street = street;
        this.pinCode = pinCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    // Getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Organization [id=" + id + ", orgName=" + orgName + ", ownerName=" + ownerName +
               ", organizationId=" + organizationId + ", state=" + state + ", district=" + district +
               ", city=" + city + ", street=" + street + ", pinCode=" + pinCode +
               ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
    }
}
