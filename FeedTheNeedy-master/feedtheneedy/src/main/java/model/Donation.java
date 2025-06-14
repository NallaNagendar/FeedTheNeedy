package model;

public class Donation {
    private String donorName;
    private String donation;
    private String phone;
    private String city;
    private String street;
    private String dist;
    private String state;
    private String pincode;
    private String email;
    private int id;
    private String item;
    private int quantity;
    private String status; // New status attribute

    // Constructor with all fields
    public Donation(String donorName, String item, int quantity, String donation, String phone, String city, 
                    String street, String dist, String state, String pincode, String email, String status, int id) {
        this.donorName = donorName;
        this.donation = donation;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.dist = dist;
        this.state = state;
        this.pincode = pincode;
        this.email = email;
        this.item = item;
        this.quantity = quantity;
        this.status = status; // Initialize status
        this.id = id; // Initialize id
    }

    // Constructor without id for easier creation
    public Donation(String donorName, String item, int quantity, String donation, String phone, String city, 
                    String street, String dist, String state, String pincode, String email, String status) {
        this(donorName, item, quantity, donation, phone, city, street, dist, state, pincode, email, status, 0); // Default id to 0
    }

    // Getters and Setters
    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonation() {
        return donation;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getStatus() {
        return status; // Getter for status
    }

    public void setStatus(String status) {
        this.status = status; // Setter for status
    }
}
