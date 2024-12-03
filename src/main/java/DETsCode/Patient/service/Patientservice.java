package DETsCode.Patient.service;
import DETsCode.Patient.Patient;
import DETsCode.Psychologist.Psychologist;
import java.util.ArrayList;
import java.util.List;
public class Patientservice {
    private List<Psychologist> PsycologistsList = new ArrayList<>();
    public List<Psychologist> getPsycologistsList() {
        return this.PsycologistsList;
    }

    public void setPsycologistsList(List<Psychologist> PsycologistsList) {
        this.PsycologistsList = PsycologistsList;
    }
    void viewPcycologistsprofiles() {
        getPsycologistsList().forEach(System.out::println);


    }
    
    
}
