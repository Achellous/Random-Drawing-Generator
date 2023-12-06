import java.awt.Color;
import java.util.Random;

public class Line extends Kunstwerk {
    private Point startPoint;
    private Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public static Line createRandom() {
        Random random = new Random();
        int startX = random.nextInt(800); // Random x coordinate for start point within 800
        int startY = random.nextInt(600); // Random y coordinate for start point within 600
        int endX = random.nextInt(800); // Random x coordinate for end point within 800
        int endY = random.nextInt(600); // Random y coordinate for end point within 600

        Point start = new Point(startX, startY);
        Point end = new Point(endX, endY);

        // Create a Line instance with random start and end points and no fill color initially
        Line line = new Line(start, end);
        line.setFill(null); // or any default color you wish to set

        return line;
    }
}
