import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Drawing extends JPanel {
    private List<Kunstwerk> shapes;

    public Drawing(List<Kunstwerk> shapes) {
        this.shapes = shapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Kunstwerk shape : shapes) {
            if (shape instanceof Circle circle) {
                g.setColor(circle.getFillColor());
                int diameter = (int) (circle.getRadius() * 2);
                g.fillOval((int) (circle.getX() - circle.getRadius()), (int) (circle.getY() - circle.getRadius()), diameter, diameter);
            } else if (shape instanceof Triangle triangle) {
                g.setColor(triangle.getFillColor());
                int[] xPoints = new int[]{(int) triangle.getX1(), (int) triangle.getX2(), (int) triangle.getX3()};
                int[] yPoints = new int[]{(int) triangle.getY1(), (int) triangle.getY2(), (int) triangle.getY3()};
                g.fillPolygon(xPoints, yPoints, 3);
            } else if (shape instanceof Square square) {
                g.setColor(square.getFillColor());
                g.fillRect((int) square.getX(), (int) square.getY(), (int) square.getSideLength(), (int) square.getSideLength());
            } else if (shape instanceof Line line) {
                g.setColor(line.getFillColor());
                g.drawLine((int) line.getStartPoint().getX(), (int) line.getStartPoint().getY(),
                        (int) line.getEndPoint().getX(), (int) line.getEndPoint().getY());
            }
        }
    }



    public static void main(String[] args) {
        List<Kunstwerk> shapes = new ArrayList<>();

        shapes.add(Circle.createRandom()); // Adding a random circle
        shapes.add(Triangle.createRandom()); // Adding a random triangle
        shapes.add(Square.createRandom()); // Adding a random square
        shapes.add(Line.createRandom()); // Adding a random line

        Random random = new Random();
        int numberOfShapesPerType = 20; // Change this value to add more shapes of each type

        for (int i = 0; i < numberOfShapesPerType; i++) {
            shapes.add(Circle.createRandom());
            shapes.add(Triangle.createRandom());
            shapes.add(Square.createRandom());
            shapes.add(Line.createRandom());
            // Add more instances if needed
        }

        JFrame frame = new JFrame("Random Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Drawing drawing = new Drawing(shapes);
        frame.add(drawing);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }





}
