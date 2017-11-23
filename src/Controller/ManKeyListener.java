package Controller;

import Model.Player;
import Model.PlayerCar;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManKeyListener extends KeyAdapter{
    public Player player;
    public Controller controller;
    public PlayerCar playerCar;

    private ImageIcon plCar_c = new ImageIcon("img/car3.png");
    private ImageIcon plCar_u = new ImageIcon("img/car3up.png");
    private ImageIcon plCar_d = new ImageIcon("img/car3down.png");

    public ManKeyListener(Controller controller) {
        this.controller = controller;
        player = controller.player;
        playerCar = controller.playerCar;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == 68 || key == KeyEvent.VK_RIGHT) {
            player.right = true;
            playerCar.dv = 1;
        }
        if (key == 65 || key == KeyEvent.VK_LEFT) {
            player.left = true;
            playerCar.dv = -1;
        }
        if (key == 87 || key == KeyEvent.VK_UP) {
            player.up = true;
            playerCar.dy = 4;
            playerCar.imgIcon = plCar_u;
        }
        if (key == 83 || key == KeyEvent.VK_DOWN) {
            player.down = true;
            playerCar.dy = -4;
            playerCar.imgIcon = plCar_d;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == 68 || key == KeyEvent.VK_RIGHT) {
            player.right = false;
            stopIncreasingDx();
        }
        if (key == 65 || key == KeyEvent.VK_LEFT) {
            player.left = false;
            stopIncreasingDx();
        }
        if (key == 87 || key == KeyEvent.VK_UP) {
            player.up = false;
            stopIncreasingDy();
        }
        if (key == 83 || key == KeyEvent.VK_DOWN) {
            player.down = false;
            stopIncreasingDy();
        }

    }

    private void stopIncreasingDx(){
        playerCar.dv = 0;
    }
    private void stopIncreasingDy(){
        playerCar.dy = 0;
        playerCar.imgIcon = plCar_c;
    }
}
