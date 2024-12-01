package DETsCode.Psychologist;

import DETsCode.Timeslot.Timeslot;
import DETsCode.User.User;

import java.util.List;

public class Psychologist extends User {
    private int psychologistId;

    private String specialization;

    private List<Timeslot> availability;

    private List<Float> rating;

    public Psychologist(String firstname, String lastname, String email, String username, String password, String number, String address, String birthdate, int userid, int roleID, int psychologistId, String specialization, List<Timeslot> availability, List<Float> rating) {
        super(firstname, lastname, email, username, password, number, address, birthdate, userid, roleID);
        this.psychologistId = psychologistId;
        this.specialization = specialization;
        this.availability = availability;
        this.rating = rating;
    }

    public int getPsychologistId() {
        return psychologistId;
    }

    public void setPsychologistId(int psychologistId) {
        this.psychologistId = psychologistId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Timeslot> getAvailability() {
        return availability;
    }

    public void setAvailability(List<Timeslot> availability) {
        this.availability = availability;
    }

    public List<Float> getRating() {
        return rating;
    }

    public void setRating(List<Float> rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Psychologist{" +
                "psychologistId=" + psychologistId +
                ", specialization='" + specialization + '\'' +
                ", availability=" + availability +
                ", rating=" + rating +
                '}';
    }
}
