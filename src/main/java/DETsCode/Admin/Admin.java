package DETsCode.Admin;

import java.util.List;

import DETsCode.User.User;

public class Admin  extends User{
    private int adminID;
    private List<String> permissions;

    // Κατασκευαστής
    public Admin(String firstname, String lastname, String email, String username, String password, String number, String address, String birthdate, int userid, int roleID,int adminID, List<String> permissions) {
        super(firstname, lastname, email, username, password, number, address, birthdate, userid, roleID);
        this.adminID = adminID;
        this.permissions = permissions;
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
        return "{" +
            " adminID='" + getAdminID() + "'" +
            ", permissions='" + getPermissions() + "'" +
            "}";
    }

}