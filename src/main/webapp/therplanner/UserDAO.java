package therplanner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * javac -cp "./lib/*;." -d "./build/" ./TherPlanner/*.java --release 8  
 * 
 * @author 
 *
 */
public class UserDAO {
		
	/**
	 * This method returns a List with all Users
	 * 
	 * @return List<User>
	 */
	public List<User> getUsers() throws Exception {

		List<User> userList = new ArrayList<User>();
		DB db = new DB();
		Connection con = null;
		String query = "SELECT * FROM TherPlanner;";

		try {

			con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				
				User user = new User(rs.getInt("id"), 
				rs.getString("firstname"),
				rs.getString("lastname"),
				rs.getString("email"),
				rs.getString("username"),
				rs.getString("password"));

				userList.add(user);

			    rs.close();
			    stmt.close();
			    db.close();
			}

			return userList;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
            try {
                db.close();
            } catch (Exception e) {
                
            }
        }
	} 

	/**
	 * Search user by username
	 * 
	 * @param username, String
	 * @return User, the User object or null
	 * @throws Exception
	 */
	public User findUser(String username) throws Exception {

		DB db = new DB();
		Connection con = null;
		String query = "SELECT * FROM TherPlanner WHERE username=?;";

		try {
            
            con = db.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                rs.close();
                stmt.close();
                db.close();

				return null;
            } else {
				User user = new User(rs.getInt("id"), 
				rs.getString("firstname"),
				rs.getString("lastname"),
				rs.getString("email"),
				rs.getString("username"),
				rs.getString("password"));

                rs.close();
                stmt.close();
                db.close();

                return user;
			}

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                
            }
		}	
	}

	/**
	 * This method is used to authenticate a user.
	 * 
	 * @param username, String
	 * @param password, String
	 * @return User, the User object
	 * @throws Exception, if the credentials are not valid
	 */
	public User authenticate(String username, String password) throws Exception {

		DB db = new DB();
		Connection con = null;
		String query = "SELECT * FROM TherPlanner WHERE username=? AND password=?;";

		try {
				con = db.getConnection();
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, username);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();

				if (!rs.next()) {
						rs.close();
						stmt.close();
						db.close();
						throw new Exception("Wrong username or password");
				}

				User user = new User(
		rs.getInt("id"), 
    rs.getString("firstname"),
    rs.getString("lastname"),
    rs.getString("email"),
    rs.getString("username"),
    rs.getString("password")
	);
				

				rs.close();
				stmt.close();
				db.close();

				return user;

		} catch (Exception e) {
				throw new Exception(e.getMessage());
		} finally {
				try {
						db.close();
				} catch (Exception e) {
						// Log the exception if needed
				}
		}
}

	
	/**
	 * Register/create new User.
	 * 
	 * @param user, User
	 * @throws Exception, if encounter any error.
	 */
	public void register(User user) throws Exception {

		DB db = new DB();
		Connection con = null;
		String query = "SELECT * FROM TherPlanner WHERE username=? AND email=?;";

		try {
            
            con = db.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getEmail());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                rs.close();
                stmt.close();
                db.close();
                throw new Exception("Sorry, username or email already registered");
            } else {

							String query1 = "INSERT INTO TherPlanner (username, firstname, lastname, email, password) VALUES (?, ?, ?, ?, ?);";
							PreparedStatement stmt1 = con.prepareStatement(query1);
				 stmt1.setString(1, user.getUsername());
				 stmt1.setString(2, user.getFirstname());
			    stmt1.setString(3, user.getLastname());
				stmt1.setString(4, user.getEmail());
			    stmt1.setString(5, user.getPassword());
				stmt1.executeUpdate();

                stmt1.close();

                rs.close();
                stmt.close();
                db.close();
			}

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                
            }
		}
	}



	public Therapist getAssignedTherapist(int userId) throws Exception {

    DB db = new DB();
    Connection con = null;
    String query = "SELECT therapists.* FROM user_therapist " +
                   "JOIN therapists ON user_therapist.therapist_id = therapists.therapist_id " +
                   "WHERE user_therapist.user_id = ? AND therapists.available = 1 LIMIT 1;";

    try {
        con = db.getConnection();
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {
            rs.close();
            stmt.close();
            db.close();

            return null;
        } else {
            boolean isAvailable = rs.getInt("available") == 1;

            Therapist therapist = new Therapist(
                rs.getInt("therapist_id"),
                rs.getString("name"),
                rs.getString("last_name"),
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
            db.close();

            return therapist;
        }

    } catch (Exception e) {
        throw new Exception("Error fetching assigned therapist: " + e.getMessage(), e);
    } finally {
        try {
            db.close();
        } catch (Exception e) {
            // Log or handle the error during connection close if necessary
        }
    }
}

public List<Therapist> getAvailableTherapists() throws Exception {

	List<Therapist> therapistList = new ArrayList<>();
	DB db = new DB();
	Connection con = null;
	String query = "SELECT * FROM therapists WHERE available = 1;";

	try {
			con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
					Therapist therapist = new Therapist(
							rs.getInt("therapist_id"),
							rs.getString("name"),
							rs.getString("last_name"),
							rs.getString("title"),
							rs.getString("approach"),
							rs.getString("bio"),
							rs.getString("specialties"),
							rs.getString("education"),
							rs.getString("training"),
							rs.getInt("available") == 1, // Explicit boolean conversion
							rs.getString("photo")
					);

					therapistList.add(therapist);
			}

			rs.close();
			stmt.close();
			db.close();

			return therapistList;

	} catch (Exception e) {
			throw new Exception("Error fetching available therapists: " + e.getMessage(), e);
	} finally {
			try {
					db.close();
			} catch (Exception e) {
					// Log or handle the exception during connection close
			}
	}
}



