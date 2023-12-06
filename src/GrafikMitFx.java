/*import java.awt.*;

public class GrafikMitFx {
    final int W = 400, H = 300;

   /* public static void main(String[] args) {
        launch(args);

        public void start (Stage primaryStage){
            primaryStage.setTitle ("Grafik mit FX");
            var canvas = new Canvas (W,H);
            var gc = canvas.getGraphicsContext2D();
            drawShape(gc);
            var root = new Group();
            root.getChildren().add(canvas);
            primaryStage.setScene(new Scene (root));
            primaryStage.show();
        }
        private void drawShapes (GraphicsContxt gc){
            gc.strokeLine(10,10,200,20);
            gc.setStroke(Color.RED);
            gc.setLineWidth(5);
            gc.strokeLine(10,30,200,40);

            gc.setStroke (Color.GREEN);
            gc.setLineCap(StrokeineCap.ROUND);
            gc.strokeLine(10,50,200,60);

            for (int r = 20; r < 80; r += 10)
                gc.strokeOval(110 - r, 150 - r, 2 * r, 2 * r);

            double[] x = {240, 360, 300, 360, 220};
            double[] y = {40, 60, 150, 290, 240};

            gc.setFill(Color.YELLOW);
            gc.fillPolygon(x, y, x.length);
            gc.setStroke(Color.BLUE);
            gc.setLineJoin(StrokeLineJoin.ROUND);
            gc.strokePolygon(x, y, x.length);
    }
}
*/
