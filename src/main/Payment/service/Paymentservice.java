package DETsCode.Payment.service;

import java.util.List;

public class Paymentservice {
    private final PaymentDAO paymentDAO;
    public Paymentservice() {
        this.paymentDAO = paymentDAO.getInstance();

    }
    public List<Payment> viewPaymentHistory( int patientID) {
        return paymentDAO.getPaymentsByPatientID(patientID);

    }
    public boolean processPayment(Payment payment) {
        return paymentDAO.addPayment(payment);
    }
}
