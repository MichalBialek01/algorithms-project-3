import javax.swing.*;
import java.awt.*;

public class StatisticsWindow extends JFrame {
    public StatisticsWindow(Statistics statistics) {
        setTitle("Game Statistics");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel userWinsLabel = new JLabel("User Wins: " + statistics.getUserWins());
        JLabel aiWinsLabel = new JLabel("AI Wins: " + statistics.getAiWins());
        JLabel tiesLabel = new JLabel("Ties: " + statistics.getTies());

        panel.add(userWinsLabel);
        panel.add(aiWinsLabel);
        panel.add(tiesLabel);

        add(panel);
        setVisible(true);
    }
}