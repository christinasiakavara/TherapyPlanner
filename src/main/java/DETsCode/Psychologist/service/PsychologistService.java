package DETsCode.Psychologist.service;

import DETsCode.Psychologist.Psychologist;
import DETsCode.Timeslot.Timeslot;
import java.util.List;
import java.util.ArrayList;

public class PsychologistService {

    private static PsychologistService instance;

    public static PsychologistService getInstance() {
        if (instance == null) {
            return new PsychologistService();
        }
        return instance;
    }


    private List<String> notes = new ArrayList<>();

    /**
     * Validates if the provided timeslot is available and adds it to the list of timeslots
     * of the psychologist
     *
     * @param psychologist
     * @param timeslot
     */
    public void updateAvailability(Psychologist psychologist, Timeslot timeslot) {
        if (!validateTimeslot(psychologist, timeslot)) {
            throw new IllegalArgumentException("The timeslot requested ( " + timeslot.toString() + ")overlaps the existing timeslots of the psychologist");
        }
        psychologist.getAvailability().add(timeslot);
    }

    public void viewAppointments(Psychologist psychologist) {
        psychologist.getAvailability().forEach(System.out::println);
    }

    public List<Psychologist> fetchPsychologists() {
        // TODO: get all psychologists from psychologistDao
        throw new UnsupportedOperationException("Not supported yet.");
    }


    private boolean validateTimeslot(Psychologist psychologist, Timeslot timeslot) {
        for (Timeslot existingTimeslot : psychologist.getAvailability()) {
            if (existingTimeslot.overlaps(timeslot)) {
                return false;
            }
        }
        return true;
    }

    private void addNotes(String note) {
        if (note == null) {
            System.out.println("Note cannot be null");
        }
        notes.add(note);
        System.out.println("Note added successfully" + note);

    }

    public void checkExistence(int psychologistId) {
        //check in the psychologistDao if the provided psychologistId corresponds to a psychologist
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
