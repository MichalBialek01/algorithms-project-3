

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame implements ActionListener {
    private int size;
    private JButton[][] buttons;
    private Board board;
    private boolean userTurn = true;

    public TicTacToeGUI(int size) {
        this.size = size;
        this.board = new Board(size);
        this.buttons = new JButton[size][size];

        setLayout(new GridLayout(size, size));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }

        setTitle("Tic Tac Toe");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (button == buttons[i][j]) {
                    if (board.makeMove(i, j, Board.USER)) {
                        buttons[i][j].setText(String.valueOf(Board.USER));
                        userTurn = false;
                        if (board.checkWinner() == Board.EMPTY && !board.isFull()) {
                            aiMove();
                        }
                        if (board.checkWinner() != Board.EMPTY || board.isFull()) {
                            endGame();
                        }
                    }
                }
            }
        }
    }

    private void aiMove() {
        AI ai = new AI(size, board.getBoard());
        int[] bestMove = ai.getBestMove();
        board.makeMove(bestMove[0], bestMove[1], Board.AI);
        buttons[bestMove[0]][bestMove[1]].setText(String.valueOf(Board.AI));
        userTurn = true;
    }

    private void endGame() {
        char winner = board.checkWinner();
        String message;
        if (winner == Board.USER) {
            message = "Congratulations, you win!";
        } else if (winner == Board.AI) {
            message = "You lose! AI wins!";
        } else {
            message = "It's a tie!";
        }
        JOptionPane.showMessageDialog(this, message);
        board.resetBoard();
        resetButtons();
    }

    private void resetButtons() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j].setText("");
            }
        }
        userTurn = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String input = JOptionPane.showInputDialog("Enter the size of the board (e.g., 3 for 3x3):");
            int size = Integer.parseInt(input);
            new TicTacToeGUI(size);
        });
    }
}