package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class DynamicEntity extends Entity{
    protected List<Entity> map;
    public DynamicEntity(int xUnit, int yUnit, Sprite sprite, List<Entity> map) {
        super(xUnit, yUnit, sprite);
        this.map = map;
    }

    @Override
    public void update() {

    }

    protected int checkCollision() {
        if(this instanceof Bomber) {
            System.out.println("x: " + this.x);
            System.out.println("y: " + this.x);
            System.out.println("width: " + this.sprite._realWidth);
            System.out.println("height: " + this.sprite._realHeight);
        }

        return 1;
    }
}
