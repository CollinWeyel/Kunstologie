import javafx.scene.paint.Color;

public class SpiralOut extends Sketch {

    private double i;
    private double r;

    @Override
    public void setup() {
        g.setFill(Color.gray(0.1));
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        i = Math.random() * 360;
        r = 0;
    }

    @Override
    public void loop() {
        for(int z = 0; z < 100; z++) {
            g.setFill(Color.hsb(i, 0.9, 0.9, 0.2));
            double rndm = Math.random() * 8;
            g.fillOval(canvas.getWidth() / 2 + Math.cos(i) * r - rndm, canvas.getHeight() / 2 + Math.sin(i) * r - rndm, 2 * rndm, 2 * rndm);
            i += 0.05;
            r += 0.05;

            if(r >= canvas.getWidth() / 1.2) {
                setup();
            }
        }
    }

}