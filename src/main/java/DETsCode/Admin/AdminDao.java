package DETsCode.Admin;

import DETsCode.db.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    private final DatabaseConnection conn;
    private static AdminDao instance;

    private AdminDao() {
        conn = DatabaseConnection.getInstance();
    }

    public static AdminDao getInstance() {
        if (instance == null) {
            instance = new AdminDao();
        }
        return instance;
    }

    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        try {
            String query = "SELECT * FROM admin";
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                String email = rs.getString("email");
                String username = rs.getString("username");
                int adminID = rs.getInt("adminid");
                String permission = rs.getString("permissions");
                List<String> permissions = List.of(permission.split(","));
                admins.add(new Admin(firstname, lastname, email, username, null, adminID, permissions));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public boolean addAdmin(Admin admin) {
        try {
            String query = "INSERT INTO admin (firstname, lastname, email, username, password, number, address, " +
                    "birthdate, userid, roleID, adminID, permissions) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            stmt.setString(1, admin.getFirstname());
            stmt.setString(2, admin.getLastname());
            stmt.setString(3, admin.getEmail());
            stmt.setString(4, admin.getUsername());
            stmt.setString(5, admin.getPassword());
            stmt.setInt(1, admin.getAdminID());
            stmt.setString(2, String.join(",", admin.getPermissions()));

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
