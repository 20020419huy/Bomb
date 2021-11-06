package uet.oop.bomberman.entities;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import uet.oop.bomberman.graphics.AnimationFrame;
import uet.oop.bomberman.graphics.Sprite;
import javafx.animation.*;

import javax.swing.tree.DefaultTreeCellEditor;
import java.awt.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;

public class Bomber extends Entity {
    private double speed = 1;
    private double speedAnimation = 100;
    private boolean isPressed = false;
    private Timeline timelineRight = null;
    public KeyCode KEY_BOMB = KeyCode.SPACE;
    private AnimationFrame animationFrame;
    private ArrayList<Image> frameRight = new ArrayList<Image>();
    private ArrayList<Image> frameDown = new ArrayList<Image>();
    private ArrayList<Image> frameLeft = new ArrayList<Image>();
    private ArrayList<Image> frameUp = new ArrayList<Image>();
    private ArrayList<Image> frameDestroy = new ArrayList<Image>();
    private ArrayList<Image> frames;
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
        init();
    }
    private void init() {
        frameUp.add(Sprite.player_up.getFxImage());
        frameUp.add(Sprite.player_up_1.getFxImage());
        frameUp.add(Sprite.player_up_2.getFxImage());

        frameRight.add(Sprite.player_right.getFxImage());
        frameRight.add(Sprite.player_right_1.getFxImage());
        frameRight.add(Sprite.player_right_2.getFxImage());

        frameDown.add(Sprite.player_down.getFxImage());
        frameDown.add(Sprite.player_down_1.getFxImage());
        frameDown.add(Sprite.player_down_2.getFxImage());

        frameLeft.add(Sprite.player_left.getFxImage());
        frameLeft.add(Sprite.player_left_1.getFxImage());
        frameLeft.add(Sprite.player_left_2.getFxImage());

        frameDestroy.add(Sprite.player_dead1.getFxImage());
        frameDestroy.add(Sprite.player_dead2.getFxImage());
        frameDestroy.add(Sprite.player_dead3.getFxImage());

        animationFrame = new AnimationFrame(this, speedAnimation, frameUp, frameRight, frameDown, frameLeft, frameDestroy);
    }

    @Override
    public void update() {
        animationFrame.loadFrame(status);
    }

    public void updatePosition (KeyCode direc) {
        if(direc == KeyCode.UP) {
            y -= speed;
            status = 1;
        } else if(direc == KeyCode.RIGHT) {
            x += speed;
            status = 2;
        } else if(direc == KeyCode.DOWN) {
            y += speed;
            status = 3;
        } else if(direc == KeyCode.LEFT) {
            x -= speed;
            status = 4;
        }  else if (direc == KeyCode.SPACE) {

        } else if(direc == null) {
            status = 0;
        }
    }

}
