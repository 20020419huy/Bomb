package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Alien extends DynamicEntity {
    protected double speed = 1;
    public Alien(int xUnit, int yUnit, Image img, List<Entity> map) {
        super(xUnit, yUnit, img, map);
    }

    @Override
    public void update() {

    }

    protected void autoMove() {
        if(status == 0) {
            status = (int) (Math.random() * (4 - 1 + 1) + 1);
        }
        move(1);
        if(checkCollision() == 0) {
            move(-1);
            int tempStatus = status;
            while (true) {
                tempStatus = (int) (Math.random() * (4 - 1 + 1) + 1);
                if(tempStatus != status) {
                    break;
                }
            }
            status = tempStatus;
        }

    }

    private void move(int type) {
        if(status == 1) {
            y -= type * speed;
        } else if(status == 2) {
            x += type * speed;
        } else if(status == 3) {
            y += type * speed;
        } else if (status == 4) {
            x -= type * speed;
        }
    }

}
