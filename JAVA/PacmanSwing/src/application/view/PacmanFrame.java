package application.view;

import application.Settings;
import application.controller.PacmanController;

import javax.swing.*;
import java.awt.*;

public class PacmanFrame {

    public static void launch() {
        JFrame frame = new JFrame();
        frame.setSize(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE);
        PacmanView view = new PacmanView();         //  crea una PacmanView
        PacmanController controller = new PacmanController(view);
        view.addKeyListener(controller);
        view.setFocusable(true);
        view.requestFocus();
        frame.add(view);
        frame.setUndecorated(true);
        //   Mettiamo la finestra al centro dello schermo
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDimension = toolkit.getScreenSize();
        int x = (screenDimension.width - frame.getWidth())/2;
        int y = (screenDimension.height - frame.getHeight())/2;
        frame.setLocation(x, y);
        frame.setVisible(true);
    }
}
