package DETsCode.Patient.service;

import DETsCode.Patient.PatientDAO;
import DETsCode.Psychologist.Psychologist;
import DETsCode.Psychologist.service.PsychologistService;
import DETsCode.Timeslot.Timeslot;

public class PatientService {

    public final PsychologistService psychologistService;

    public PatientService() {
        this.psychologistService = PsychologistService.getInstance();
    }

    public void selectPsychologist(int psychologistId, int patientId) {
        if (psychologistService.checkExistence(psychologistId)) {
            // save the selected psychologistId using the patientDao
            PatientDAO.getInstance().insertPatientPsychologist(patientId, psychologistId);
        }
    }

    public void bookSession(Timeslot requestedtimeslot, Psychologist psychologist) {
        boolean availability = false;
        for (Timeslot timeslots : psychologist.getAvailability()) {
            if (requestedtimeslot.overlaps(timeslots)) {
                psychologistService.updateAvailability(psychologist, requestedtimeslot);
            }
        }
        if (!availability) {
            throw new IllegalArgumentException("Your requested session overlaps the existing one.");
        }
    }
}
