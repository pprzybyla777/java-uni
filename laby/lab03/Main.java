import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Cylinder cylinder = new Cylinder();

        System.out.println("This class deals with math operations for a cylinder \n");

        boolean isRunning = true;

        while (isRunning) {

            // Print Menu
            System.out.println(" 1 - print radius and height");
            System.out.println(" 2 - change radius and height");
            System.out.println(" 3 - print all surface areas and volume");
            System.out.println(" 4 - exit ");
            System.out.println("\n");
            //

            System.out.print("Choose option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println();
                    System.out.println("Radius: " + cylinder.getRadius());
                    System.out.println("Height: " + cylinder.getHeight());
                    System.out.println();

                    break;
                case 2:
                    System.out.println();
                    System.out.print("New radius: ");
                    double radius = scanner.nextDouble();
                    System.out.print("New height: ");
                    double height = scanner.nextDouble();
                    cylinder.setRadius(radius);
                    cylinder.setHeight(height);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Surface Area: " + cylinder.surfaceArea());
                    System.out.println("Lateral Area: " + cylinder.lateralArea());
                    System.out.println("Total Surface Area: " + cylinder.totalSurfaceArea());
                    System.out.println("Volume: " + cylinder.volume());
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}