package DETsCode.Patient;

import DETsCode.TherapySession.TherapySessionDAO;
import DETsCode.db.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    private final DatabaseConnection conn;
    private static PatientDAO instance;//allows for only one instance to be created

    private PatientDAO() {
        conn = DatabaseConnection.getInstance();
    }

    public static PatientDAO getInstance() {
        if (instance == null) {
            instance = new PatientDAO();
        }
        return instance;
    }

    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        try {
            PreparedStatement query = conn.getConnection().prepareStatement("SELECT * FROM patient;");
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                int patiendid = rs.getInt("id");
                Patient patient = new Patient(
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("username"),
                        null,
                        rs.getString("medical_history"),
                        rs.getInt("id"),
                        TherapySessionDAO.getSessionsByPatientID(patiendid));
                patients.add(patient);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;

    }

    public boolean insertPatient(Patient patient) {
        try {
            PreparedStatement stmt = conn.getConnection().prepareStatement("INSERT INTO patient(firstname, lastname, " +
                    "email, username, password, medicalHistory, " +
                    "patiendid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, patient.getFirstname());
            stmt.setString(2, patient.getLastname());
            stmt.setString(3, patient.getEmail());
            stmt.setString(4, patient.getUsername());
            stmt.setString(5, patient.getPassword());
            stmt.setString(6, patient.getMedicalHistory());
            stmt.setInt(7, patient.getPatiendid());
//            stmt.setInt(8, patient.getCurrentSessions());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void insertPatientPsychologist(int patiendid, int psychologistId) {
        System.out.println("Psychologist with ID " + psychologistId + "assigned to patient " + patiendid);
    }
}
