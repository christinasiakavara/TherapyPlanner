package DETsCode.TherapySession;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import DETsCode.Patient.Patient;
import DETsCode.Psychologist.Psychologist;

import DETsCode.db.DatabaseConnection;

public class TherSessionDAO {

    private DatabaseConnection conn;

    public TherapySessionDAO() {
        conn = DatabaseConnection.getInstance();
    }

    // Βρες όλα τα sessions
    public List<TherapySession> getAllSessions() {
        List<TherapySession> sessions = new ArrayList<>();
        try {
            String query = "SELECT * FROM TherapySession";
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TherapySession session = new TherapySession(
                        rs.getInt("sessionID"),
                        rs.getTimestamp("sessionDateTime").toLocalDateTime(),
                        rs.getString("details"),
                        rs.getInt("patientID"),
                        rs.getInt("psychologistID")
                );
                sessions.add(session);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessions;
    }

    // Βρες ποιο session με patientID & psychologistID
    public List<TherapySession> getSessionsByPatientID(int patientID) {
        List<TherapySession> sessions = new ArrayList<>();
        try {
            String query = "SELECT * FROM TherapySession WHERE patientID = ?";
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            stmt.setInt(1, patientID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TherapySession session = new TherapySession(
                        rs.getInt("sessionID"),
                        rs.getTimestamp("sessionDateTime").toLocalDateTime(),
                        rs.getString("details"),
                        rs.getInt("patientID"),
                        rs.getInt("psychologistID")
                );
                sessions.add(session);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessions;
    }
    
}

//Λογικά πρέπει κάπως να φτιάξουμε μέθοδο που φτιάχνει ένα session με insert και μια μέθοδο που διαγράφει ένα session (delete)
