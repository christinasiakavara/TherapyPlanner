package DETsCode.Payment;

import DETsCode.db.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class PaymentDao{
    private final DatabaseConnection conn;
    private static PaymentDao instance;

    private PaymentDao() {
        conn = DatabaseConnection.getInstance();
    }

    public static PaymentDao getInstance() {
        if (instance == null) {
            instance = new PaymentDao();
        }
        return instance;
    }
    public List<Payment> getPayment() throws Exception {
        List <Payment> payments = new ArrayList<Payment>();
        try {
            PreparedStatement query = conn.getConnection().prepareStatement("SELECT * FROM payment;");
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
               int paymentid = rs.getInt("paymentID");
               float amount = rs.getFloat("amount");
               LocalDateTime paymentdate = rs.getTimestamp("paymentDate").toLocalDateTime();
               int sessionid = rs.getInt("sessionid");
               int patientid = rs.getInt("patientid");
               Payment payment = new Payment(paymentid,amount,paymentdate,sessionid,patientid);
               payments.add(payment);
                  
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    
    }
    public List<Payment> getPaymentsBySessionIDPatientID(int sessionID,int patientid) {
        List<Payment> payments = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getConnection().prepareStatement("SELECT * FROM Payment WHERE sessionID = ? and patientid=?");
            stmt.setInt(1,sessionID);
            stmt.setInt(2,patientid);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Payment payment = new Payment(
                        rs.getInt("paymentID"),
                        rs.getFloat("amount"),
                        rs.getTimestamp("paymentDate").toLocalDateTime(),
                        rs.getInt("patientid"),
                        rs.getInt("sessionID")
                );
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
    public List<Payment> getPaymentsByPatientID(int patiendid) {
        List<Payment> payments = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.getConnection().prepareStatement("SELECT * FROM Payment WHERE patientid=?");
            stmt.setInt(1,patiendid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment(
                        rs.getInt("paymentID"),
                        rs.getFloat("amount"),
                        rs.getTimestamp("paymentDate").toLocalDateTime(),
                        rs.getInt("patiendid"),
                        rs.getInt("sessionID")
                );
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

        public boolean addPayment(Payment payment) {
            try {
                String query = "INSERT INTO Payment (paymentid,amount, paymentDate, sessionID,patientid) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.getConnection().prepareStatement(query);
                stmt.setInt(1, payment.getPaymendid());
                stmt.setFloat(2, payment.getAmmount());
                stmt.setTimestamp(3, java.sql.Timestamp.valueOf(payment.getPaymentDate()));
                stmt.setInt(4, payment.getSessionID());
                stmt.setInt(5, payment.getPatientid());

    
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
}

