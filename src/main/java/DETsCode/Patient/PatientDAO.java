package DETsCode.Patient;

import DETsCode.Payment.PaymentDao;
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

    public static PaymentDao getInstance() {
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
                Patient patient = new Patient(rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("username"),
                        null,
                        rs.getString("number"),
                        rs.getString("address"),
                        rs.getString("birthdate"),
                        rs.getInt("user_id"),
                        rs.getInt("role"),
                        rs.getString("medical_history"),
                        rs.getInt("id"),
                        null);
                patients.add(patient);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;

    }

    public boolean insertpatient(Patient patient) {
        try {
            PreparedStatement stmt = conn.getConnection().prepareStatement("INSERT INTO patient(firstname, lastname, email, username, password, number, address, birthdate, userid, roleID, medicalHistory, patiendid, currentSessions) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, patient.getFirstname());
            stmt.setString(2, patient.getLastname());
            stmt.setString(3, patient.getEmail());
            stmt.setString(4, patient.getUsername());
            stmt.setString(5, patient.getPassword());
            stmt.setString(6, patient.getNumber());
            stmt.setString(7, patient.getAddress());
            stmt.setString(8, patient.getBirthdate());
            stmt.setInt(9, patient.getUserid());
            stmt.setInt(10, patient.getRoleID());
            stmt.setString(11, patient.getMedicalHistory());
            stmt.setInt(12, patient.getPatiendid());
//            stmt.setNull(13,); //???
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
