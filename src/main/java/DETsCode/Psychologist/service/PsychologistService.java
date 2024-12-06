package DETsCode.Psychologist.service;

import DETsCode.Psychologist.Psychologist;
import DETsCode.Timeslot.Timeslot;
import java.util.List;
import java.util.ArrayList;

public class PsychologistService {

    private List<String> notes = new ArrayList<>();


    /**
     * Validates if the provided timeslot is available and adds it to the list of timeslots
     * of the psychologist
     *
     * @param psychologist
     * @param timeslot
     */
    void updateAvailability(Psychologist psychologist, Timeslot timeslot) {
        if (!validateTimeslot(psychologist, timeslot)) {
            throw new IllegalArgumentException("The timeslot requested ( " + timeslot.toString() + ")overlaps the existing timeslots of the psychologist");
        }
        psychologist.getAvailability().add(timeslot);
    }

    void viewAppointments(Psychologist psychologist) {
        psychologist.getAvailability().forEach(System.out::println);
    }

    private boolean validateTimeslot(Psychologist psychologist, Timeslot timeslot) {
        for (Timeslot existingTimeslot : psychologist.getAvailability()) {
            if (existingTimeslot.overlaps(timeslot)) {
                return false;
            }
        }
        return true;
    }

    private void addnotes(String note) {
        if (note == null) {
            System.out.println("Note cannot be null");
        }
        notes.add(note);
        System.out.println("Note added successfully" + note);

    }
}
