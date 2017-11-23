package View;


import Controller.Controller;
import Model.Enemy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;

public class DrawPlace extends JPanel implements ActionListener {
    Controller controller;
    MainFrame mainFrame;
    Timer mainTimer = new Timer(20,this);
    boolean playing;

    public DrawPlace(Controller controller,MainFrame mainFrame)
    {
        this.controller=controller;
        this.mainFrame = mainFrame;
        this.playing = false;
    }

    public void paint(Graphics g)
    {
        if(controller.place==controller.placeMap.hall)drawHall(g);
        else {
            if(controller.place==controller.placeMap.office1)drawOffice1(g);
            else if(controller.place==controller.placeMap.office2)drawOffice2(g);
            else if(controller.place==controller.placeMap.office3)drawOffice3(g);
        }
        if(controller.place==controller.placeMap.road){
            if(controller.player.hasKey) {
                drawRoad(g);
                mainTimer.start();
                if (!playing) {
                    controller.placeMap.road.startFactory();
                    playing = true;
                }
            }
            else{
                controller.place=controller.placeMap.hall;
                controller.player.x=1270;
                controller.player.y=350;
                drawHall(g);
            }
        }
        else
            drawPlayer(g);
        controller.place.update();
        controller.player.move();
        mainFrame.frame.repaint();
    }


    public void drawHall(Graphics g) {
        g.drawImage(controller.place.mapTexture.getImage(),
                controller.place.x,
                controller.place.y,
                controller.place.width,
                controller.place.height,
                null);
        g.drawRect(1370, 490, 10, 150);
//        g.drawRect(200, 490, 110, 10);
//        g.drawRect(655, 490, 110, 10);
//        g.drawRect(1150, 490, 110, 10);
//        g.drawRect(220, 500, 1060, 130);
    }

    public void drawOffice1(Graphics g) {
        g.drawImage(controller.place.mapTexture.getImage(),
                controller.place.x,
                controller.place.y,
                controller.place.width,
                controller.place.height,
                null);
        if(controller.key != null){
            g.drawImage(controller.key.keyImgIcon.getImage(),
                    controller.key.x,
                    controller.key.y,
                    controller.key.width,
                    controller.key.height,
                    null);
        }
        //g.drawRect(1080, 680, 80, 30);
//        g.drawRect(395, 185, 781, 530);
//
//        g.drawRect(300, 285, 10, 200);
//
//        Color newColor = new Color(0, 255, 255);
//        g.setColor(newColor);
//        g.drawRect(395, 185, 330, 90);
//        g.drawRect(395, 530, 330, 200);
//        g.drawRect(880, 550, 250, 180);
    }

    public void drawOffice2(Graphics g) {
        g.drawImage(controller.place.mapTexture.getImage(),
                controller.place.x,
                controller.place.y,
                controller.place.width,
                controller.place.height,
                null);
//        g.drawRect(195, 95, 800, 580);
//
//        g.drawRect(100, 95, 10, 145);
//
//        Color newColor = new Color(0, 255, 255);
//        g.setColor(newColor);
//
//        g.drawRect(750, 165, 240, 310);
//        g.drawRect(830, 115, 80, 60);
//        g.drawRect(100, 260, 35, 445);
    }

    public void drawOffice3(Graphics g) {
        g.drawImage(controller.place.mapTexture.getImage(),
                controller.place.x,
                controller.place.y,
                controller.place.width,
                controller.place.height,
                null);
//        g.drawRect(225, 50, 1030, 525);
//
//        g.drawRect(1345, 290, 10, 280);
//
//        Color newColor = new Color(0, 255, 255);
//        g.setColor(newColor);
//
//        g.drawRect(150, 0, 290, 220);
//        g.drawRect(700, 0, 290, 235);
//        g.drawRect(140, 470, 600, 120);
//        g.drawRect(240, 420, 90, 50);
//        g.drawRect(1050, 0, 300, 280);
    }

