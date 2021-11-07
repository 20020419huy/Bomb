package uet.oop.bomberman.entities;

import javafx.scene.input.KeyCode;
import uet.oop.bomberman.graphics.AnimationFrame;
import uet.oop.bomberman.graphics.Sprite;
import java.util.ArrayList;
import java.util.List;

public class Bomber extends DynamicEntity {
    private double speed = 2;
    private double speedAnimation = 100;
    private boolean isPressed = false;
    private int oldPosX;
    private int oldPosY;
    public KeyCode KEY_BOMB = KeyCode.SPACE;
    private AnimationFrame animationFrame;
    private ArrayList<Sprite> frameRight = new ArrayList<Sprite>();
    private ArrayList<Sprite> frameDown = new ArrayList<Sprite>();
    private ArrayList<Sprite> frameLeft = new ArrayList<Sprite>();
    private ArrayList<Sprite> frameUp = new ArrayList<Sprite>();
    private ArrayList<Sprite> frameDestroy = new ArrayList<Sprite>();
    private ArrayList<Sprite> frames;
    public Bomber(int x, int y, Sprite sprite, List<Entity> map) {
        super( x, y, sprite, map);
        oldPosX = x;
        oldPosY = y;
        init();
    }
    private void init() {
        frameUp.add(Sprite.player_up);
        frameUp.add(Sprite.player_up_1);
        frameUp.add(Sprite.player_up_2);

        frameRight.add(Sprite.player_right);
        frameRight.add(Sprite.player_right_1);
        frameRight.add(Sprite.player_right_2);

        frameDown.add(Sprite.player_down);
        frameDown.add(Sprite.player_down_1);
        frameDown.add(Sprite.player_down_2);

        frameLeft.add(Sprite.player_left);
        frameLeft.add(Sprite.player_left_1);
        frameLeft.add(Sprite.player_left_2);

        frameDestroy.add(Sprite.player_dead1);
        frameDestroy.add(Sprite.player_dead2);
        frameDestroy.add(Sprite.player_dead3);

        animationFrame = new AnimationFrame(this, speedAnimation, frameUp, frameRight, frameDown, frameLeft, frameDestroy);
    }

    @Override
    public void update() {
        animationFrame.loadFrame(status);
    }

    public void updatePosition (KeyCode direc) {
        boolean collision = false;
        oldPosY = y;
        oldPosX = x;
        if(direc == KeyCode.UP) {
            y -=  speed;
            status = 1;
        } else if(direc == KeyCode.RIGHT) {
            x +=  speed;
            status = 2;
        } else if(direc == KeyCode.DOWN) {
            y +=  speed;
            status = 3;
        } else if(direc == KeyCode.LEFT) {
            x -=  speed;
            status = 4;
        }  else if (direc == KeyCode.SPACE) {

        } else if(direc == null) {
            status = 0;
        }
        if(checkCollision() != -1) {
            System.out.println(x);
            System.out.println(y);
            x = oldPosX;
            y  = oldPosY;
            System.out.println(x);
            System.out.println(y);
        }

    }

}
