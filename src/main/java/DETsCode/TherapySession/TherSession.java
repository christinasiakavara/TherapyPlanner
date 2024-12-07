package main.java.DETsCode.TherapySession;

import DETsCode.Patient.Patient;
import DETsCode.Psychologist.Psychologist;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TherSession {
    private int sessionID;
    private Patient patient;
    private Psychologist psychologist;
    private LocalDateTime dateTime;

     // Δημιουργία formatter για την ημερομηνία
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public TherSession(int sessionID, Patient patient, Psychologist psychologist, LocalDateTime dateTime) {
        this.sessionID = sessionID;
        this.patient = patient;
        this.psychologist = psychologist;
        this.dateTime = dateTime;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Psychologist getPsychologist() {
        return psychologist;
    }

    public void setPsychologist(Psychologist psychologist) {
        this.psychologist = psychologist;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getFormattedDateTime() {
        return dateTime.format(formatter);
    }

    @Override
    public String toString() {
        return "TherSession{" +
                "sessionID=" + sessionID +
                ", dateTime=" + getFormattedDateTime() +
                ", patient=" + (patient != null ? patient.toString() : "No patient assigned") +
                ", psychologist=" + (psychologist != null ? psychologist.toString() : "No psychologist assigned") +
                '}';
    }

}
