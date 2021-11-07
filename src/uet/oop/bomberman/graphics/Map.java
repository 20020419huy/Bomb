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
        File file = null;
        int posBomber = -1;
        Scanner scanner = null;
        URL url = getClass().getResource("/levels/Level" + Integer.toString(level) + ".txt");
        file = new File(url.getFile());
        try {
            scanner = new Scanner(file);
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    entityList.add(new Grass(j, i, Sprite.grass));
                }
            }
            for (int i = 0; i < HEIGHT; i++) {
                String data = scanner.nextLine();
                for (int j = 0; j < WIDTH; j++) {
                    if(data.charAt(j) == '#') {
                        entityList.add(new Wall(j, i, Sprite.wall));
                    } else if (data.charAt(j) == 'p') {
                        posBomber = entityList.size();
                        entityList.add(new Bomber(j, i, Sprite.player_right, entityList));
                    } else if (data.charAt(j) == '*') {
                        entityList.add(new Brick(j, i, Sprite.brick));
                    } else if (data.charAt(j) == 'X') {
                        entityList.add(new Portal(j, i, Sprite.portal));
                    } else if (data.charAt(j) == '1') {
                        entityList.add(new Balloon(j, i, Sprite.balloom_right1, entityList));
                    } else if (data.charAt(j) == '2') {
                        entityList.add(new Oneal(j ,i, Sprite.oneal_right1, entityList));
                    } else if (data.charAt(j) == 'b') {
                        entityList.add(new BombItem(j, i, Sprite.bomb));
                    } else if (data.charAt(j) == 'f') {
                        entityList.add(new FlameItem(j, i, Sprite.powerup_flames));
                    } else if(data.charAt(j) == 's') {
                        entityList.add(new SpeedItem(j, j, Sprite.powerup_speed));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("lỗi load map của level " + Integer.toString(level));
        }
        return posBomber;
    }

}
