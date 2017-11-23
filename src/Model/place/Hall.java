package Model.place;


import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Hall extends Place {
    Controller controller;
    public Rectangle door1;
    public Rectangle door2;
    public Rectangle door3;
    public Rectangle doorExit;


    public Hall(Controller controller) {
        this.controller=controller;
        player = controller.player;

        moveZone = new Rectangle(220, 500, 1060, 130);
        door1 = new Rectangle(200, 490, 110, 10);
        door2 = new Rectangle(655, 490, 110, 10);
        door3 = new Rectangle(1150, 490, 110, 10);
        doorExit = new Rectangle(1370, 490, 10, 150);

        x=120;
        y=120;
        width=1260;
        height=518;
        mapTexture = new ImageIcon("img/hall.png");
    }


    public void update() {
        controller.player.getZones();

        if (player.playerRect.intersects(door1)) {
            controller.changePlace(door1);
            player.x = 320;
            player.y = 200;
        } else
        if (player.playerRect.intersects(door2)) {
            controller.changePlace(door2);
            player.x = 130;
            player.y = -10;
        }
        if (player.playerRect.intersects(door3)) {
            controller.changePlace(door3);
            player.x = 1220;
            player.y = 250;
        }
        if (player.playerRect.intersects(doorExit)) {
            controller.changePlace(doorExit);
            player.x = 200;
            player.y = 200;
        }
        if (!player.playerRect.intersects(moveZone)) {
            controller.player.setOldXY();
        }
    }
}
