import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MAIN {
    static JFrame frame = new JFrame("Ping-Pong");
    static JPanel oldPanel = new JPanel();
    static JLabel label = new JLabel();
    static StartMenu menu = new StartMenu();
    static Game play = new Game();
    static End endScreen = new End();
    static Timer timer = new Timer(16, new refreshPanel());

    public static void main(String args[]){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(900, 550);
        frame.setLocationRelativeTo(null);
        frame.add(menu);
        oldPanel = menu;

        menu.add(label);

        timer.start();

        frame.validate();
        frame.repaint();
    }

    public static void changePanel(JPanel panel){
        frame.remove(oldPanel);
        frame.add(panel);
        oldPanel = panel;

        label.setText(MouseInfo.getPointerInfo().getLocation().toString());
        label.setBounds(0, 0, 1000, 20);
        panel.add(label);

        timer.start();

        frame.validate();
        frame.repaint();
        panel.grabFocus();
    }

    static class refreshPanel implements ActionListener {
        public void actionPerformed(ActionEvent e){
            label.setText(MouseInfo.getPointerInfo().getLocation().toString());
            label.setBounds(0, 0, 1000, 20);

            frame.validate();
            frame.repaint();
            oldPanel.repaint();
            timer.restart();
        }
    }
}
