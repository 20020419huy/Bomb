package uet.oop.bomberman.entities;

import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;

import java.awt.*;

public class Bomber extends Entity {
    private double speed = 2;
    public final KeyCode KEY_BOMB = KeyCode.SPACE;
    private final KeyCode KEY_UP = KeyCode.UP;
    private final KeyCode KEY_RIGHT = KeyCode.RIGHT;
    private final KeyCode KEY_DOWN = KeyCode.DOWN;
    private final KeyCode KEY_LEFT = KeyCode.LEFT;
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }
    @Override
    public void update() {

    }

    public void updatePosition (KeyCode direc) {
        if(direc == KEY_UP) {
            y -= speed;
        } else if(direc == KEY_RIGHT) {
            x += speed;
        } else if(direc == KEY_DOWN) {
            y += speed;
        } else if(direc == KEY_LEFT) {
            x -= speed;
        }
    }

}
