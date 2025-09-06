
import java.util.Scanner;

public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1) Circle  2) Rectangle");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("Radius: ");
            double r = sc.nextDouble();
            Shape c = new Circle(r);
            System.out.printf("Area=%.2f  Perimeter=%.2f%n", c.area(), c.perimeter());
        } else if (choice == 2) {
            System.out.print("Width: ");
            double w = sc.nextDouble();
            System.out.print("Height: ");
            double h = sc.nextDouble();
            Shape rect = new Rectangle(w, h);
            System.out.printf("Area=%.2f  Perimeter=%.2f%n", rect.area(), rect.perimeter());
        } else {
            System.out.println("Invalid choice.");
        }
        sc.close();
    }
}
