package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Map;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombermanGame extends Application {
    private GraphicsContext gc;
    private Canvas canvas;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();
    private Map map = new Map(stillObjects);
    private Bomber bomber = null;
    private KeyCode direc = null;
    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * Map.WIDTH, Sprite.SCALED_SIZE * Map.HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao map
        bomber = (Bomber) stillObjects.get(map.createMap(1));
        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();
        // lang nghe di ban phim
        move(scene);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
                bomber.updatePosition(direc);
            }
        };
        timer.start();
    }

    public void move(Scene scene) {
        scene.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() != bomber.KEY_BOMB) {
                direc = e.getCode();
            }
        });
        scene.setOnKeyReleased((KeyEvent e) -> {
           if(e.getCode() != bomber.KEY_BOMB) {
               direc = null;
           }
        });
    }

    public void update() {
        for (int i = 0; i < stillObjects.size(); i++) {
            stillObjects.get(i).update();
        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}
