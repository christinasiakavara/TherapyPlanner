package DETsCode.Payment;
import java.time.LocalDateTime;
public class Payment {
    private int paymendid;
    private float ammount;
    private LocalDateTime paymentDate;
    private int patientid;
    private int sessionID;

    public Payment(int paymentid, float ammount, LocalDateTime paymentDate,int patiendid,int sessionID ) {
        this.paymendid = paymendid;
        this.ammount = ammount;
        this.paymentDate = paymentDate;
        this.patientid = patiendid;
        this.sessionID = sessionID;
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

    public int getPatientid() {
        return this.patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public int getSessionID() {
        return this.sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    @Override
    public String toString() {
        return "{" +
            " paymendid='" + getPaymendid() + "'" +
            ", ammount='" + getAmmount() + "'" +
            ", paymentDate='" + getPaymentDate() + "'" +
            ", patientid='" + getPatientid() + "'" +
            ", sessionID='" + getSessionID() + "'" +
            "}";
    }

    
}
