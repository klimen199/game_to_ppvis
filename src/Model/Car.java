package Model;


import javax.swing.*;
import java.awt.*;

public abstract class Car {
    public ImageIcon imgIcon;
    public int v;
    public int x, y;
    public int width, height;

    public Car(ImageIcon img, int x, int y, int v){
        this.imgIcon = img;
        this.v = v;
        this.x = x;
        this.y = y;
        this.width = imgIcon.getIconWidth();
        this.height = imgIcon.getIconHeight();
    }

    public Rectangle getContour() {
        return new Rectangle(x, y+10,width,height-20);
    }

    public abstract void move();
}
