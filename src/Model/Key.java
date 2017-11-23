package Model;


import javax.swing.*;

public class Key {
    public ImageIcon keyImgIcon;
    public int x;
    public int y;
    public int width;
    public int height;

    public Key(){
        keyImgIcon = new ImageIcon("img/auto_key.png");
        x = 1070;
        y = 590;
        width = keyImgIcon.getIconWidth();
        height = keyImgIcon.getIconHeight();
    }
}
