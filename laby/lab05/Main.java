import java.util.Scanner;

public class Main {

    private static void printMenu() {
        System.out.println();
        System.out.println("1 - add new grade");
        System.out.println("2 - calculate the mean of the grades");
        System.out.println("3 - print highest grade");
        System.out.println("4 - print lowest grade");
        System.out.println("5 - exit program");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GradeList grades = new GradeList();

        System.out.println("Welcome to program used to store grades");

        boolean isRunning = true;

        while (isRunning) {

            printMenu();

            System.out.print("Choose option (1 - 5): ");
            int option = scanner.nextInt();

            System.out.println();
            switch (option) {
                case 1:
                    System.out.print("Enter new grade: ");
                    double grade = scanner.nextDouble();
                    grades.addGrade(grade);
                    break;
                case 2:
                    grades.calcMean();
                    break;
                case 3:
                    grades.printHighestGrade();
                    break;
                case 4:
                    grades.printLowestGrade();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
