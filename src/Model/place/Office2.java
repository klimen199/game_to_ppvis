package Model.place;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Office2 extends Place {
    Controller controller;
    public Rectangle doorHall;
    public Rectangle table;
    public Rectangle worker;
    public Rectangle wall;

    public Office2(Controller controller) {
        this.controller=controller;
        player = controller.player;

        moveZone = new Rectangle(195, 95, 800, 580);
        table = new Rectangle(750, 165, 240, 310);
        worker = new Rectangle(830, 115, 80, 60);
        wall = new Rectangle(100, 260, 35, 445);
        doorHall = new Rectangle(100, 95, 10, 155);

        x=100;
        y=0;
        width=1025;
        height=720;
        mapTexture = new ImageIcon("img/room2.png");
    }


    public void update() {
        player.getZones();


        if (player.playerRect.intersects(table)
                || player.playerRect.intersects(worker)
                || player.playerRect.intersects(wall)) {
            player.setOldXY();
        }
        if (!player.playerRect.intersects(moveZone)) {
            player.setOldXY();
        }

        if (player.playerRect.intersects(doorHall)) {
            controller.changePlace(doorHall);
            player.x = 655;
            player.y = 280;
        }
    }
}
