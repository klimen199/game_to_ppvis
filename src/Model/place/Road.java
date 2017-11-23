package Model.place;


import Controller.Controller;
import Controller.MyThread;
import Model.Enemy;
import Model.Player;
import Model.PlayerCar;

import javax.swing.*;
import java.util.*;
import java.util.List;

public class Road extends Place {
    private Controller controller;
    private PlayerCar playerCar;

    MyThread enFactory;

    public Road(Controller controller){
        this.controller=controller;
        player = controller.player;
        playerCar = controller.playerCar;

        enFactory = new MyThread(controller, this);



        x=0;
        y=0;
        width=1700;
        height=800;
        mapTexture = new ImageIcon("img/carRoad1.png");
    }

    public void update() {

    }

    public void startFactory(){
        enFactory.start();
    }

}
