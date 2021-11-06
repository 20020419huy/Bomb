package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class DynamicEntity extends Entity{
    protected List<Entity> map;
    public DynamicEntity(int xUnit, int yUnit, Image img, List<Entity> map) {
        super(xUnit, yUnit, img);
        this.map = map;
    }

    @Override
    public void update() {

    }

    protected int checkCollision() {
        return 1;
    }
}