public UserTherapistView loginUser(String username, String password) throws Exception {
	User user = authenticate(username, password); // Authenticate user
	if (user == null) {
			throw new Exception("Invalid username or password.");
	}

	Therapist therapist = getAssignedTherapist(user.getId());
	if (therapist != null) {
			// Returning user with assigned therapist
			return new UserTherapistView(user, therapist, null);
	} else {
			// New user: show available therapists
			List<Therapist> availableTherapists = getAvailableTherapists();
			return new UserTherapistView(user, null, availableTherapists);
	}
}

public void addSession(Session session) throws Exception {
	String query = "INSERT INTO sessions (therapist_id, user_id, status, session_date) VALUES (?, ?, ?, ?)";

	try (Connection con = new DB().getConnection();
			 PreparedStatement stmt = con.prepareStatement(query)) {

			stmt.setInt(1, session.getTherapistId());
			stmt.setInt(2, session.getUserId());
			stmt.setString(3, session.getStatus());
			stmt.setDate(4, new java.sql.Date(session.getSessionDate().getTime()));

			stmt.executeUpdate();
	} catch (SQLException e) {
			throw new Exception("Error adding session: " + e.getMessage(), e);
	}
}

public List<Session> getSessionsForUser(int userId) throws Exception {
	String query = "SELECT * FROM sessions WHERE user_id = ?";
	List<Session> sessions = new ArrayList<Session>();

	try (Connection con = new DB().getConnection();
			 PreparedStatement stmt = con.prepareStatement(query)) {

			stmt.setInt(1, userId);

			try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
							sessions.add(new Session(
									rs.getInt("session_id"),
									rs.getInt("therapist_id"),
									rs.getInt("user_id"),
									rs.getString("status"),
									rs.getDate("session_date")
							));
					}
			}
	} catch (SQLException e) {
			throw new Exception("Error fetching sessions: " + e.getMessage(), e);
	}

	return sessions;
}

public void updateSessionStatus(int sessionId, String status) throws Exception {
	String query = "UPDATE sessions SET status = ? WHERE session_id = ?";

	try (Connection con = new DB().getConnection();
			 PreparedStatement stmt = con.prepareStatement(query)) {

			stmt.setString(1, status);
			stmt.setInt(2, sessionId);

			stmt.executeUpdate();
	} catch (SQLException e) {
			throw new Exception("Error updating session status: " + e.getMessage(), e);
	}
}

public void deleteSession(int sessionId) throws Exception {
	String query = "DELETE FROM sessions WHERE session_id = ?";

	try (Connection con = new DB().getConnection();
			 PreparedStatement stmt = con.prepareStatement(query)) {

			stmt.setInt(1, sessionId);

			stmt.executeUpdate();
	} catch (SQLException e) {
			throw new Exception("Error deleting session: " + e.getMessage(), e);
	}
}



} //End of class





