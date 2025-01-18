package DETsCode.Psychologist;

import DETsCode.Timeslot.Timeslot;
import DETsCode.Timeslot.TimeslotDAO;
import DETsCode.User.User;

import java.util.List;

public class Psychologist extends User {

    private int psychologistId;
    private boolean available;
    private String bio;
    private String training;
    private String education;
    private String photo;
    private String approach;
    private String specialties;
    private String title;


    public Psychologist(User user, int psychologistId, String title, String approach, String bio, String specialties,
                        String education, String training, boolean available, String photo) {
        super(user);
        this.psychologistId = psychologistId;
        this.bio = bio;
        this.available = available;
        this.approach = approach;
        this.education = education;
        this.specialties = specialties;
        this.training = training;
        this.photo = photo;
    }

    public Psychologist() {

    }


    public int getPsychologistId() {
        return psychologistId;
    }

    public void setPsychologistId(int psychologistId) {
        this.psychologistId = psychologistId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getApproach() {
        return approach;
    }

    public void setApproach(String approach) {
        this.approach = approach;
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Timeslot> getAvailability() {
        return TimeslotDAO.getInstance().getAvailableTimeslots(this);
    }

    @Override
    public String toString() {
        return "Psychologist{" +
                "psychologistId=" + psychologistId +
                ", available=" + available +
                ", bio='" + bio + '\'' +
                ", training='" + training + '\'' +
                ", education='" + education + '\'' +
                ", photo='" + photo + '\'' +
                ", approach='" + approach + '\'' +
                ", specialties='" + specialties + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
