import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

public class Calendar {

    private final HashMap<Integer, ArrayList<Meeting>> calendar = new HashMap<Integer, ArrayList<Meeting>>();

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

        ArrayList<Meeting> dayToUpdate = calendar.get(numOfTheDay);

        if (dayToUpdate == null) {
            return -3;
        }

        dayToUpdate.add(meeting);

        calendar.put(numOfTheDay, dayToUpdate);

        return 0;
    }

    public int removeMeeting(int index, int numOfTheDay) {

        ArrayList<Meeting> dayToUpdate = calendar.get(numOfTheDay);

        if (dayToUpdate == null) {
            return -3;
        }

        if (index < 0 || index >= dayToUpdate.size()) {
            return -1;
        }

        dayToUpdate.remove(index);

        return 0;
    }

    public ArrayList<Meeting> getMeetings(int numOfTheDay, Predicate<Meeting> checkConditions) {

        ArrayList<Meeting> result = new ArrayList<>();
        ArrayList<Meeting> meetings = calendar.get(numOfTheDay);

        if (meetings == null) {
            return new ArrayList<>();
        }

        for (Meeting meeting : meetings) {

            if (checkConditions.test(meeting)) {
                result.add(meeting);
            }

        }

        return result;
    }

}