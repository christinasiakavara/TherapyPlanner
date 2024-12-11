package DETsCode.Patient.service;

import DETsCode.Patient.Patient;
import DETsCode.Patient.PatientDAO;
import DETsCode.Psychologist.service.PsychologistService;
import DETsCode.Timeslot.Timeslot;

public class PatientService {

    public final PsychologistService psychologistService;

    public PatientService() {
        this.psychologistService = PsychologistService.getInstance();
    }

    public void selectPsychologist(int psychologistId, int patientId) {
        if (psychologistService.checkExistence(psychologistId) == true);
        // save the selected psychologistId using the patientDao 
        PatientDAO.getInstance().insertPatientPsychologist(patientId, psychologistId);
    }


    public void bookSession(Timeslot timeslot) {
    }

}
