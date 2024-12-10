package DETsCode.User;

public class User {

    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String number;
    private String address;
    private String birthdate;
    private int userid;
    private int roleID; // 1 = "Psychologist" or 2 = "Client"

    /**
     * Full constuctor
     *
     * @param firstname
     * @param lastname
     * @param email
     * @param username
     * @param password
     * @param number
     */
    public User(String firstname, String lastname, String email, String username, String password, String number, String address, String birthdate, int userid, int roleID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.number = number;
        this.address = address;
        this.birthdate = birthdate;
        this.userid = userid;
        this.roleID = roleID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        if (roleID == 1 || roleID == 2 || roleID == 3) {
            this.roleID = roleID;
        } else {
            throw new IllegalArgumentException("RoleID must be 1 for Psychologist or 2 for Patient or 3 for Admin).");
        }
    }

    //Get role name as String
    public String getRoleName() {
        if (roleID == 1) {
            return "Psychologist";
        } else if (roleID == 2) {
            return "Patient";
        } else if (roleID == 3) {
            return "Admin";
        } else {
            throw new IllegalStateException("Invalid roleID: " + roleID);
        }
    }

}