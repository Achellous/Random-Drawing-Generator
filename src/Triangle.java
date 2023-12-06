import java.awt.Color;
import java.util.Random;

public class Triangle extends Kunstwerk {
    // Other properties and methods in the Triangle class...

    private double x1, y1, x2, y2, x3, y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        // Other constructor logic...
    }

    // Getter methods for triangle vertices
    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    // Method to create a random Triangle
    public static Triangle createRandom() {
        Random random = new Random();
        // Generate random coordinates for triangle vertices within a desired range
        double x1 = random.nextDouble() * 800;
        double y1 = random.nextDouble() * 600;
        double x2 = random.nextDouble() * 800;
        double y2 = random.nextDouble() * 600;
        double x3 = random.nextDouble() * 800;
        double y3 = random.nextDouble() * 600;

        Color fill = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)); // Random fill color

        return new Triangle(x1, y1, x2, y2, x3, y3);
    }
}
