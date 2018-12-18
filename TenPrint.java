import javafx.scene.paint.Color;

import java.util.Random;

public class TenPrint extends Sketch {

    private int sizeX = 16, sizeY = 16;
    private int posX, posY;
    private Color bgColor = Color.gray(0.1);
    private Color lineColor;
    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void setup() {
        g.setFill(bgColor);
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g.setLineWidth(2);
        posX = posY = 0;
        changeLineColor();
    }

    @Override
    public void loop() {
            g.setFill(bgColor);
            g.fillRect(posX, posY, sizeX + 1, sizeY + 1);

            g.setStroke(lineColor);
            if (random.nextBoolean()) {
                g.strokeLine(posX, posY, posX + sizeX, posY + sizeY);
            } else {
                g.strokeLine(posX + sizeX, posY, posX, posY + sizeY);
            }

            posX += sizeX;
            if (posX > canvas.getWidth()) {
                posX = 0;
                posY += sizeY;
                if (posY > canvas.getHeight()) {
                    posY = 0;
                    changeLineColor();
                }
            }
    }

    public void changeLineColor(){
        lineColor = new Color(Math.random(), Math.random(), Math.random(), 1);
    }
}
