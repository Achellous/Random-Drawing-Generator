import java.awt.Color;
import java.util.Random;

public class Kunstwerk {
    protected Color fill;

    // Getter and setter for fill color
    public Color getFill() {
        return fill;
    }

    public void setFill(Color fill) {
        this.fill = fill;
    }

    // Method to create a random figure (excluding Point)
    public static Kunstwerk createRandom() {
        Random random = new Random();
        int choice = random.nextInt(3); // Randomly choose a figure type excluding Point

        switch (choice) {
            case 0:
                return Circle.createRandom();
            case 1:
                return Triangle.createRandom();
            case 2:
                return Square.createRandom();
            // Add more cases for other figure types as needed
            default:
                return null;
        }

    }

}
