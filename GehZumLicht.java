import javafx.scene.paint.Color;

public class GehZumLicht extends Sketch {

    @Override
    public void setup() {
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g.setStroke(Color.gray(1, 0.01));
        g.setLineWidth(2);
    }

    @Override
    public void loop() {
        for(int z = 0; z < 25; z++) {
            g.strokeLine(Math.random() * canvas.getWidth(), Math.random() * canvas.getHeight(),
                    canvas.getWidth() / 2, canvas.getHeight() / 2);
        }
    }
}