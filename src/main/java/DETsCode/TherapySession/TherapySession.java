package DETsCode.TherapySession;

import DETsCode.Patient.Patient;
import DETsCode.Psychologist.Psychologist;
import java.time.LocalDateTime;

public class TherapySession {
    private int sessionId;
    private LocalDateTime dateTime;
    private Patient patient;
    private Psychologist psychologist;
    private String sessionNotes;

    public TherapySession(int sessionId, LocalDateTime dateTime, Patient patient, Psychologist psychologist, String sessionNotes) {
        this.sessionId = sessionId;
        this.dateTime = dateTime;
        this.patient = patient;
        this.psychologist = psychologist;
        this.sessionNotes = sessionNotes;
    }

    public int getSessionId() {
        return sessionId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public Psychologist getPsychologist() {
        return psychologist;
    }

    public String getSessionNotes() {
        return sessionNotes;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setPsychologist(Psychologist psychologist) {
        this.psychologist = psychologist;
    }

    public void setSessionNotes(String sessionNotes) {
        this.sessionNotes = sessionNotes;
    }

    public int startSession() {
        return 1;
    }

    public int cancelSession() {
        return 0;
    }

    public void addSessionNotes(String sessionNotes) {
        this.sessionNotes += sessionNotes;
    }
}