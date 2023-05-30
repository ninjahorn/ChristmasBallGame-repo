import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Frame extends JFrame implements ActionListener {

    JButton startButton;
    JButton ballButton1;
    JButton ballButton2;
    JButton ballButton3;
    JButton ballButton4;
    JLabel scoreLabel;
    JLabel timerLabel;
    JLabel textLabel;
    Random random = new Random();
    int score;
    int x;
    Timer timer;
    int second;

    Frame() {

        //Frame settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ChristmasBallGame");
        this.setSize(750, 500);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);

        score = 0;

        //Image icon
        ImageIcon ballImage = new ImageIcon(getClass().getResource("christmasball.png"));
        ImageIcon treeImage = new ImageIcon(getClass().getResource("christmastree.png"));

        //create startButton
        startButton = new JButton("START");
        startButton.setBounds(35, 320, 200, 100);
        startButton.addActionListener(this);
        startButton.setFocusable(false);
        startButton.setFont(new Font("Copperplate Gothic", Font.BOLD, 30));

        //create textLabel1
        textLabel = new JLabel();
        textLabel.setText("Drücke auf die Kugeln!");
        textLabel.setFont(new Font("Copperplate Gothic", Font.BOLD, 20));
        textLabel.setBounds(30, 130, 350, 200);

        //create treeLabel
        JLabel treeLabel = new JLabel();
        treeLabel.setIcon(treeImage);
        treeLabel.setBounds(340, 20, 370, 554);

        //create scoreLabel
        scoreLabel = new JLabel("Score: " + String.valueOf(score));
        scoreLabel.setBounds(30, 150, 120, 20);
        scoreLabel.setFont(new Font("Copperplate Gothic", Font.BOLD, 20));

        //create timerLabel
        timerLabel = new JLabel("Timer: ");
        timerLabel.setBounds(30, 80, 90, 20);
        timerLabel.setFont(new Font("Copperplate Gothic", Font.BOLD, 20));

        //create ballButton1
        ballButton1 = new JButton();
        ballButton1.setBounds(460, 170, 40, 40);
        ballButton1.addActionListener(this);
        ballButton1.setIcon(ballImage);
        ballButton1.setBackground(new Color(0, 123, 0));
        ballButton1.setEnabled(false);

        //create ballButton2
        ballButton2 = new JButton();
        ballButton2.setBounds(540, 170, 40, 40);
        ballButton2.addActionListener(this);
        ballButton2.setIcon(ballImage);
        ballButton2.setBackground(new Color(0, 123, 0));
        ballButton2.setEnabled(false);

        //create ballButton3
        ballButton3 = new JButton();
        ballButton3.setBounds(420, 340, 40, 40);
        ballButton3.addActionListener(this);
        ballButton3.setIcon(ballImage);
        ballButton3.setBackground(new Color(0, 123, 0));
        ballButton3.setEnabled(false);

        //create ballButton4
        ballButton4 = new JButton();
        ballButton4.setBounds(590, 340, 40, 40);
        ballButton4.addActionListener(this);
        ballButton4.setIcon(ballImage);
        ballButton4.setBackground(new Color(0, 123, 0));
        ballButton4.setEnabled(false);

        //Background color
        this.getContentPane().setBackground(new Color(229, 124, 43));
        this.add(startButton);
        this.add(textLabel);
        this.add(treeLabel);
        this.add(ballButton1);
        this.add(ballButton2);
        this.add(ballButton3);
        this.add(ballButton4);
        this.add(scoreLabel);
        this.add(timerLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //startButton press
        if (e.getSource() == startButton) {
            startButton.setEnabled(false);
            second = 20;
            simpleTimer();
            timer.start();
            x = random.nextInt(4)+1;
        }
        if (x==1) {
            ballButton1.setEnabled(true);
        }
        if (x==2) {
            ballButton2.setEnabled(true);
        }
        if (x==3) {
            ballButton3.setEnabled(true);
        }
        if (x==4) {
            ballButton4.setEnabled(true);
        }

        //ballButton press
        if (e.getSource() == ballButton1) {
            score++;
            scoreLabel.setText("Score: " + String.valueOf(score));
            ballButton1.setEnabled(false);
            x = random.nextInt(4)+1;
            if (x==1) {
                ballButton1.setEnabled(true);
            }
            if (x==2) {
                ballButton2.setEnabled(true);
            }
            if (x==3) {
                ballButton3.setEnabled(true);
            }
            if (x==4) {
                ballButton4.setEnabled(true);
            }
        }
        if (e.getSource() == ballButton2) {
            score++;
            scoreLabel.setText("Score: " + String.valueOf(score));
            ballButton2.setEnabled(false);
            x = random.nextInt(4)+1;
            if (x==1) {
                ballButton1.setEnabled(true);
            }
            if (x==2) {
                ballButton2.setEnabled(true);
            }
            if (x==3) {
                ballButton3.setEnabled(true);
            }
            if (x==4) {
                ballButton4.setEnabled(true);
            }
        }
        if (e.getSource() == ballButton3) {
            score++;
            scoreLabel.setText("Score: " + String.valueOf(score));
            ballButton3.setEnabled(false);
            x = random.nextInt(4)+1;
            if (x==1) {
                ballButton1.setEnabled(true);
            }
            if (x==2) {
                ballButton2.setEnabled(true);
            }
            if (x==3) {
                ballButton3.setEnabled(true);
            }
            if (x==4) {
                ballButton4.setEnabled(true);
            }
        }
        if (e.getSource() == ballButton4) {
            score++;
            scoreLabel.setText("Score: " + String.valueOf(score));
            ballButton4.setEnabled(false);
            x = random.nextInt(4)+1;
            if (x==1) {
                ballButton1.setEnabled(true);
            }
            if (x==2) {
                ballButton2.setEnabled(true);
            }
            if (x==3) {
                ballButton3.setEnabled(true);
            }
            if (x==4) {
                ballButton4.setEnabled(true);
            }
        }
    }
    public void simpleTimer() {
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                second--;
                timerLabel.setText("Timer: " + second);
                if (second == 0) {
                    timer.stop();
                    textLabel.setText("Du hast einen Score von " + score + " erreicht!");
                    ballButton1.setEnabled(false);
                    ballButton2.setEnabled(false);
                    ballButton3.setEnabled(false);
                    ballButton4.setEnabled(false);
                }
            }
        });
    }
}
