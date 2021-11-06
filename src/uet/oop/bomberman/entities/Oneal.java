package uet.oop.bomberman.entities;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.AnimationFrame;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Oneal extends Alien {
    private double seepAnimation = 100;
    private AnimationFrame animationFrame;
    private ArrayList<Image> frameRight = new ArrayList<Image>();
    private ArrayList<Image> frameDown = new ArrayList<Image>();
    private ArrayList<Image> frameLeft = new ArrayList<Image>();
    private ArrayList<Image> frameUp = new ArrayList<Image>();
    private ArrayList<Image> frameDestroy = new ArrayList<Image>();

    public Oneal(int xUnit, int yUnit, Image img, List<Entity> map) {
        super(xUnit, yUnit, img, map);
        init();
    }

    private void init() {
        frameUp.add(Sprite.oneal_right1.getFxImage());
        frameUp.add(Sprite.oneal_right2.getFxImage());
        frameUp.add(Sprite.oneal_right3.getFxImage());

        frameRight.add(Sprite.oneal_right1.getFxImage());
        frameRight.add(Sprite.oneal_right2.getFxImage());
        frameRight.add(Sprite.oneal_right3.getFxImage());

        frameDown.add(Sprite.oneal_left1.getFxImage());
        frameDown.add(Sprite.oneal_left2.getFxImage());
        frameDown.add(Sprite.oneal_left3.getFxImage());

        frameLeft.add(Sprite.oneal_left1.getFxImage());
        frameLeft.add(Sprite.oneal_left2.getFxImage());
        frameLeft.add(Sprite.oneal_left3.getFxImage());

        frameDestroy.add(Sprite.oneal_dead.getFxImage());
        frameDestroy.add(Sprite.oneal_dead.getFxImage());
        frameDestroy.add(Sprite.oneal_dead.getFxImage());

        animationFrame = new AnimationFrame(this,seepAnimation, frameUp, frameRight, frameDown, frameLeft, frameDestroy);
    }

    @Override
    public void update() {
        autoMove();
        animationFrame.loadFrame(status);
    }
}