    public void drawRoad(Graphics g) {
        g.drawImage(controller.place.mapTexture.getImage(),
                controller.playerCar.roadLayer1,
                controller.place.y,
                null);
        g.drawImage(controller.place.mapTexture.getImage(),
                controller.playerCar.roadLayer2,
                controller.place.y,
                null);
        g.drawImage(controller.playerCar.imgIcon.getImage(),
                controller.playerCar.x,
                controller.playerCar.y,
                null);

        getStats(g);
        filterEnem(g);
    }

    public void drawPlayer(Graphics g) {
        if ((controller.player.down && !controller.player.left && !controller.player.right) ||
                (controller.player.up && !controller.player.left && !controller.player.right))
            g.drawImage(new ImageIcon(controller.player.manRight.get(controller.player.manCounter)).getImage(),
                    controller.player.x,
                    controller.player.y,
                    controller.player.width,
                    controller.player.height,
                    null);
        if (controller.player.right)
            g.drawImage(new ImageIcon(controller.player.manRight.get(controller.player.manCounter)).getImage(),
                    controller.player.x,
                    controller.player.y,
                    controller.player.width,
                    controller.player.height,
                    null);
        if (controller.player.left)
            g.drawImage(new ImageIcon(controller.player.manLeft.get(controller.player.manCounter)).getImage(),
                    controller.player.x,
                    controller.player.y,
                    controller.player.width,
                    controller.player.height,
                    null);
        if (!controller.player.up && !controller.player.down && !controller.player.left && !controller.player.right)
            g.drawImage(new ImageIcon(controller.player.manStand.get(0)).getImage(),
                    controller.player.x,
                    controller.player.y,
                    controller.player.width,
                    controller.player.height,
                    null);

        //g.drawRect(controller.player.x, controller.player.y, controller.player.width, controller.player.height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.playerCar.move();
        Iterator<Enemy> i = controller.enemies.iterator();
        while (i.hasNext()){
            Enemy en = i.next();
            en.move();
        }
        mainFrame.frame.repaint();
        testCollision();
        testWin();
    }

    private void getStats(Graphics g){
        int left_s = (int)(controller.playerCar.WIN_S - controller.playerCar.s)/100;
        g.setColor(Color.WHITE);
        Font speedFont =  new Font("Arial", Font.ITALIC, 20);
        g.setFont(speedFont);
        ((Graphics2D) g).drawString("Speed: " + controller.playerCar.imagineV +" km/h",100,30);
        ((Graphics2D) g).drawString("Health: " + controller.playerCar.health +" %",300,30);
        ((Graphics2D) g).drawString("Left path: " + left_s,500,30);
    }

    private void filterEnem(Graphics g){
        Iterator<Enemy> i = controller.enemies.iterator();
        while (i.hasNext()){
            Enemy e = i.next();
            if(e.x <= -controller.place.width*1.2 || e.x > controller.place.width*1.2) {
                i.remove();
            }
            else{
                ((Graphics2D) g).drawImage(e.imgIcon.getImage(),e.x,e.y,null);
            }
        }
    }

    public void testWin() {
        if (controller.playerCar.s > controller.playerCar.WIN_S) {
            JOptionPane.showMessageDialog(null, "Successful hijacking! You are a great thief =)");
            System.exit(0);
        }
    }

    public void testCollision() {
        Random rand = new Random();
        Iterator<Enemy> i = controller.enemies.iterator();
        double koef = (double) controller.playerCar.v/controller.playerCar.MAX_V;
        int koefVstrechki;
        while (i.hasNext()) {
            Enemy e = i.next();
            if (controller.playerCar.getContour().intersects(e.getContour())) {
                i.remove();
//                if(e.y < road.height/2) koefVstrechki = 2;
                if(e.y < 400) koefVstrechki = 3;
                else koefVstrechki = 1;
                controller.playerCar.health -= (int)(rand.nextInt(7) + 7)*koef * koefVstrechki;
                if (controller.playerCar.health <= 0) {
                    controller.playerCar.health = 0;
                    JOptionPane.showMessageDialog(null, "You crushed a car and... Have a good time in prison =)");
                    System.exit(1);
                }
            }
        }

    }

}
