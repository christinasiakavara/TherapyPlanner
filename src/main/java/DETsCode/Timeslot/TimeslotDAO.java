package DETsCode.Timeslot;

import DETsCode.Psychologist.Psychologist;
import DETsCode.db.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimeslotDAO {

    private final DatabaseConnection conn;
    private static TimeslotDAO instance;//allows for only one instance to be created

    private TimeslotDAO() {
        conn = DatabaseConnection.getInstance();
    }

    public static TimeslotDAO getInstance() {
        if (instance == null) {
            instance = new TimeslotDAO();
        }
        return instance;
    }

    public List<Timeslot> getAvailableTimeslots(Psychologist psychologist) {
        try {
            PreparedStatement query = conn.getConnection().prepareStatement("SELECT * FROM timeslots WHERE " +
                    "therapist_id =" +
                    " ?");
            ResultSet rs = query.executeQuery();
            ArrayList<Timeslot> timeslots = new ArrayList<>();
            while (rs.next()) {
                LocalDateTime startDate = rs.getObject("start_date", LocalDateTime.class);
                LocalDateTime endDate = rs.getObject("end_date", LocalDateTime.class);
                timeslots.add(new Timeslot(startDate, endDate));
            }
            rs.close();
            query.close();
            return timeslots;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addTimeslot(Psychologist psychologist, Timeslot timeslot) throws SQLException {
        PreparedStatement query = conn.getConnection().prepareStatement("INSERT INTO timeslots VALUES (?,?,?)");
        query.setObject(1, timeslot.getStartTime());
        query.setObject(2, timeslot.getEndTime());
        query.setObject(3, psychologist.getPsychologistId());
        ResultSet rs = query.executeQuery();
        query.close();
    }

}
