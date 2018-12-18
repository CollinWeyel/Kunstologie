import javafx.scene.paint.Color;

public class Netzkaefer extends Sketch {

    @Override
    public void setup() {
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g.setStroke(Color.valueOf("FFFFFF04"));
        g.setLineWidth(1);
    }

    @Override
    public void loop() {
        for(int z = 0; z < 100; z++) {
            g.strokeLine(Math.random() * canvas.getWidth(), Math.random() * canvas.getHeight(),
                         Math.random() * canvas.getWidth(), Math.random() * canvas.getHeight());
        }
    }

}