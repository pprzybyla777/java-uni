import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

public class Calendar {

    private final HashMap<Integer, ArrayList<Event>> calendar = new HashMap<Integer, ArrayList<Event>>();

    public Calendar() {
        this(7);
    }

    public Calendar(int days) {
        for (int i = 1; i <= days; i++) {
            calendar.put(i, new ArrayList<>());
        }
    }

    public int addMeeting(Meeting meeting, int numOfTheDay) {

        if (meeting.getStartTime().isBefore(Meeting.EVENT_START_FROM)) {
            return -1;
        }

        if (meeting.getEndTime().isBefore(meeting.getStartTime())) {
            return -2;
        }

        ArrayList<Event> dayToUpdate = calendar.get(numOfTheDay);

        if (dayToUpdate == null) {
            return -3;
        }

        dayToUpdate.add(meeting);

        calendar.put(numOfTheDay, dayToUpdate);

        return 0;
    }

    public int addTask(Task task, int numOfTheDay) {

        if (task.getStartTime().isBefore(Task.EVENT_START_FROM)) {
            return -1;
        }

        if (task.getEndTime().isBefore(task.getStartTime())) {
            return -2;
        }

        ArrayList<Event> dayToUpdate = calendar.get(numOfTheDay);

        if (dayToUpdate == null) {
            return -3;
        }

        dayToUpdate.add(task);

        calendar.put(numOfTheDay, dayToUpdate);

        return 0;

    }


    public int removeEvent(int index, int numOfTheDay) {

        ArrayList<Event> dayToUpdate = calendar.get(numOfTheDay);

        if (dayToUpdate == null) {
            return -3;
        }

        if (index < 0 || index >= dayToUpdate.size()) {
            return -1;
        }

        dayToUpdate.remove(index);

        return 0;
    }

    public ArrayList<Event> getEvents(int numOfTheDay, Predicate<Event> checkConditions) {

        ArrayList<Event> result = new ArrayList<>();

        ArrayList<Event> events = calendar.get(numOfTheDay);

        if (events == null) {
            return new ArrayList<>();
        }

        for (Event event : events) {

            if (checkConditions.test(event)) {
                result.add(event);
            }

        }

        return result;
    }

}