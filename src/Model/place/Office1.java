package Model.place;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Office1 extends Place{
    Controller controller;
    public Rectangle doorHall;
    public Rectangle wall1;
    public Rectangle wall2;
    public Rectangle table;
    public Rectangle key;

    public Office1(Controller controller) {
        this.controller=controller;
        player = controller.player;

        moveZone = new Rectangle(395, 185, 781, 530);
        wall1 = new Rectangle(395, 185, 330, 90);
        wall2 = new Rectangle(395, 530, 330, 200);
        table = new Rectangle(880, 550, 250, 180);
        doorHall = new Rectangle(300, 285, 10, 200);
        key = new Rectangle(1080, 680, 80, 30);

        x=300;
        y=0;
        width=971;
        height=720;
        mapTexture = new ImageIcon("img/room1.png");
    }


    public void update() {
        player.getZones();

        if (player.playerRect.intersects(wall1)
                ||player.playerRect.intersects(wall2)
                ||player.playerRect.intersects(table)) {
            player.setOldXY();
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.setOldXY();
        }
        if (player.playerRect.intersects(key) && !player.hasKey) {
            player.hasKey = true;
            controller.key = null;
        }

        if (player.playerRect.intersects(doorHall)) {
            controller.changePlace(doorHall);
            player.x = 200;
            player.y = 280;
        }
    }
}
