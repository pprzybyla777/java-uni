import java.time.LocalTime;

final public class Task extends Event {

    private Status status;

    public Task(String description, LocalTime startTime, LocalTime endTime, Status status) {
        super(description, startTime, endTime);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return """
                description: %s,
                start time: %tR,
                end time: %tR,
                status: %s
                """.formatted(getDescription(), getStartTime(), getEndTime(), status.toString());
    }
}


enum Status {
    PLANNING,
    APPROVED,
    IN_PROGRESS,
    EXECUTED
}