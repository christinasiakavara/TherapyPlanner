package DETsCode.Psychologist;

import DETsCode.Timeslot.Timeslot;
import DETsCode.User.User;

import java.util.ArrayList;
import java.util.List;

public class Psychologist extends User {
    
    private int psychologistId;
    private String specialization;
    private String bio;
    private List<Timeslot> availability;
    private List<Float> rating;


    public Psychologist(String firstname, String lastname, String email, String username, String password, String number, String address, String birthdate, int userid, int roleID, int psychologistId, List<Float> rating, String bio) {
        super(firstname, lastname, email, username, password, number, address, birthdate, userid, roleID);
        this.bio = bio;
        this.psychologistId = psychologistId;
        this.availability = new ArrayList<>();
        this.rating = rating;
    }

    public int getPsychologistId() {
        return psychologistId;
    }

    public void setPsychologistId(int psychologistId) {
        this.psychologistId = psychologistId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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
                "Bio" + bio
                +
                ", availability=" + availability +
                ", rating=" + rating +
                '}';
    }
}
