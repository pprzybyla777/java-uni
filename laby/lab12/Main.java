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
        System.out.println("4 - show meetings for the day by priority");
        System.out.println("5 - show meetings for the day starting at or after given time filtered by priority");

        System.out.println("6 - add new task");
        System.out.println("7 - remove task");

        System.out.println("8 - show tasks for the day");
        System.out.println("9 - show tasks for the day by status");
        System.out.println("10 - show tasks for the day ending to given time by status");

        System.out.println("11 - exit program");
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

    private static Status returnStatus(String priority) {

        if (priority.equals("IN_PLANNING")) {
            return Status.IN_PLANNING;
        }
        if (priority.equals("APPROVED")) {
            return Status.APPROVED;
        }
        if (priority.equals("IN_PROGRESS")) {
            return Status.IN_PROGRESS;
        }
        if (priority.equals("EXECUTED")) {
            return Status.EXECUTED;
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

    private static Task createTask() {

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

        System.out.print("Status (IN_PLANNING, APPROVED, IN_PROGRESS, EXECUTED): ");
        Status status = returnStatus(scanner.nextLine());

        if (status == null) {
            return null;
        }

        return new Task(description, startTime, endTime, status);
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

    private static void showEvents(ArrayList<Event> events) {
        for (Event event : events) {
            System.out.println("---");
            System.out.println(event);
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

    private static void addNewTask(Calendar calendar, Scanner scanner) {

        Task task = createTask();
        if (task != null) {
            int numOfTheDay = getInputDay(scanner);
            int result = calendar.addTask(task, numOfTheDay);
            displayInfoIfMeetingAdded(result);
        }

    }

    private static void removeMeeting(Calendar calendar, Scanner scanner) {

        int numOfTheDay = getInputDay(scanner);

        System.out.println("Events in the day: ");
        ArrayList<Event> eventsForTheDay = calendar.getEvents(numOfTheDay, event -> true);

        showEvents(eventsForTheDay);

        System.out.print("Enter meeting index: ");

        int meetingIndex = scanner.nextInt();
        scanner.nextLine();

        int result = calendar.removeEvent(meetingIndex, numOfTheDay);
        displayInfoIfMeetingRemoved(result);
    }

    private static void showMeetingsForTheDay(Calendar calendar, Scanner scanner) {

        int numOfTheDay = getInputDay(scanner);

        ArrayList<Event> filteredMeetings = calendar.getEvents(numOfTheDay, (event -> event instanceof Meeting));

        showEvents(filteredMeetings);
    }

    private static void showTasksForTheDay(Calendar calendar, Scanner scanner) {

        int numOfTheDay = getInputDay(scanner);

        ArrayList<Event> filteredTasks = calendar.getEvents(numOfTheDay, event -> event instanceof Task);

        showEvents(filteredTasks);
    }

    private static void showMeetingsForTheDayFilteredByPriority(Calendar calendar, Scanner scanner) {

        int numOfTheDay = getInputDay(scanner);
        System.out.print("Priority (LOW, MEDIUM, HIGH): ");
        Priority priority = returnPriority(scanner.nextLine());

        ArrayList<Event> meetingsForTheDayByPriority = calendar.getEvents(numOfTheDay, event -> event instanceof Meeting && ((Meeting) event).getPriority() == priority);

        showEvents(meetingsForTheDayByPriority);
    }

    private static void showTasksForTheDayByStatus(Calendar calendar, Scanner scanner) {

        int numOfTheDay = getInputDay(scanner);
        System.out.print("Status (IN_PLANNING, APPROVED, IN_PROGRESS, EXECUTED): ");
        Status status = returnStatus(scanner.nextLine());

        ArrayList<Event> tasksForTheDayByStatus = calendar.getEvents(numOfTheDay, event -> event instanceof Task && ((Task) event).getStatus() == status);

        showEvents(tasksForTheDayByStatus);
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

        Predicate<Event> checkCondition =
                (event) -> event instanceof Meeting && ((Meeting) event).getPriority() == priority && !event.getStartTime().isBefore(finalGivenTime);

        ArrayList<Event> meetingsForTheDay = calendar.getEvents(numOfTheDay, checkCondition);

        showEvents(meetingsForTheDay);
    }

    private static void showTasksForTheDayEndingToGivenTimeByStatus(Calendar calendar, Scanner scanner) {

        int numOfTheDay = getInputDay(scanner);

        LocalTime givenTime = null;
        boolean invalidInput = true;

        while (invalidInput) {
            try {
                System.out.print("End time (HH:MM): ");
                givenTime = LocalTime.parse(scanner.nextLine());
                invalidInput = false;
            } catch (DateTimeParseException err) {
                System.out.println("Error! Invalid time passed. You have to use HH:MM format.");
            }
        }

        System.out.print("Status (IN_PLANNING, APPROVED, IN_PROGRESS, EXECUTED): ");
        Status status = returnStatus(scanner.nextLine());

        LocalTime finalGivenTime = givenTime;

        Predicate<Event> checkCondition =
                (event) -> event instanceof Task && ((Task) event).getStatus() == status && !event.getEndTime().isAfter(finalGivenTime);

        ArrayList<Event> filteredTasks = calendar.getEvents(numOfTheDay, checkCondition);

        showEvents(filteredTasks);
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
                case 5 -> showMeetingsForTheDayFromGivenTimeByPriority(calendar, scanner);
                case 6 -> addNewTask(calendar, scanner);
                case 7 -> removeMeeting(calendar, scanner);
                case 8 -> showTasksForTheDay(calendar, scanner);
                case 9 -> showTasksForTheDayByStatus(calendar, scanner);
                case 10 -> showTasksForTheDayEndingToGivenTimeByStatus(calendar, scanner);
                case 11 -> {
                    System.out.println("Goodbye!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}