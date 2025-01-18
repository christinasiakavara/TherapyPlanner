package therplanner;

import java.util.Date;

public class Session {
    private int sessionId;
    private int therapistId;
    private int userId;
    private String status; // "completed" or "pending"
    private Date sessionDate;

    public Session(int sessionId, int therapistId, int userId, String status, Date sessionDate) {
        this.sessionId = sessionId;
        this.therapistId = therapistId;
        this.userId = userId;
        this.status = status;
        this.sessionDate = sessionDate;
    }

    // Getters and Setters
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(int therapistId) {
        this.therapistId = therapistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }
}
