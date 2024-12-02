package therapyplanner;
import java.util.List;
    public class Patient extends User {
        private String medicalHistory ;
        private int patiendid ;
        private List<TherapySession> currentSessions;
        public Patient(String firstname, String lastname, String email, String username, String password, String number,String address, String birthdate, String medicalHistory, int patiendid, List <TherapySession> currentSessions) {
            super (firstname,lastname,email,username,password,number,address,birthdate) ;
            this.medicalHistory = medicalHistory ;
            this.patiendid = patiendid ;
            this.currentSessions = currentSessions;
        }
        public void setMedicalHistory(String medicalHistory) {
            this.medicalHistory = medicalHistory;
        }
        public  String getMedicalHistory() {
            return medicalHistory;
        }
        public  void setPatiendid(int patiendid) {
            this.patiendid = patiendid ;
        }
        public int getPatiendid() {
            return patiendid ;
        }
    
        public List<TherapySession> getCurrentSessions() {
        return this.currentSessions;
        }
        public void setCurrentSessions(List<TherapySession> currentSessions) {
        this.currentSessions = currentSessions;
         }

    @Override
    public String toString() {
        return "{" +
            " medicalHistory='" + getMedicalHistory() + "'" +
            ", patiendid='" + getPatiendid() + "'" +
            ", currentSessions='" + getCurrentSessions() + "'" +
            "}";
    }

        
    }

