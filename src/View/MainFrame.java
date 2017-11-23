package View;


import Controller.Controller;
import Controller.ManKeyListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    JFrame frame;

    public MainFrame(Controller controller) {

        frame = new JFrame("Stole his Car");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new ManKeyListener(controller));
        frame.add(new DrawPlace(controller,this));
        frame.setSize(1550, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
