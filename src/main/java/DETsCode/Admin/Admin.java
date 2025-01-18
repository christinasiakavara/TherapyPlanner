package DETsCode.Admin;

import DETsCode.User.User;

import java.util.List;

public class Admin extends User {
    private int adminID;
    private List<String> permissions;

    // Κατασκευαστής
    public Admin(String firstname, String lastname, String email, String username, String password, int adminID,
                 List<String> permissions) {
        super(firstname, lastname, email, username, password);
        this.adminID = adminID;
        this.permissions = permissions;
    }

    public Admin() {
    }

    // Getters και Setters
    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", permissions=" + permissions +
                '}';
    }
}