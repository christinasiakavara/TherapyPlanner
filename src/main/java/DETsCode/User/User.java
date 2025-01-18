package DETsCode.User;

public class User {

    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private int userId;

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
    public User(String firstname, String lastname, String email, String username, String password) {
        this(null, firstname, lastname, email, username, password);
    }

    public User(Integer userId, String firstname, String lastname, String email, String username, String password) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(User user) {
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.userId = user.getUserId();
    }

    public User() {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}