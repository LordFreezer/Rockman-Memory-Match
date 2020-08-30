package Game;
import java.awt.Toolkit;
import javax.swing.JFrame;
public class Main extends JFrame
{
    public static void main(String[] args)
    {
        System.out.println("░░░░░░░░▄▄█▀▀▄░░░░░░░ \n"
                + "░░░░░░▄█████▄▄█▄░░░░░ \n"
                + "░░░░░▄▀██████▄▄██░░░░ \n"
                + "░░░░░█░█▀░░▄▄▀█░█░░░░ \n"
                + "░░░░░▄██░░░▀▀░▀░█░░░░ \n"
                + "░░▄█▀░░▀█░▀▀▀▀▄▀▀█▄░░ \n"
                + "░▄███░▄░░▀▀▀▀▀▄░███▄░ \n"
                + "░██████░░░░░░░██████░ \n"
                + "░▀███▀█████████▀███▀░ \n"
                + "░░░░▄█▄░▀▀█▀░░░█▄░░░░ \n"
                + "░▄▄█████▄▀░▀▄█████▄▄░ \n"
                + "█████████░░░█████████");
        JFrame frame = new Draw();
        frame.setTitle("Megaman Matching Game");
        frame.setSize(1000, 1000);
        frame.setLocation(500, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit()
        .getImage(Main.class
        .getResource("/images/megaman.gif")));
        frame.setVisible(true);
        
    }
}
