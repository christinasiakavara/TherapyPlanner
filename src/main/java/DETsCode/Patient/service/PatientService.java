package DETsCode.Patient.service;

import DETsCode.Psychologist.service.PsychologistService;
import DETsCode.Timeslot.Timeslot;

public class PatientService {

    public final PsychologistService psychologistService;

    public PatientService() {
        this.psychologistService = PsychologistService.getInstance();
    }

    public void selectPsychologist(int psychologistId) {
        psychologistService.checkExistence(psychologistId);
        // save the selected psychologistId using the patientDao 
    }


    public void bookSession(Timeslot timeslot) {
    }

}
