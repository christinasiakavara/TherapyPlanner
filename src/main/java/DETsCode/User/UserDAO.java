package DETsCode.User;


import DETsCode.Psychologist.Psychologist;
import DETsCode.db.DatabaseConnection;

import javax.naming.AuthenticationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * UserService provides all the necessary methods related to users.
 * In future lesson we will change the code in order to provide data from a Database.
 *
 * @version 1.0
 */
public class UserDAO {
    private final DatabaseConnection conn;
    private static UserDAO instance; //allows for only one instance to be created

    private UserDAO() {
        conn = DatabaseConnection.getInstance();
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }


    /**
     * This method returns a List with all Users
     */
    public List<User> getUsers() throws SQLException {


        List<User> users = new ArrayList<>();
        PreparedStatement query = conn.getConnection().prepareStatement("SELECT * FROM users;");

        ResultSet rs = query.executeQuery();
        while (rs.next()) {
            User user = new User(
                    rs.getInt("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("password"));
            users.add(user);
        }
        rs.close();
        return users;
    }


    public Psychologist getPsychologistFromUser(User user) throws SQLException {

        String query = "SELECT therapists.* FROM user_therapist " +
                "JOIN therapists ON user_therapist.therapist_id = therapists.therapist_id " +
                "WHERE user_therapist.user_id = ? AND therapists.available = 1 LIMIT 1;";
        PreparedStatement stmt = conn.getConnection().prepareStatement(query);
        stmt.setInt(1, user.getUserId());
        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {
            rs.close();
            return null;
        } else {
            boolean isAvailable = rs.getInt("available") == 1;
            Psychologist therapist = new Psychologist(
                    user,
                    rs.getInt("therapist_id"),
                    rs.getString("title"),
                    rs.getString("approach"),
                    rs.getString("bio"),
                    rs.getString("specialties"),
                    rs.getString("education"),
                    rs.getString("training"),
                    isAvailable,
                    rs.getString("photo")
            );
            rs.close();
            stmt.close();
            return therapist;
        }
    }

    /**
     * This method is used to authenticate a user.
     *
     * @param username, String the username
     * @param password, String the password
     * @return User, the User Object
     * @throws Exception, if the credentials are not valid or an error occurs.
     */
    public User authenticate(String username, String password) throws AuthenticationException,
            SQLException {

        List<User> users = getUsers();
        Optional<User> userCandidate = users.stream().filter(user -> user.getUsername().equals(username)).findAny();
        if (userCandidate.isEmpty()) {
            throw new AuthenticationException("Invalid username or password. Please try again.");
        }
        User user = userCandidate.get();
        if (!user.getPassword().equals(/*hashPassword*/(password))) {    //
            throw new AuthenticationException("Invalid username or password. Please try again.");
        }
        return user; // credentials are valid, so return the User object
    }


    /**
     * Register/create new User.
     *
     * @param user, User
     * @throws Exception, if encounter any error.
     */
    public void register(User user) throws Exception {
        PreparedStatement stmt = conn.getConnection().prepareStatement("SELECT * FROM TherPlanner WHERE username=? " +
                "AND email=?;");
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            rs.close();
            stmt.close();
            throw new Exception("Sorry, username or email already registered");
        }
        String query1 = "INSERT INTO users (username, firstname, lastname, email, password) VALUES (?, ?, ?, ?," +
                " ?);";
        PreparedStatement stmt1 = conn.getConnection().prepareStatement(query1);
        stmt1.setString(1, user.getUsername());
        stmt1.setString(2, user.getFirstname());
        stmt1.setString(3, user.getLastname());
        stmt1.setString(4, user.getEmail());
        stmt1.setString(5, user.getPassword());
        stmt1.executeUpdate();
        stmt1.close();
        rs.close();
        stmt.close();
    }
}

