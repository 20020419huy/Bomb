package uet.oop.bomberman.graphics;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import uet.oop.bomberman.entities.Entity;
import javafx.scene.image.Image;
import java.util.ArrayList;

public class AnimationFrame {
    private boolean isPressed = false;
    private Timeline timeline = null;
    private Entity entity = null;
    private double time;
    private ArrayList<Sprite> frames;
    private ArrayList<Sprite> framesUp;
    private ArrayList<Sprite> framesRight;
    private ArrayList<Sprite> framesDown;
    private ArrayList<Sprite> framesLeft;
    private ArrayList<Sprite> frameDestroy;

    public AnimationFrame(Entity entity, double time, ArrayList<Sprite> framesUp, ArrayList<Sprite> framesRight, ArrayList<Sprite> framesDown, ArrayList<Sprite> framesLeft, ArrayList<Sprite> frameDestroy) {
        this.entity = entity;
        this.time = time;
        this.framesUp = framesUp;
        this.framesRight = framesRight;
        this.framesDown = framesDown;
        this.framesLeft = framesLeft;
        this.frameDestroy = frameDestroy;

    }

    public AnimationFrame(Entity entity, int time ,ArrayList<Sprite> framesDestroy) {
        this.entity = entity;
        this.time = time;
        this.framesUp = framesDestroy;
    }

    public void loadFrame(int status) {
        if(status == 1) {
            frames = framesUp;
        } else if (status == 2) {
            frames = framesRight;
        } else if (status == 3) {
            frames = framesDown;
        } else if(status == 4) {
            frames = framesLeft;
        } else if (status == -1) {
            frames = frameDestroy;
        }

        if(status != 0){
            if(isPressed == false) {
                isPressed = true;
                timeline = new Timeline(
                        new KeyFrame(Duration.millis(0), (ActionEvent actionEvent) -> {
                            entity.sprite = frames.get(0);
                        }),
                        new KeyFrame(Duration.millis(time), (ActionEvent actionEvent) -> {
                            entity.sprite = frames.get(1);
                        }),
                        new KeyFrame(Duration.millis(time * 2), (ActionEvent actionEvent) -> {
                            entity.sprite = frames.get(2);
                        })
                );
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
            }
        } else {
            if(frames != null) {
                entity.sprite = frames.get(0);
                timeline.pause();
            }
            isPressed = false;
        }
    }


}
