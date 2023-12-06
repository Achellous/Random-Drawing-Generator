import java.awt.Color;
import java.util.Random;

public class Circle extends Kunstwerk {
    private double x;
    private double y;
    private double radius;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public static Circle createRandom() {
        Random random = new Random();
        double x = random.nextDouble() * 800; // Random x coordinate within 800
        double y = random.nextDouble() * 600; // Random y coordinate within 600
        double radius = random.nextDouble() * 100; // Random radius between 0 and 100

        // Create a Circle instance with random coordinates, radius, and no fill color initially
        Circle circle = new Circle(x, y, radius);
        circle.setFill(null); // or any default color you wish to set

        return circle;
    }
}
