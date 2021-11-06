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
    private ArrayList<Image> frames;
    private ArrayList<Image> framesUp;
    private ArrayList<Image> framesRight;
    private ArrayList<Image> framesDown;
    private ArrayList<Image> framesLeft;
    private ArrayList<Image> frameDestroy;

    public AnimationFrame(Entity entity, double time, ArrayList<Image> framesUp, ArrayList<Image> framesRight, ArrayList<Image> framesDown, ArrayList<Image> framesLeft, ArrayList<Image> frameDestroy) {
        this.entity = entity;
        this.time = time;
        this.framesUp = framesUp;
        this.framesRight = framesRight;
        this.framesDown = framesDown;
        this.framesLeft = framesLeft;
        this.frameDestroy = frameDestroy;

    }

    public AnimationFrame(Entity entity, int time ,ArrayList<Image> framesDestroy) {
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
                            entity.img = frames.get(0);
                        }),
                        new KeyFrame(Duration.millis(time), (ActionEvent actionEvent) -> {
                            entity.img = frames.get(1);
                        }),
                        new KeyFrame(Duration.millis(time * 2), (ActionEvent actionEvent) -> {
                            entity.img = frames.get(2);
                        })
                );
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
            }
        } else {
            if(frames != null) {
                entity.img = frames.get(0);
                timeline.pause();
            }
            isPressed = false;
        }
    }


}
