package TherPlanner;

public class User {
    
    private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
    private String number;
    private String address;
    private String birthdate;

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
    public User(String firstname, String lastname, String email, String username, String password, String number,String address, String birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.number = number;
        this.address = address;
        this.birthdate = birthdate;

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
    public String setAddress(String address) {
        this.address= address;
    }
    public String getAddress() {
        return address;
    }
    public String setBirthdate( String birthdate) {
        this.birthdate =birthdate;
    }
    public String getBirthdate() {
        return birthdate;
    }
}