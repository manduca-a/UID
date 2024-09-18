import javax.swing.*;
import java.awt.*;

public class Finestra {
    public static void main(String[] args){
        JFrame f = new JFrame("Programma");
        f.setSize(800,400);
        JTextArea ta = new JTextArea();
        ta.setLineWrap( true );
        ta.setWrapStyleWord( true );
        ta.setSize(300,200);
        JPanel primo = new JPanel();
        primo.setBackground(Color.RED);
        JPanel p1 = new JPanel();
        p1.setBackground(Color.BLUE);
        p1.add(ta);
        JPanel p2 = new JPanel();
        p2.setBackground(Color.RED);
        JTabbedPane tabb = new JTabbedPane();
        tabb.addTab("Primo Tab", p1);
        tabb.addTab("Secondo Tab", p2);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,primo,tabb);
        splitPane.setDividerLocation(200);


        f.add(splitPane);
        f.setVisible(true);

    }
}
