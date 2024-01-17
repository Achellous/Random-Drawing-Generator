import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        JFrame frame = new JFrame("Fawaz's Piece Of Art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Drawing drawing = new Drawing(shapes);
        frame.add(drawing);

        JButton createButton = new JButton("Do The Magic");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createRandomShapes(shapes);
                drawing.repaint();
            }
        });

        JButton deleteButton = new JButton("Clean The Mess");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapes.clear();
                drawing.repaint();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(deleteButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private static void createRandomShapes(List<Kunstwerk> shapes) {
        Random random = new Random();
        int numberOfShapes = 20;

        for (int i = 0; i < numberOfShapes; i++) {
            shapes.add(Kunstwerk.createRandom(800, 600));
        }
    }
}
