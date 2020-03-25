import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class End extends JPanel {
    static JLabel label1 = new JLabel();
    static JButton button1 = new JButton();

    End(){
        this.setLayout(null);

        this.add(label1);
        this.add(button1);

        menu();
    }

    public static void menu(){
        label1.setBounds(200, 160, 500, 23);
        label1.setText("You lost");
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setVerticalAlignment(SwingConstants.CENTER);

        button1.setBounds(350, 200, 200, 43);
        button1.setText("Retry?");
        button1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MAIN.changePanel(MAIN.play);
            }
        });
    }
}
