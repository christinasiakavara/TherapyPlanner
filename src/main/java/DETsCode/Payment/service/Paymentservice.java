package DETsCode.Payment.service;

import java.util.List;

import DETsCode.Payment.Payment;
import DETsCode.Payment.PaymentDao;

public class Paymentservice {
    private final PaymentDao paymentDAO;
        public Paymentservice() {
            this.paymentDAO = PaymentDao.getInstance();

    }
    public List<Payment> viewPaymentHistory( int patientID) {
        return paymentDAO.getPaymentsByPatientID(patientID);

    }
    public boolean processPayment(Payment payment) {
        return paymentDAO.addPayment(payment);
    }
}
