import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("This class deals with math operations for a cylinder");
        System.out.print("Radius: ");
        double radius = scanner.nextDouble();
        System.out.print("Height: ");
        double height = scanner.nextDouble();
        Cylinder cylinder = new Cylinder(radius, height);

        boolean isRunning = true;

        while (isRunning) {

            // Print Menu
            System.out.println(" 1 - print radius and height");
            System.out.println(" 2 - change radius and height");
            System.out.println(" 3 - print all surface areas and volume");
            System.out.println(" 4 - exit ");
            //
            System.out.print("Choose option: ");
            int option = scanner.nextInt();

            if (option == 1) {

                System.out.println("Radius: " + cylinder.getRadius());
                System.out.println("Height: " + cylinder.getHeight());

            } else if (option == 2) {

                System.out.print("New radius: ");
                radius = scanner.nextDouble();
                System.out.print("New height: ");
                height = scanner.nextDouble();

                cylinder.setRadius(radius);
                cylinder.setHeight(height);


            } else if (option == 3) {

                System.out.println("Surface Area: " + cylinder.surfaceArea());
                System.out.println("Lateral Area: " + cylinder.lateralArea());
                System.out.println("Total Surface Area: " + cylinder.totalSurfaceArea());
                System.out.println("Volume: " + cylinder.volume());

            } else if (option == 4 ) {
                System.out.println("Goodbye!");
                isRunning = false;
            }
        }
    }
}
