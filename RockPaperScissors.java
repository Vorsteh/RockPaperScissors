import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class RockPaperScissors {
    JFrame f;
    JButton sten, sax, påse;
    JLabel text,dMove;
    JLabel poäng;

    String pMove, cMove;

    int cPoints = 0, pPoints = 0;

    Random random = new Random();
    Font font, font2;
    boolean kör = true;

    String[] rps = {"Rock", "Scissors", "Paper"};

    RockPaperScissors() {
        f = new JFrame();
        sten = new JButton("Rock");
        sax = new JButton("Paper");
        påse = new JButton("Scissors");
        text = new JLabel("Pick ur move!");
        font = new Font("SansSerif", Font.BOLD, 25);
        font2 = new Font("SansSerif", Font.BOLD, 10);
        poäng = new JLabel();
        dMove = new JLabel();

        text.setFont(font);
        text.setBounds(100, 75, 220, 75);

        sten.setBounds(25, 200, 75, 50);
        sax.setBounds(150, 200, 75, 50);
        påse.setBounds(275, 200, 75, 50);

        poäng.setFont(font);
        poäng.setText("P: " + pPoints + " C: " + cPoints);
        poäng.setBounds(10, 10, 100, 25);

        f.add(sten);
        f.add(sax);
        f.add(påse);
        f.add(text);
        f.add(poäng);
        f.add(dMove);
        f.setSize(400, 300);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sten.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pMove = "Rock";
                run();
            }
        });
        sax.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pMove = "Scissors";
                run();
            }
        });
        påse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pMove = "Paper";
                run();
            }
        });
    }


    public void run()  {
        cMove = rps[random.nextInt(rps.length)];
        if(pMove.equals(cMove)){
            text.setText("Tie");
        }else if(pMove.equals("Rock")){
            if(cMove.equals("Paper")){
                text.setText("Computer got a point");
                cPoints++;
            }else {
                text.setText("You got a point");
                pPoints++;
            }
        }else if(pMove.equals("Scissors")){
            if(cMove.equals("Paper")){
                text.setText("You got a point");
                pPoints++;

            }else {
                text.setText("Computer got a point");
                cPoints++;
            }
        }else if(pMove.equals("Paper")){
            if(cMove.equals("Scissors")){
                text.setText("Computer got a point");
                cPoints++;
            }else {
                text.setText("You got a point");
                pPoints++;
            }
        }

        if (pPoints >= 3){
            text.setText("You won!");
            sten.setVisible(false);
            sax.setVisible(false);
            påse.setVisible(false);
        }
        if(cPoints >= 3){
            text.setText("Computer won!");
            sten.setVisible(false);
            sax.setVisible(false);
            påse.setVisible(false);poäng.setText("P: " + pPoints + " C: " + cPoints);
        }
        poäng.setText("P: " + pPoints + " C: " + cPoints);

    }

    public static void main(String[] args) {
        new RockPaperScissors();
    }
}
