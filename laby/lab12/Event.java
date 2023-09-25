import java.time.LocalTime;

sealed public abstract class Event permits Meeting, Task {

    public static final LocalTime EVENT_START_FROM = LocalTime.of(8, 0);

    private String description;
    private LocalTime startTime;
    private LocalTime endTime;

    public Event(String description, LocalTime startTime, LocalTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDescription() { return description; }
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
               """.formatted(getDescription(), getStartTime(), getEndTime());
    }


}
