package Model;

import Controller.Controller;

import javax.swing.*;

public class Enemy extends Car {
    Controller controller;

    public Enemy(Controller controller, int x, int y, int v, ImageIcon imgIc){
        super(imgIc,x,y,v);
        this.controller = controller;
    }

    public void move(){
        x = x - controller.playerCar.v + v;
    }
}
