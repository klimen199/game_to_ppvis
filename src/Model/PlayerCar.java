package Model;


import javax.swing.*;
import java.awt.*;


public class PlayerCar extends Car{
    public static final int MAX_V = 45;
    public static final int MIN_V = 26;
    private static final int MAX_TOP = 45;
    private static final int MAX_BOTTOM = 575;
    public static final int WIN_S = 80000;

    private ImageIcon plCar_c = new ImageIcon("img/car3.png");
    private ImageIcon plCar_u = new ImageIcon("img/car3up.png");
    private ImageIcon plCar_d = new ImageIcon("img/car3down.png");

    public int dv = 0, // ускорение
            dy = 0,
            s= 0,
            imagineV,
            health =100;
    public int roadLayer1 = 0,
            roadLayer2 = 1700; // слой дороги


    public PlayerCar() {
        super(new ImageIcon("img/car3.png"),100,400,20);
    }


    public void move(){
        imagineV = 200*v / MAX_V; // пусть 200км/ч - макисмальная скорость
        s += v;

        v += dv;
        if(v <=MIN_V) v = MIN_V;
        if(v>=MAX_V) v = MAX_V;

        y -=dy;
        if(y<=MAX_TOP) y = MAX_TOP;
        if(y>=MAX_BOTTOM) y = MAX_BOTTOM;

        if (roadLayer2-v <=0){
            roadLayer1 = roadLayer2 - v;
            roadLayer2 = roadLayer1 + 1700;
        }
        else{
            roadLayer1 -= v;
            roadLayer2 -= v;
        }
    }

}


