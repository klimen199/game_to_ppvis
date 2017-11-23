package Model;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public int x = 1270;
    public int y = 350;
    public int width = 96;
    public int height = 256;
    public int xOld;
    public int yOld;
    public int animationSpeed = 0;
    public boolean hasKey = false;


    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;

    public List<String> manLeft = new ArrayList();
    public List<String> manRight = new ArrayList();
    public List<String> manStand = new ArrayList();
    public int manCounter = 0;

    public Rectangle playerRect;

    public Player(){
        manLeft.add("img/left1.png");
        manLeft.add("img/left2.png");
        manLeft.add("img/left3.png");
        manLeft.add("img/left4.png");
        manLeft.add("img/left5.png");
        manLeft.add("img/left6.png");

        manRight.add("img/right1.png");
        manRight.add("img/right2.png");
        manRight.add("img/right3.png");
        manRight.add("img/right4.png");
        manRight.add("img/right5.png");
        manRight.add("img/right6.png");

        manStand.add("img/right0.png");

        playerRect = new Rectangle(x, y+250, width, height-250);

        xOld = x;
        yOld = y;
    }

    public void move() {
        xOld = x;
        yOld = y;
        getZones();
            if (down) y++;
            if (right) x++;
            if (left) x--;
            if (up) y--;
            if (animationSpeed == 30) {
                manCounter++;
                animationSpeed = 0;
            }
            if (manCounter > 5) manCounter = 0;
            animationSpeed++;
    }

    public void setOldXY() {
        x=xOld;
        y=yOld;
    }

    public void getZones() {
        playerRect = new Rectangle(x, y+250, width, height-250);
    }
}
