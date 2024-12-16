package DETsCode.Payment;
import java.time.LocalDateTime;
import DETsCode.Patient;
public class Payment {
    private int paymendid;
    private float ammount;
    private LocalDateTime paymentDate;
    private Patient patient;
    private TherapySession therapysession;
    
    public Payment(int id, float ammount, LocalDateTime paymentDate, Patient patient, TherapySession therapysession) {
        this.paymendid = paymendid;
        this.ammount = ammount;
        this.paymentDate = paymentDate;
        this.patient = patient;
        this.therapysession = therapysession;
    }

    public int getPaymendid() {
        return this.paymendid;
    }

    public void setPaymendid(int paymendid) {
        this.paymendid = paymendid;
    }

    public float getAmmount() {
        return this.ammount;
    }

    public void setAmmount(float ammount) {
        this.ammount = ammount;
    }

    public LocalDateTime getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public TherapySession getTherapysession() {
        return this.therapysession;
    }

    public void setTherapysession(TherapySession therapysession) {
        this.therapysession = therapysession;
    }


    @Override
    public String toString() {
        return "{" +
            " paymendid='" + getPaymendid() + "'" +
            ", ammount='" + getAmmount() + "'" +
            ", paymentDate='" + getPaymentDate() + "'" +
            ", patient='" + getPatient() + "'" +
            ", therapysession='" + getTherapysession() + "'" +
            "}";
    }

    

    
}
