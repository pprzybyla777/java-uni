import java.time.LocalTime;

final public class Meeting extends Event {
    private Priority priority;

    public Meeting(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
        super(description, startTime, endTime);
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }


    @Override
    public String toString() {
        return """
                description: %s,
                start time: %tR,
                end time: %tR,
                priority: %s
                """.formatted(getDescription(), getStartTime(), getEndTime(), priority.toString());
    }
}

enum Priority {
    LOW,
    MEDIUM,
    HIGH
}