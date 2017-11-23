import Controller.Controller;
import View.MainFrame;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        MainFrame mainFrame = new MainFrame(controller);
    }
}
