import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Atelier extends Application {

    private boolean run;
    private int index = 0;
    private ArrayList<Sketch> modules;
    private AnimationTimer update;
    private Canvas canvas;

    @Override
    public void init() {
        if(instance == null) {
            instance = this;
        }

        canvas = new Canvas(800, 800);

        modules = new ArrayList<>();
        modules.add(new TenPrint());
        modules.add(new ChaosGame());
        modules.add(new Netzkaefer());
        modules.add(new SpiralOut());
        modules.add(new Hullibu());
        modules.add(new GehZumLicht());

        update = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    modules.get(index).loop();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        root.getChildren().add(canvas);

        canvas.widthProperty().bind(root.widthProperty());
        canvas.heightProperty().bind(root.heightProperty());

        Scene scene = new Scene(root, 800, 800);
        scene.setOnMousePressed(e -> modules.get(index).mousePressed(e));
        scene.setOnMouseMoved(e -> modules.get(index).mouseMoved(e));
        scene.setOnKeyPressed(e -> {
            modules.get(index).keyPressed(e);
            switch(e.getCode()) {
                case F5:
                    modules.get(index).setup();
                    break;
                case F11:
                    stage.setFullScreen(!stage.isFullScreen());
                    modules.get(index).setup();
                    break;
                case ESCAPE:
                    update.stop();
                    stage.close();
                    break;
                case SPACE:
                    if(run) {
                        update.stop();
                        run = false;
                    } else {
                        update.start();
                        run = true;
                    }
                    break;
                case RIGHT:
                    index = (index + 1) % modules.size();
                    modules.get(index).setup();
                    break;
            }
        });

        stage.setFullScreenExitHint("");

        stage.setScene(scene);
        stage.getIcons().add(new Image("Schwender.png"));
        stage.setTitle("Kunstologie");
        stage.show();

        modules.get(index).setup();
        update.start();
        run = true;
    }

    private static Atelier instance;

    public static Canvas getCanvas() {
        return instance.canvas;
    }

    public static void main(String[] args) {
        launch(args);
    }

}