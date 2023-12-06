import java.awt.Color;
import java.util.Random;

public abstract class Kunstwerk {
    private Color fillColor;

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    // Method for creating random instances (common for all shapes)
    public static Kunstwerk createRandom() {
        Random random = new Random();
        int shapeType = random.nextInt(5); // Randomly select a shape type (0 to 4)

        return switch (shapeType) {
            case 0 -> createRandomCircle(random);
            case 1 -> createRandomTriangle(random);
            case 2 -> createRandomSquare(random);
            case 3 -> createRandomLine(random);
            default -> createRandomCircle(random); // Default to Circle if unexpected value
        };
    }

    // Methods for generating random instances of each shape
    private static Circle createRandomCircle(Random random) {
        double radius = random.nextDouble() * 50; // Random radius between 0 and 50

        // Ensure the circle stays within the panel bounds
        double x = radius + random.nextDouble() * (200 - 2 * radius); // Random x coordinate within panel width - diameter
        double y = radius + random.nextDouble() * (100 - 2 * radius); // Random y coordinate within panel height - diameter

        Circle circle = new Circle(x, y, radius);
        circle.setFillColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))); // Random fill color

        return circle;
    }


    private static Triangle createRandomTriangle(Random random) {
        // Generate random coordinates for triangle vertices within the panel bounds
        double x1 = random.nextDouble() * 400;
        double y1 = random.nextDouble() * 300;
        double x2 = random.nextDouble() * 400;
        double y2 = random.nextDouble() * 300;
        double x3 = random.nextDouble() * 400;
        double y3 = random.nextDouble() * 300;

        Color fill = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)); // Random fill color
        return new Triangle(x1, y1, x2, y2, x3, y3);
    }


    private static Square createRandomSquare(Random random) {
        double sideLength = random.nextDouble() * 50; // Random side length between 0 and 50

        // Ensure the square stays within the panel bounds
        double x = random.nextDouble() * (400 - sideLength); // Random x coordinate within panel width - side length
        double y = random.nextDouble() * (300 - sideLength); // Random y coordinate within panel height - side length

        Color fill = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)); // Random fill color

        Square square = new Square(sideLength);
        square.setX(x);
        square.setY(y);
        square.setFillColor(fill);

        return square;
    }


    private static Line createRandomLine(Random random) {
        int startX = random.nextInt(400); // Random x coordinate for start point within 400
        int startY = random.nextInt(300); // Random y coordinate for start point within 300
        int endX = random.nextInt(400); // Random x coordinate for end point within 400
        int endY = random.nextInt(300); // Random y coordinate for end point within 300

        Point start = new Point(startX, startY);
        Point end = new Point(endX, endY);

        Line line = new Line(start, end);
        line.setFillColor(null); // or any default color you wish to set

        return line;
    }

}
