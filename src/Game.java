import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private JPanel pMain = new JPanel();
    private JLabel round = new JLabel();
    private JLabel Score = new JLabel();
    private JPanel player = new JPanel();
    private JPanel cpu = new JPanel();
    private JButton schere = new JButton();
    private JButton stein = new JButton();
    private JButton papier = new JButton();
    private int counter = 0;
    private int random;
    private int playerScore;

    public Game(){
        Icon cpuscissor = new ImageIcon("media/cpuscissor.png");
        Icon playerscissor = new ImageIcon("media/playerscissor.png");
        Icon rock = new ImageIcon("media/Rock.png");
        Icon paper = new ImageIcon("media/paper.png");
        JLabel Lcpuscissor = new JLabel(cpuscissor);
        JLabel Lplayerscissor = new JLabel(playerscissor);
        JLabel Lrock = new JLabel(rock);
        JLabel Lpaper = new JLabel(paper);
        
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
                new Thread(){
                    public void run(){
                        counter = 0;
                        random = (int) (Math.random() * 3);

                        player.add(Lplayerscissor);
                        
                        if(counter == random){
                            cpu.add(Lcpuscissor);
                        } else if(counter == 0 && random == 1){
                            cpu.add(Lrock);
                            Score.setSize(200, 20);
                            Score.setText("Score: " + playerScore);
                        } else{
                            cpu.add(Lpaper);
                            Score.setSize(200,20);
                            playerScore++;
                            Score.setText("Score: " + playerScore);
                        }
                    }
                    }.start();
                }

        });

        stein.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(){
                    public void run(){
                        counter = 1;
                        random = (int) (Math.random() * 3);

                        player.add(Lrock);
                        if(counter == random){
                            cpu.add(Lrock);
                        } else if(counter == 1 && random == 2){
                            cpu.add(Lpaper);
                            Score.setSize(200,20);
                            Score.setText("Score: " + playerScore);
                        } else{
                            cpu.add(Lcpuscissor);
                            Score.setSize(200,20);
                            playerScore++;
                            Score.setText("Score: " + playerScore);
                        }
                    }
                }.start();
            }

        });

        papier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(){
                    public void run(){
                        counter = 2;
                        random = (int) (Math.random() * 3);
                        player.add(Lpaper);
                        if(counter == random){
                            cpu.add(Lpaper);
                        } else if(counter == 2 && random == 0){
                            cpu.add(Lcpuscissor);
                            Score.setSize(200,20);
                            Score.setText("Score: " + playerScore);
                        } else{
                            cpu.add(Lrock);
                            Score.setSize(200,20);
                            playerScore++;
                            Score.setText("Score: " + playerScore);
                        }
                    }
                }.start();
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
