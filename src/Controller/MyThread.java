package Controller;


import Model.Enemy;
import Model.place.Road;

import javax.swing.*;
import java.util.List;
import java.util.Random;

public class MyThread extends Thread {
    private Controller controller;
    private Road road;
    private int roadWidth;
    private int roadBandHeight;


    public MyThread(Controller controller, Road road){
        this.controller = controller;
        this.road = road;
    }


    @Override
    public void run() {
        roadWidth = road.width;
        roadBandHeight = (int)((road.height-120)/4);
        while (true) {
                Random rand = new Random();
                try {
                    Thread.sleep(rand.nextInt(3000));
                    controller.enemies.add(new Enemy(controller,
                            roadWidth + rand.nextInt(400),
                            roadBandHeight * rand.nextInt(2) + 65,
                            rand.nextInt(7) - 8,
                            new ImageIcon("img/car5from.png")));
                    controller.enemies.add(new Enemy(controller,
                            roadWidth + rand.nextInt(400),
                            roadBandHeight * 2 + roadBandHeight * rand.nextInt(2) + 70,
                            rand.nextInt(7) + 23,
                            new ImageIcon("img/car5to.png")));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }
}
