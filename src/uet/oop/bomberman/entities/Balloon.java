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
    private ArrayList<Sprite> frameRight = new ArrayList<Sprite>();
    private ArrayList<Sprite> frameDown = new ArrayList<Sprite>();
    private ArrayList<Sprite> frameLeft = new ArrayList<Sprite>();
    private ArrayList<Sprite> frameUp = new ArrayList<Sprite>();
    private ArrayList<Sprite> frameDestroy = new ArrayList<Sprite>();

    public Balloon(int xUnit, int yUnit,Sprite sprite, List<Entity> map) {
        super(xUnit, yUnit, sprite, map);
        init();
    }

    private void init() {
        frameUp.add(Sprite.balloom_right1);
        frameUp.add(Sprite.balloom_right2);
        frameUp.add(Sprite.balloom_right3);

        frameRight.add(Sprite.balloom_right1);
        frameRight.add(Sprite.balloom_right2);
        frameRight.add(Sprite.balloom_right3);

        frameDown.add(Sprite.balloom_left1);
        frameDown.add(Sprite.balloom_left2);
        frameDown.add(Sprite.balloom_left3);

        frameLeft.add(Sprite.balloom_left1);
        frameLeft.add(Sprite.balloom_left2);
        frameLeft.add(Sprite.balloom_left3);

        frameDestroy.add(Sprite.balloom_dead);
        frameDestroy.add(Sprite.balloom_dead);
        frameDestroy.add(Sprite.balloom_dead);

        animationFrame = new AnimationFrame(this,seepAnimation, frameUp, frameRight, frameDown, frameLeft, frameDestroy);
    }

    @Override
    public void update() {
        autoMove();
        animationFrame.loadFrame(status);
    }
}
