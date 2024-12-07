package DETsCode.Psychologist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DETsCode.db.DatabaseConnection;

public class PsychologistDAO {

    private DatabaseConnection conn;
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

    public List<Psychologist> getAll() {
        List<Psychologist> psychologists = new ArrayList<>();
        try {
            PreparedStatement query = conn.getConnection().prepareStatement("SELECT * FROM Psychologists;");
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                Psychologist psychologist = new Psychologist(rs.getString("first_name"),
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
                        rs.getString("specialization"),
                        null,
                        rs.getString("bio"));
                psychologists.add(psychologist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return psychologists;
    }
}
