package Model.place;


import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Office3 extends Place{
    Controller controller;
    public Rectangle doorHall;
    public Rectangle table1;
    public Rectangle table2;
    public Rectangle table3_4;
    public Rectangle worker;
    public Rectangle wall;


    public Office3(Controller controller) {
        this.controller=controller;
        player = controller.player;

        moveZone = new Rectangle(225, 50, 1030, 525);
        table1 = new Rectangle(150, 0, 290, 220);
        table2 = new Rectangle(700, 0, 290, 235);
        table3_4 = new Rectangle(140, 470, 600, 120);
        worker = new Rectangle(240, 420, 90, 50);
        wall = new Rectangle(1050, 0, 300, 280);
        doorHall = new Rectangle(1345, 290, 10, 280);

        x=100;
        y=0;
        width=1256;
        height=601;
        mapTexture = new ImageIcon("img/room3.png");
    }


    public void update() {

        player.getZones();

        if (player.playerRect.intersects(table1)
                ||player.playerRect.intersects(table2)
                ||player.playerRect.intersects(table3_4)
                ||player.playerRect.intersects(worker)
                ||player.playerRect.intersects(wall)) {
            player.setOldXY();
        }

        if (!player.playerRect.intersects(moveZone)) {
            player.setOldXY();
        }

        if (player.playerRect.intersects(doorHall)) {
            controller.changePlace(doorHall);
            player.x = 1150;
            player.y = 280;
        }
    }
}
