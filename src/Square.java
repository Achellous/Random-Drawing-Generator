import java.awt.Color;
import java.util.Random;

public class Square extends Kunstwerk {
    private double sideLength;
    private double x;
    private double y;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static Square createRandom() {
        Random random = new Random();
        double sideLength = random.nextDouble() * 100; // Random side length between 0 and 100
        double x = random.nextDouble() * 800; // Random x coordinate within 800
        double y = random.nextDouble() * 600; // Random y coordinate within 600

        Color fill = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)); // Random fill color

        // Create a Square instance with random side length, coordinates, and fill color
        Square square = new Square(sideLength);
        square.setX(x);
        square.setY(y);
        square.setFill(fill);

        return square;
    }
}
