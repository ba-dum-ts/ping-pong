import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel {
    static int player_x = 0, ball_x = 425;                       //  -->  positioner
    static int player1_y = 190, player2_y = 190, ball_y = 200;   //  ^
    static int playerWidth = 5, ballWidth = 50;                  //  |
    static int playerHeight = 90, ballHeight = 50;               //  |
    static int moveBall_x = 1;                                   //  |
    static int moveBall_y = -1;                                  //  v

    Game(){
        this.addKeyListener(new playerMovement());
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(player_x, player1_y, playerWidth, playerHeight);  // spelare 1

        g.setColor(Color.BLACK);
        g.fillRect(player_x + 879, player2_y, playerWidth, playerHeight);  // spelare 2

        g.setColor(Color.RED);
        g.fillOval(ball_x, ball_y, ballWidth, ballHeight);  // boll

        ball_x = ball_x + moveBall_x;
        ball_y = ball_y + moveBall_y;

        if(ball_x == 834){
            System.out.println("too far right");

            ball_x = 425;
            ball_y = 200;

            MAIN.changePanel(MAIN.endScreen);
        }

        else if(ball_y == 462){
            System.out.println("too far bottom");

            moveBall_y = -moveBall_y;
        }

        else if(ball_x == -3){
            System.out.println("too far left");

            ball_x = 425;
            ball_y = 200;

            MAIN.changePanel(MAIN.endScreen);
        }

        else if(ball_y == 0){
            System.out.println("too far up");

            moveBall_y = -moveBall_y;
        }

        else if(ball_x == player_x + playerWidth && ball_x == player1_y){
            moveBall_x = -moveBall_x;
        }
    }

    static class playerMovement implements KeyListener {
        public void keyTyped(KeyEvent e) {}

        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP){
                if(player2_y == 0){

                }

                else{
                    player2_y = player2_y - 10;
                }
            }
            else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                if(player2_y == 420){

                }

                else {
                    player2_y = player2_y + 10;
                }
            }

            else if(e.getKeyCode() == KeyEvent.VK_W){
                if(player1_y == 0){

                }

                else {
                    player1_y = player1_y - 10;
                }
            }

            else if(e.getKeyCode() == KeyEvent.VK_S){
                if(player1_y == 420){

                }

                else {
                    player1_y = player1_y + 10;
                }
            }
        }

        public void keyReleased(KeyEvent e) {

        }
    }
}

