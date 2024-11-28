package therapyplanner;
import java.util.List;
public class Patient extends User {
    private String medicalHistory ;
    private int patiendid ;
    private List<TherapySession> currentSessions;
    public Patient(String firstname, String lastname, String email, String username, String password, String number,String address, String birthdate, String medicalHistory, int patiendid) {
        super (firstname,lastname,email,username,password,number,address,birthdate) ;
        this.medicalHistory = medicalHistory ;
        this.patiendid = patiendid ;
    }
    public setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
    public getMedicalHistory() {
        return medicalHistory;
    }
    public setPatiendid(int patiendid) {
        this.patiendid = patiendid ;
    }
    public getPatiendid() {
        return patiendid ;
    }
}
