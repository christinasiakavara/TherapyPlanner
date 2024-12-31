package DETsCode.Timeslot;

import java.time.LocalDateTime;

public class Timeslot {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public Timeslot(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Timeslot{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    /**
     * Returns true if there is an overlap between the request timeslot and the current (existing) one
     *
     * @param other
     * @return
     */
    public boolean overlaps(Timeslot other) {
        return other.startTime.isBefore(this.endTime) && other.endTime.isAfter(this.startTime);
    }
}
