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

    // Method for creating random instances
    public static Kunstwerk createRandom(int panelWidth, int panelHeight) {
        Random random = new Random();
        int shapeType = random.nextInt(5); // Randomly select a shape type (0 to 4)

        switch (shapeType) {
            case 0:
                return createRandomCircle(random, panelWidth, panelHeight);
            case 1:
                return createRandomTriangle(random, panelWidth, panelHeight);
            case 2:
                return createRandomSquare(random, panelWidth, panelHeight);
            case 3:
                return createRandomLine(random, panelWidth, panelHeight);
            default:
                return createRandomCircle(random, panelWidth, panelHeight); // Default to Circle if unexpected value
        }
    }

    private static Circle createRandomCircle(Random random, int panelWidth, int panelHeight) {
        double radius = random.nextDouble() * 50; // Random radius between 0 and 50

        // Ensure the circle stays within the panel bounds
        double x = radius + random.nextDouble() * (panelWidth - 2 * radius);
        double y = radius + random.nextDouble() * (panelHeight - 2 * radius);

        Circle circle = new Circle(x, y, radius);
        circle.setFillColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))); // Random fill color

        return circle;
    }

    private static Triangle createRandomTriangle(Random random, int panelWidth, int panelHeight) {
        // Generate random coordinates for triangle vertices within the panel bounds
        double x1 = random.nextDouble() * panelWidth;
        double y1 = random.nextDouble() * panelHeight;
        double x2 = random.nextDouble() * panelWidth;
        double y2 = random.nextDouble() * panelHeight;
        double x3 = random.nextDouble() * panelWidth;
        double y3 = random.nextDouble() * panelHeight;

        Color fill = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)); // Random fill color
        return new Triangle(x1, y1, x2, y2, x3, y3);
    }

    private static Square createRandomSquare(Random random, int panelWidth, int panelHeight) {
        double sideLength = random.nextDouble() * 50; // Random side length between 0 and 50

        // Ensure the square stays within the panel bounds
        double x = random.nextDouble() * (panelWidth - sideLength);
        double y = random.nextDouble() * (panelHeight - sideLength);

        Color fill = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)); // Random fill color

        Square square = new Square(sideLength);
        square.setX(x);
        square.setY(y);
        square.setFillColor(fill);

        return square;
    }

    private static Line createRandomLine(Random random, int panelWidth, int panelHeight) {
        int startX = random.nextInt(panelWidth);
        int startY = random.nextInt(panelHeight);
        int endX = random.nextInt(panelWidth);
        int endY = random.nextInt(panelHeight);

        Point start = new Point(startX, startY);
        Point end = new Point(endX, endY);

        Line line = new Line(start, end);
        line.setFillColor(null);
        return line;
    }
}
