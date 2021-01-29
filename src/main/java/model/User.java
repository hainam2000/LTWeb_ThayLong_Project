package model;

public class User {
    //region Field
    private int id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private int role;
    private String accountName;
    private String password;
    //endregion
    //region Constructor
    public User() {

    }
    public User(int id, String fullName, String email, String phone, String address, int role, String accountName, String password){
        this.id = id;
        this.role = role;
        this.accountName = accountName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
    }
    //endregion
    //region Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //endregion
    //Function
    
}
