package DETsCode.Patient;

import DETsCode.TherapySession.TherapySession;
import DETsCode.User.User;

import java.util.List;

public class Patient extends User {
    private String medicalHistory;
    private int patientId;
    private List<TherapySession> currentSessions;

    public Patient(int userId, String firstname, String lastname, String email, String username, String password,
                   String medicalHistory, int patientId, List<TherapySession> currentSessions) {
        super(userId, firstname, lastname, email, username, password);
        this.medicalHistory = medicalHistory;
        this.patientId = patientId;
        this.currentSessions = currentSessions;
    }

    public Patient() {
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setPatiendid(int patientId) {
        this.patientId = patientId;
    }

    public int getPatiendid() {
        return patientId;
    }

    public List<TherapySession> getCurrentSessions() {
        return this.currentSessions;
    }

    public void setCurrentSessions(List<TherapySession> currentSessions) {
        this.currentSessions = currentSessions;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "medicalHistory='" + medicalHistory + '\'' +
                ", patientId=" + patientId +
                ", currentSessions=" + currentSessions +
                '}';
    }
}
