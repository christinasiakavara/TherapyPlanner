package DETsCode.Psychologist;

import DETsCode.User.User;
import DETsCode.db.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PsychologistDAO {

    private final DatabaseConnection conn;
    private static PsychologistDAO instance;//allows for only one instance to be created

    private PsychologistDAO() {
        conn = DatabaseConnection.getInstance();
    }

    public static PsychologistDAO getInstance() {
        if (instance == null) {
            instance = new PsychologistDAO();
        }
        return instance;
    }

    public List<Psychologist> getAvailablePsychologists() {
        try {
            List<Psychologist> psychologists = new ArrayList<>();
            PreparedStatement query = conn.getConnection().prepareStatement("SELECT * FROM therapists WHERE available" +
                    " = " +
                    "1;");
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                int psychologistId = rs.getInt("psychologist_id");
                User user = getUserFromPsychologist(psychologistId);
                Psychologist psychologist = constructPsychologist(rs, user);
                psychologists.add(psychologist);
            }
            rs.close();
            query.close();

            return psychologists;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Psychologist constructPsychologist(ResultSet rs, User user) throws SQLException {
        Psychologist psychologist = new Psychologist(
                user,
                rs.getInt("therapist_id"),
                rs.getString("title"),
                rs.getString("approach"),
                rs.getString("bio"),
                rs.getString("specialties"),
                rs.getString("education"),
                rs.getString("training"),
                rs.getInt("available") == 1, // Explicit boolean conversion
                rs.getString("photo")
        );
        return psychologist;
    }

    private User getUserFromPsychologist(int psychologistId) throws SQLException {
        PreparedStatement usersQuery = conn.getConnection().prepareStatement("SELECT users.* FROM user_therapist" +
                " JOIN therapists ON user_therapist.therapist_id = therapists.therapist_id  " +
                "WHERE user_therapist.therapist_id = ? LIMIT 1");
        usersQuery.setInt(1, psychologistId);
        ResultSet usersSet = usersQuery.executeQuery();
        int id = usersSet.getInt("id");
        String firstName = usersSet.getString("firstName");
        String lastName = usersSet.getString("lastname");
        String username = usersSet.getString("username");
        String email = usersSet.getString("email");
        String password = usersSet.getString("password");
        return new User(id, firstName, lastName, email, username, password);
    }
}
