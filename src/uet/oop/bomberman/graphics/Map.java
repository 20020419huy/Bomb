package uet.oop.bomberman.graphics;

import uet.oop.bomberman.entities.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Map {
    private String map1 = "/levels/Level1.txt";
    private String map2 = "/levels/Level2.txt";
    private String map3 = "/levels/Level3.txt";
    private List<Entity> entityList;
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public Map(List<Entity> entityList) {
        this.entityList = entityList;
    }

    public int createMap(int level) {
        URL url = null;
        File file = null;
        int posBomber = -1;
        Scanner scanner = null;
        if (level == 1) {
            url = getClass().getResource(this.map1);
        } else if(level == 2) {
            url = getClass().getResource(this.map2);
        } else {
            url = getClass().getResource(this.map3);
        }
        file = new File(url.getFile());
        try {
            scanner = new Scanner(file);
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    entityList.add(new Grass(j, i, Sprite.grass.getFxImage()));
                }
            }
            for (int i = 0; i < HEIGHT; i++) {
                String data = scanner.nextLine();
                for (int j = 0; j < WIDTH; j++) {
                    if(data.charAt(j) == '#') {
                        entityList.add(new Wall(j, i, Sprite.wall.getFxImage()));
                    } else if (data.charAt(j) == 'p') {
                        posBomber = entityList.size();
                        entityList.add(new Bomber(j, i, Sprite.player_right.getFxImage()));
                    } else if (data.charAt(j) == '*') {
                        entityList.add(new Brick(j, i, Sprite.brick.getFxImage()));
                    } else if (data.charAt(j) == 'X') {
                        entityList.add(new Portal(j, i, Sprite.portal.getFxImage()));
                    } else if (data.charAt(j) == '1') {
                        entityList.add(new Balloon(j, i, Sprite.balloom_right1.getFxImage()));
                    } else if (data.charAt(j) == '2') {
                        entityList.add(new Oneal(j ,i, Sprite.oneal_right1.getFxImage()));
                    } else if (data.charAt(j) == 'b') {
                        entityList.add(new BombItem(j, i, Sprite.bomb.getFxImage()));
                    } else if (data.charAt(j) == 'f') {
                        entityList.add(new FlameItem(j, i, Sprite.powerup_flames.getFxImage()));
                    } else if(data.charAt(j) == 's') {
                        entityList.add(new SpeedItem(j, j, Sprite.powerup_speed.getFxImage()));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("lỗi load map của level " + Integer.toString(level));
        }
        return posBomber;
    }

}
