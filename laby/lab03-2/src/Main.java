import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // konstruktor bez parametrów

        Cylinder cylinder = new Cylinder();

        System.out.print("Radius: ");
        double radius = scanner.nextDouble();
        System.out.print("Height: ");
        double height = scanner.nextDouble();

        cylinder.setHeight(radius);
        cylinder.setRadius(height);

        System.out.println("Radius: " + cylinder.getRadius());
        System.out.println("Height: " + cylinder.getHeight());

        System.out.println("Surface Area: " + cylinder.surfaceArea());
        System.out.println("Lateral Area: " + cylinder.lateralArea());
        System.out.println("Total Surface Area: " + cylinder.totalSurfaceArea());
        System.out.println("Volume: " + cylinder.volume());

        // konstruktor z parametrami

        System.out.print("Radius: ");
        radius = scanner.nextDouble();
        System.out.print("Height: ");
        height = scanner.nextDouble();

        Cylinder cylinder2 = new Cylinder(radius, height);

        System.out.println("Radius: " + cylinder.getRadius());
        System.out.println("Height: " + cylinder.getHeight());

        System.out.println("Surface Area: " + cylinder.surfaceArea());
        System.out.println("Lateral Area: " + cylinder.lateralArea());
        System.out.println("Total Surface Area: " + cylinder.totalSurfaceArea());
        System.out.println("Volume: " + cylinder.volume());


    }
}