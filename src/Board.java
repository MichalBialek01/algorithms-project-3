public class Board {
    private int size;
    private char[][] board;
    public static final char USER = 'X';
    public static final char AI = 'O';
    public static final char EMPTY = '-';

    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public char checkWinner() {
        // Check rows
        for (int i = 0; i < size; i++) {
            if (checkLine(board[i])) return board[i][0];
        }
        // Check columns
        for (int i = 0; i < size; i++) {
            char[] column = new char[size];
            for (int j = 0; j < size; j++) {
                column[j] = board[j][i];
            }
            if (checkLine(column)) return column[0];
        }
        // Check diagonals
        char[] diagonal1 = new char[size];
        char[] diagonal2 = new char[size];
        for (int i = 0; i < size; i++) {
            diagonal1[i] = board[i][i];
            diagonal2[i] = board[i][size - 1 - i];
        }
        if (checkLine(diagonal1)) return diagonal1[0];
        if (checkLine(diagonal2)) return diagonal2[0];

        return EMPTY;
    }

    private boolean checkLine(char[] line) {
        char first = line[0];
        if (first == EMPTY) return false;
        for (char c : line) {
            if (c != first) return false;
        }
        return true;
    }

    public boolean makeMove(int row, int col, char player) {
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == EMPTY) {
            board[row][col] = player;
            return true;
        }
        return false;
    }

    public void resetBoard() {
        initializeBoard();
    }
}
