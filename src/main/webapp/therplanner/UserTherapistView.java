package therplanner;

import java.util.List;

public class UserTherapistView {
    private User user;
    private Therapist therapist;
    private List<Therapist> availableTherapists;

    public UserTherapistView(User user, Therapist therapist, List<Therapist> availableTherapists) {
        this.user = user;
        this.therapist = therapist;
        this.availableTherapists = availableTherapists;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Therapist getTherapist() {
        return therapist;
    }

    public void setTherapist(Therapist therapist) {
        this.therapist = therapist;
    }

    public List<Therapist> getAvailableTherapists() {
        return availableTherapists;
    }

    public void setAvailableTherapists(List<Therapist> availableTherapists) {
        this.availableTherapists = availableTherapists;
    }
}
