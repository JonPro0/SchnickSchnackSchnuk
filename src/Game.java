import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private JPanel pMain;
    private JLabel round = new JLabel();
    private JLabel Score = new JLabel();
    private JPanel player = new JPanel();
    private JPanel cpu = new JPanel();
    private JButton schere = new JButton();
    private JButton stein = new JButton();
    private JButton papier = new JButton();
    private int counter = 0;
    private int random;

    public Game(){
        round.setSize(100, 20);
        round.setBackground(Color.lightGray);
        round.setLocation(400, 0);
        round.setText("Runde 1");
        round.setVisible(true);
        add(round);

        Score.setSize(100, 20);
        Score.setBackground(Color.lightGray);
        Score.setLocation(200, 150);
        Score.setText("Score: ");
        Score.setVisible(true);
        add(Score);

        player.setSize(200, 200);
        player.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        player.setLocation(20, 350);
        player.setVisible(true);
        add(player);

        cpu.setSize(200, 200);
        cpu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cpu.setLocation(265, 350);
        cpu.setVisible(true);
        add(cpu);

        schere.setText("Schere");
        schere.setSize(100, 20);
        schere.setLocation(200, 650);
        schere.setBackground(Color.lightGray);
        schere.setVisible(true);
        add(schere);

        stein.setText("Stein");
        stein.setSize(100, 20);
        stein.setLocation(200, 671);
        stein.setBackground(Color.lightGray);
        stein.setVisible(true);
        add(stein);

        papier.setText("Papier");
        papier.setSize(100, 20);
        papier.setLocation(200, 692);
        papier.setBackground(Color.lightGray);
        papier.setVisible(true);
        add(papier);

        schere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 counter = 0;
                 random = (int) (Math.random() * 3);
                 if(counter == random){

                 } else if(counter == 0 && random == 1){
                     Score.setText("Der CPU hat gewonnen");
                     try{
                         Thread.sleep(100);
                         Score.setText("Score: ");
                     } catch (InterruptedException interruptedException) {
                         interruptedException.printStackTrace();
                     }
                 } else{
                     Score.setText("Du hast gewonnen");
                     try{
                         Thread.sleep(100);
                         Score.setText("Score: ");
                     } catch (InterruptedException interruptedException) {
                         interruptedException.printStackTrace();
                     }
                 }
            }
        });


        add(pMain);
        setSize(500, 800);
        setLocationRelativeTo(null);
        setTitle("Schnick Schanck Schnuck");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);




    }

    public static void main(String[] args) {
        new Game();
    }

}
