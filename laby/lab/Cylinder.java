import java.util.Scanner;
public class Cylinder {

    private double radius;
    private double height;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double newHeight) {
        this.height = newHeight;
    }


    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public Cylinder() {

    }

    public double surfaceArea() {
        return  Math.PI * Math.pow(this.radius, 2);
    }

    public double lateralArea() {
        return 2 * Math.PI * this.radius * this.height;
    }

    public double totalSurfaceArea() {
        return 2 * this.surfaceArea() * this.lateralArea();
    }

    public double volume() {
        return this.surfaceArea() * this.height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This class deals with math operations for a cylinder");
        System.out.print("Radius: ");
        double radius = scanner.nextDouble();
        System.out.print("Height: ");
        double height = scanner.nextDouble();
        Cylinder cylinder = new Cylinder(radius, height);
        System.out.println("1 - print radius and height");
        System.out.println("2 - change radius and height");
        System.out.println("3 - calculate ");
        System.out.println("4 - ");

    }

}
