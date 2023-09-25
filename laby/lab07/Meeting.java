import java.time.LocalTime;

public class Meeting {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private Priority priority;

    public static final LocalTime MEETING_START_FROM = LocalTime.of(8, 0);

    public Meeting(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return """
                description: %s,
                start time: %tR,
                end time: %tR,
                priority: %s
                """.formatted(description, startTime, endTime, priority.toString());
    }
}

enum Priority {
    LOW,
    MEDIUM,
    HIGH
}