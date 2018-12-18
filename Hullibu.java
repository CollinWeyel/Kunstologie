import javafx.scene.paint.Color;

public class Hullibu extends Sketch {

    private Vector2D[] particles = new Vector2D[4];
    private Color[] colors = new Color[particles.length];

    @Override
    public void setup() {
        g.setFill(Color.gray(0.1));
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for(int z = 0; z < particles.length; z++) {
            particles[z] = new Vector2D(canvas.getWidth() / 2, canvas.getHeight() / 2);
            colors[z] = Color.hsb(Math.random() * 360, 0.9, 0.9, 0.05);
        }
    }

    @Override
    public void loop() {
        for(int i = 0; i < 100; i++) {
            for (int z = 0; z < particles.length; z++) {
                particles[z].add(new Vector2D(Math.random() * 2 - 1, Math.random() * 2 - 1).norm().mul(Math.random() * 4));
                g.setFill(colors[z]);
                g.fillOval(particles[z].x, particles[z].y, 10, 10);
                if(particles[z].x <= 0 || particles[z].x >= canvas.getWidth() ||
                   particles[z].y <= 0 || particles[z].y >= canvas.getHeight()) {
                    particles[z] = new Vector2D(canvas.getWidth() / 2, canvas.getHeight() / 2);
                    colors[z] = Color.hsb(Math.random() * 360, 0.9, 0.9, 0.05);
                }
            }
        }
    }

}