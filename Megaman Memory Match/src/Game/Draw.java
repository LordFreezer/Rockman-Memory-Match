package Game;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Draw extends JFrame
{

    ImageIcon cardBack = new ImageIcon(this.getClass()
            .getResource("/images/commanderbeef.jpeg"));
    public ImageIcon[] Icons;
    private ImageIcon temp;
    private int Score = 0;
    private int NGScore = 0;
    ImageIcon[] cards;
    String[] pics =
    {
        "/images/megaman.gif",
        "/images/bass.png",
        "/images/heatman.png",
        "/images/glyde.png",
        "/images/gutsman.png",
        "/images/iceman.png",
        "/images/protoman.png",
        "/images/roll.png",
    };
    String[] picsSwitch =
    {
        "/images/dog.gif",
        "/images/lan.gif",
    };
    int openImages;
    public int currentIndex;
    public int clickedIndex;
    public int numClicks;
    private final JButton[] b;
    private final JButton newGame = new JButton("New Game");
    private final JButton switchPic = new JButton("Click Me!!");
    private final JLabel labelN;
    private final JLabel labelNG;
    private final JPanel panelN;
    private final JPanel panelS;
    Timer myTimer = new Timer(1000, new TimerListener());
    int numButtons;

    public Draw()
    {
        switchPic.setEnabled(false);
        switchPic.setVisible(false);
        labelN = new JLabel();
        labelN.setText("The score is ???");
        labelNG = new JLabel();
        labelNG.setText("Round ???");
        panelN = new JPanel();
        panelS = new JPanel();
        panelN.setLayout(new java.awt.GridLayout(4, 1));
        panelS.setLayout(new java.awt.GridLayout(4, 4));
        numButtons = (pics.length * 2);
        b = new JButton[numButtons];
        Icons = new ImageIcon[numButtons];
        for (int i = 0, j = 0; i < pics.length; i++)
        {
            Icons[j] = new ImageIcon(this.getClass().getResource(pics[i]));
            j = MakeButtons(j);
            Icons[j] = Icons[j - 1];
            j = MakeButtons(j);
        }
        newGame.addActionListener(new Draw.ImageButtonListener());
        switchPic.addActionListener(new Draw.ImageButtonListener());
        Random rnd = new Random();
        for (int i = 0; i < numButtons; i++)
        {
            int j = rnd.nextInt(numButtons);
            temp = Icons[i];
            Icons[i] = Icons[j];
            Icons[j] = temp;
        }
        Container contentPane = getContentPane();
        contentPane.add(panelN, "North");
        contentPane.add(panelS, "Center");
        panelN.add(labelN);
        panelN.add(labelNG);
        panelN.add(newGame);
        panelN.add(switchPic);
    }

    private void switchP()
    {
        if ((NGScore % 2) == 0)
        {
            cardBack = new ImageIcon(this.getClass().getResource(picsSwitch[1]));
        } else
        {
            cardBack = new ImageIcon(this.getClass().getResource(picsSwitch[0]));
        }

        switchPic.setText("Now click New Game...");

    }

    private int MakeButtons(int j)
    {
        b[j] = new JButton("");
        b[j].addActionListener(new Draw.ImageButtonListener());
        b[j].setIcon(cardBack);
        b[j].setBackground(Color.WHITE);
        panelS.add(b[j++]);
        return j;
    }

    private void GameOver()
    {
        labelN.setText("YOU WON!!!!");
        labelNG.setText("YOU WON!!!!");
        switchPic.setEnabled(true);
        switchPic.setVisible(true);
        if (openImages > 35)
        {
            System.out.println("About Time!");
            System.out.println("░░░░█░▀▄░░░░░░░░░░▄▄███▀ \n"
                    + "░░░░█░░░▀▄░▄▄▄▄▄░▄▀░░░█▀ \n"
                    + "░░░░░▀▄░░░▀░░░░░▀░░░▄▀ \n"
                    + "░░░░░░░▌░▄▄░░░▄▄░▐▀▀\n"
                    + "░░░░░░▐░░█▄░░░▄█░░▌▄▄▀▀▀▀█ \n"
                    + "░░░░░░▌▄▄▀▀░▄░▀▀▄▄▐░░░░░░█ \n"
                    + "░░░▄▀▀▐▀▀░░░░░░░▀▀▌▄▄▄░░░█ \n"
                    + "░░░█░░░▀▄░░░░░░░▄▀░░░░█▀▀▀ \n"
                    + "░░░░▀▄░░▀░░▀▀▀░░▀░░░▄█▀");
        }
    }

    private void check()
    {
        if (openImages % 2 == 0)
        {
            if (currentIndex == clickedIndex)
            {
                numClicks--;
                return;
            }
            if (Icons[currentIndex] != Icons[clickedIndex])
            {
                myTimer.start();
            } else
            {
                Score++;
                if (Score == 8)
                {
                    GameOver();
                }
            }
        } else
        {
            clickedIndex = currentIndex;
        }
    }

    private void resetGame()
    {

        Random rnd = new Random();
        for (int i = 0; i < numButtons; i++)
        {
            b[i].setIcon(cardBack);
        }
        for (int k = 0; k < numButtons; k++)
        {
            int j = rnd.nextInt(numButtons);
            temp = Icons[k];
            Icons[k] = Icons[j];
            Icons[j] = temp;
        }
        NGScore++;
        switchPic.setText("I wonder what would happen if you clicked me and then New Game again???");
        labelN.setText("The Score is " + Score);
        labelNG.setText("Round " + NGScore);
    }

    private class TimerListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            b[currentIndex].setIcon(cardBack);
            b[clickedIndex].setIcon(cardBack);
            myTimer.stop();
        }
    }

    private class ImageButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (myTimer.isRunning())
            {
                return;
            }
            openImages++;
            System.out.println(openImages);
            switch (openImages)
            {
                case 35:
                    System.out.println("You stink at this game...");
                    break;
                case 45:
                    System.out.println("Do you need help?..");
                    break;
                case 65:
                    System.out.println("Had fun yet?");
                    break;
                case 80:
                    System.out.println("Either you're just playing with the gifs,"
                            + " or you are just bad");
                    break;
                default:
                    break;
            }
            for (int i = 0; i < numButtons; i++)
            {
                if (e.getSource() == b[i])
                {
                    b[i].setIcon(Icons[i]);
                    currentIndex = i;
                }
            }
            for (int l = 0; l < 1; l++)
            {
                if (e.getSource() == newGame)
                {
                    resetGame();
                }
            }
            for (int k = 0; k < 1; k++)
            {
                if (e.getSource() == switchPic)
                {
                    switchP();
                }
            }
            labelNG.setText("Round " + NGScore);
            labelN.setText("The Score is " + Score);
            check();
        }
    }
}
