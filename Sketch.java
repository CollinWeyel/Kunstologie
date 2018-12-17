import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public abstract class Sketch {

    protected Canvas canvas;
    protected GraphicsContext g;

    public Sketch() {
        canvas = Atelier.getCanvas();
        g = canvas.getGraphicsContext2D();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void keyPressed(KeyEvent e) {}

    public abstract void setup();
    public abstract void loop();

}