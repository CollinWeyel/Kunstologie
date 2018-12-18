import javafx.scene.paint.Color;

public class ChaosGame extends Sketch {

    private Vector2D current;
    private Vector2D[] points = new Vector2D[3];
    private int d = 4;

    @Override
    public void setup() {
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g.setFill(Color.RED);
        current = new Vector2D(Math.random() * canvas.getWidth(), Math.random() * canvas.getHeight());
        g.fillOval(current.x, current.y, d, d);
        g.setFill(Color.WHITE);
        for(int z = 0; z < points.length; z++) {
            points[z] = new Vector2D(Math.random() * canvas.getWidth(), Math.random() * canvas.getHeight());
            g.fillOval(points[z].x, points[z].y, d, d);
        }
    }

    @Override
    public void loop() {
        for(int z = 0; z < 16; z++) {
            int r = (int)(Math.random() * points.length);
            Vector2D next = current.add(points[r].copy().sub(current).mul(0.5));
            switch(r) {
                case 0:
                    g.setFill(Color.rgb(255, 255, 0, 0.5));
                    break;
                case 1:
                    g.setFill(Color.rgb(255, 0, 255, 0.5));
                    break;
                case 2:
                    g.setFill(Color.rgb(0, 255, 255, 0.5));
                    break;
            }
            g.fillOval(next.x, next.y, d, d);
        }
    }

}