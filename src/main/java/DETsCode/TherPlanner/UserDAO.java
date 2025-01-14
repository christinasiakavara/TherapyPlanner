package TherPlanner;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
//import AuthenticationException.java;			// Error : cannot find class
import javax.naming.AuthenticationException;	// Is this the correct class?

/**
 * UserService provides all the necessary methods related to users.
 * In future lesson we will change the code in order to provide data from a Database.
 *
 * @version 1.0
 */
public class UserDAO {

    /**
	 * This method returns a List with all Users
	 *
	 * @return List<User>
	 */
	public List<User> getUsers() {

		List<User> users = new ArrayList<User>();

		// adding some users for the sake of the example
		// Error : not all necessary arguments are given
		//users.add(new User("John", "Doe", "jdoe@somewhere.com", "jdoe", "1111"));
		//users.add(new User("Mary", "Smith", "msmith@somewhere.com", "msmith",  "2222"));
        //users.add(new User("Bob", "Jakson", "bjakson@somewhere.com", "bjakson",  "3333"));

		return users;

	} //End of getUsers

    /**
	 * This method is used to authenticate a user.
	 *
	 * @param username, String the username
	 * @param password, String the password
	 * @return User, the User Object
	 * @throws Exception, if the credentials are not valid or an error occurs.
	 */
    public User authenticate(String username, String password) throws AuthenticationException, NoSuchAlgorithmException {

        List<User> users = getUsers();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(/*hashPassword*/(password))) {	// Error : cannot find hashPassword
                return user; // credentials are valid, so return the User object
            }
        }

        throw new AuthenticationException("Invalid username or password. Please try again."); //credentials are Wrong, so throw an error
    } // End of authenticate


} //End of class


