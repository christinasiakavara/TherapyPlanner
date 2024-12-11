package DETsCode.Patient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DETsCode.Patient.Patient;
import DETsCode.db.DatabaseConnection;

public class PatientDAO {

    private DatabaseConnection conn;
    private static PatientDAO instance;//allows for only one instance to be created

    private PatientDAO() {
        conn = DatabaseConnection.getInstance();
    }

    public static PatientDAO getInstance() {
        if (instance == null) {
            synchronized (PatientDAO.class) {
                if (instance == null) {
                    instance = new PatientDAO();
                }
            }
        }
        return instance;
    }    

    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        try {
            PreparedStatement query = conn.getConnection().prepareStatement("SELECT * FROM Patient;");
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient(
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("username"),
                    null,
                    rs.getString("number"),
                    rs.getString("address"),
                    rs.getString("birthdate"),
                    rs.getInt("user_id"),
                    rs.getInt("role"),
                    rs.getInt("id"),
                    null);
                    patients.add(patient);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return patient;
        }
    }
