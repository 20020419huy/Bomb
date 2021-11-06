package uet.oop.bomberman.entities;

import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import uet.oop.bomberman.graphics.AnimationFrame;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Balloon extends Alien{
    private double seepAnimation = 100;
    private AnimationFrame animationFrame;
    private ArrayList<Image> frameRight = new ArrayList<Image>();
    private ArrayList<Image> frameDown = new ArrayList<Image>();
    private ArrayList<Image> frameLeft = new ArrayList<Image>();
    private ArrayList<Image> frameUp = new ArrayList<Image>();
    private ArrayList<Image> frameDestroy = new ArrayList<Image>();

    public Balloon(int xUnit, int yUnit, Image img, List<Entity> map) {
        super(xUnit, yUnit, img,map);
        init();
    }

    private void init() {
        frameUp.add(Sprite.balloom_right1.getFxImage());
        frameUp.add(Sprite.balloom_right2.getFxImage());
        frameUp.add(Sprite.balloom_right3.getFxImage());

        frameRight.add(Sprite.balloom_right1.getFxImage());
        frameRight.add(Sprite.balloom_right2.getFxImage());
        frameRight.add(Sprite.balloom_right3.getFxImage());

        frameDown.add(Sprite.balloom_left1.getFxImage());
        frameDown.add(Sprite.balloom_left2.getFxImage());
        frameDown.add(Sprite.balloom_left3.getFxImage());

        frameLeft.add(Sprite.balloom_left1.getFxImage());
        frameLeft.add(Sprite.balloom_left2.getFxImage());
        frameLeft.add(Sprite.balloom_left3.getFxImage());

        frameDestroy.add(Sprite.balloom_dead.getFxImage());
        frameDestroy.add(Sprite.balloom_dead.getFxImage());
        frameDestroy.add(Sprite.balloom_dead.getFxImage());

        animationFrame = new AnimationFrame(this,seepAnimation, frameUp, frameRight, frameDown, frameLeft, frameDestroy);
    }

    @Override
    public void update() {
        autoMove();
        animationFrame.loadFrame(status);
    }
}
