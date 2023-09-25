import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

    private static void printMenu() {
        System.out.println("1 - add new meeting");
        System.out.println("2 - remove meeting");
        System.out.println("3 - show meetings for the day");
        System.out.println("4 - filter and show meetings for the day by priority");
        System.out.println("5 - show meetings for the day starting at or after given time");
        System.out.println("6 - show Meetings for the day at given data frame");
        System.out.println("7 - show meetings for the day starting at or after given time filtered by priority");
        System.out.println("8 - exit program");
    }

    private static Priority returnPriority(String priority) {

        if (priority.equals("LOW")) {
            return Priority.LOW;
        }
        if (priority.equals("MEDIUM")) {
            return Priority.MEDIUM;
        }
        if (priority.equals("HIGH")) {
            return Priority.HIGH;
        }

        return null; // Exception handling
    }

    private static Meeting createMeeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Description: ");
        String description = scanner.nextLine();


        LocalTime startTime = null;
        boolean invalidInput = true;

        while (invalidInput) {
            try {
                System.out.print("Start time (HH:MM): ");
                startTime = LocalTime.parse(scanner.nextLine());
                invalidInput = false;
            } catch (DateTimeParseException err) {
                System.out.println("Error! Invalid time passed. You have to use HH:MM format.");
            }
        }

        LocalTime endTime = null;
        invalidInput = true;

        while (invalidInput) {
            try {
                System.out.print("End time (HH:MM): ");
                endTime = LocalTime.parse(scanner.nextLine());
                invalidInput = false;
            } catch (DateTimeParseException err) {
                System.out.println("Error! Invalid time passed. You have to use HH:MM format.");
            }
        }

        System.out.print("Priority (LOW, MEDIUM, HIGH): ");
        Priority priority = returnPriority(scanner.nextLine());

        if (priority == null) {
            return null;
        }

        return new Meeting(description, startTime, endTime, priority);
    }

    private static void displayInfoIfMeetingAdded(int result) {
        if (result == 0) {
            System.out.println("Meeting added sucessfully!");
        } else if (result == -1) {
            System.out.println("Error code -1.");
        } else if (result == -2) {
            System.out.println("Error code -2");
        } else {
            System.out.println("Error code -3");
        }
        System.out.println();
    }

    private static void displayInfoIfMeetingRemoved(int result) {
        if (result == 0) {
            System.out.println("Meeting has been removed sucessfully!");
        } else if (result == -1) {
            System.out.println("Error code -1.");
        } else {
            System.out.println("Error code -3");
        }
        System.out.println();
    }

    private static int getInputDay(Scanner scanner) {
        int numOfTheDay;
        System.out.print("Enter number of the day: ");
        numOfTheDay = scanner.nextInt();
        scanner.nextLine();
        return numOfTheDay;
    }

    private static void showMeetings(ArrayList<Meeting> meetings) {
        for (Meeting meeting : meetings) {
            System.out.println("---");
            System.out.println(meeting);
        }
    }

    private static void addNewMeeting(Calendar calendar, Scanner scanner) {
        Meeting meeting = createMeeting();
        if (meeting != null) {
            int numOfTheDay = getInputDay(scanner);
            int result = calendar.addMeeting(meeting, numOfTheDay);
            displayInfoIfMeetingAdded(result);
        }
    }

    private static void removeMeeting(Calendar calendar, Scanner scanner) {
        int numOfTheDay = getInputDay(scanner);
        System.out.print("Enter meeting index: ");
        int meetingIndex = scanner.nextInt();
        scanner.nextLine();
        int result = calendar.removeMeeting(meetingIndex, numOfTheDay);
        displayInfoIfMeetingRemoved(result);
    }

    private static void showMeetingsForTheDay(Calendar calendar, Scanner scanner) {
        int numOfTheDay = getInputDay(scanner);

        Predicate<Meeting> checkCondition = (meeting) -> true;
        ArrayList<Meeting> meetingsForTheDay = calendar.getMeetings(numOfTheDay, checkCondition);

        showMeetings(meetingsForTheDay);
    }

    private static void showMeetingsForTheDayFilteredByPriority(Calendar calendar, Scanner scanner) {
        int numOfTheDay = getInputDay(scanner);
        System.out.print("Priority (LOW, MEDIUM, HIGH): ");
        Priority priority = returnPriority(scanner.nextLine());

        Predicate<Meeting> checkCondition = (meeting) -> meeting.getPriority() == priority;
        ArrayList<Meeting> meetingsForTheDayByPriority = calendar.getMeetings(numOfTheDay, checkCondition);

        showMeetings(meetingsForTheDayByPriority);
    }

    private static void showMeetingsForTheDayFromGivenTime(Calendar calendar, Scanner scanner) {

        int numOfTheDay = getInputDay(scanner);

        LocalTime givenTime = null;
        boolean invalidInput = true;

        while (invalidInput) {
            try {
                System.out.print("Start time (HH:MM): ");
                givenTime = LocalTime.parse(scanner.nextLine());
                invalidInput = false;
            } catch (DateTimeParseException err) {
                System.out.println("Error! Invalid time passed. You have to use HH:MM format.");
            }
        }

        LocalTime finalGivenTime = givenTime;
        Predicate<Meeting> checkCondition = (meeting) -> !meeting.getStartTime().isBefore(finalGivenTime);
        ArrayList<Meeting> meetingsForTheDay = calendar.getMeetings(numOfTheDay, checkCondition);
        showMeetings(meetingsForTheDay);
    }

    private static void showMeetingsForTheDayAtGivenDataFrame(Calendar calendar, Scanner scanner) {

        int numOfTheDay = getInputDay(scanner);

        LocalTime givenStartTime = null;
        boolean invalidInput = true;

        while (invalidInput) {
            try {
                System.out.print("Start time (HH:MM): ");
                givenStartTime = LocalTime.parse(scanner.nextLine());
                invalidInput = false;
            } catch (DateTimeParseException err) {
                System.out.println("Error! Invalid time passed. You have to use HH:MM format.");
            }
        }

        LocalTime givenEndTime = null;
        invalidInput = true;

        while (invalidInput) {
            try {
                System.out.print("Start time (HH:MM): ");
                givenEndTime = LocalTime.parse(scanner.nextLine());
                invalidInput = false;
            } catch (DateTimeParseException err) {
                System.out.println("Error! Invalid time passed. You have to use HH:MM format.");
            }
        }


        LocalTime finalGivenStartTime = givenStartTime;
        LocalTime finalGivenEndTime = givenEndTime;

        Predicate<Meeting> checkCondition =
                (meeting) -> !meeting.getStartTime().isBefore(finalGivenStartTime) && !meeting.getEndTime().isAfter(finalGivenEndTime);

        ArrayList<Meeting> meetingsForTheDay = calendar.getMeetings(numOfTheDay, checkCondition);
        showMeetings(meetingsForTheDay);
    }

    private static void showMeetingsForTheDayFromGivenTimeByPriority(Calendar calendar, Scanner scanner) {

        int numOfTheDay = getInputDay(scanner);

        LocalTime givenTime = null;
        boolean invalidInput = true;

        while (invalidInput) {
            try {
                System.out.print("Start time (HH:MM): ");
                givenTime = LocalTime.parse(scanner.nextLine());
                invalidInput = false;
            } catch (DateTimeParseException err) {
                System.out.println("Error! Invalid time passed. You have to use HH:MM format.");
            }
        }

        System.out.print("Priority (LOW, MEDIUM, HIGH): ");
        Priority priority = returnPriority(scanner.nextLine());

        LocalTime finalGivenTime = givenTime;

        Predicate<Meeting> checkCondition =
                (meeting) -> !meeting.getStartTime().isBefore(finalGivenTime) && meeting.getPriority() == priority;

        ArrayList<Meeting> meetingsForTheDay = calendar.getMeetings(numOfTheDay, checkCondition);
        showMeetings(meetingsForTheDay);
    }


    public static void main(String[] args) {
        System.out.println("A program that handles a weekly calendar of meetings");
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = new Calendar();
        boolean isRunning = true;

        while (isRunning) {
            printMenu();
            System.out.print("Choose option (1 - 8): ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (option) {
                case 1 -> addNewMeeting(calendar, scanner);
                case 2 -> removeMeeting(calendar, scanner);
                case 3 -> showMeetingsForTheDay(calendar, scanner);
                case 4 -> showMeetingsForTheDayFilteredByPriority(calendar, scanner);
                case 5 -> showMeetingsForTheDayFromGivenTime(calendar, scanner);
                case 6 -> showMeetingsForTheDayAtGivenDataFrame(calendar, scanner);
                case 7 -> showMeetingsForTheDayFromGivenTimeByPriority(calendar, scanner);
                case 8 -> {
                    System.out.println("Goodbye!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}