package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.SubClass.Duplicate;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class DynamicEntity extends Entity {
    protected List<Entity> map;

    public DynamicEntity(int xUnit, int yUnit, Sprite sprite, List<Entity> map) {
        super(xUnit, yUnit, sprite);
        this.map = map;
    }

    @Override
    public void update() {

    }

    protected int checkCollision() {
        if (this instanceof Alien) {
            for (int i = 0; i < map.size(); i++) {
                if (this != map.get(i)) {
                    boolean checkCollision = Duplicate.collision(this, map.get(i));
                    if ((map.get(i) instanceof Wall || map.get(i) instanceof Brick) && checkCollision) {
                        return 0; // va cham voi Wall va brick
                    }
                    if ((map.get(i) instanceof Alien) && checkCollision) {
                        return 1; // va cham voi bomber
//                    }
                        //if (map.get(i) instanceof)
                    }
                }
            }
        }
        if (this instanceof Bomber) {
            for (int i = 0; i < map.size(); i++) {
                if (this != map.get(i)) {
                    boolean checkCollision = Duplicate.collision(this, map.get(i));
                    if ((map.get(i) instanceof Wall || map.get(i) instanceof Brick) && checkCollision) {
                        return 3; // va cham voi Wall va brick
                    }
                    if ((map.get(i) instanceof Alien) && checkCollision) {
                        return 4; // va cham voi bomber
                    }
                    //if (map.get(i) instanceof)
                }
            }
        }
        return -1;
    }
}
