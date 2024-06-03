public class AI {
    private int size;
    private char[][] board;

    public AI(int size, char[][] board) {
        this.size = size;
        this.board = board;
    }

    public int[] getBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = new int[2];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == Board.EMPTY) {
                    board[i][j] = Board.AI;
                    int score = minimax(board, 0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    board[i][j] = Board.EMPTY;
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        return bestMove;
    }

    private int minimax(char[][] board, int depth, boolean isMaximizing, int alpha, int beta) {
        char winner = checkWinner();
        if (winner == Board.AI) return 10 - depth;
        if (winner == Board.USER) return depth - 10;
        if (isBoardFull()) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (board[i][j] == Board.EMPTY) {
                        board[i][j] = Board.AI;
                        int score = minimax(board, depth + 1, false, alpha, beta);
                        board[i][j] = Board.EMPTY;
                        bestScore = Math.max(score, bestScore);
                        alpha = Math.max(alpha, score);
                        if (beta <= alpha) {
                            return bestScore;
                        }
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (board[i][j] == Board.EMPTY) {
                        board[i][j] = Board.USER;
                        int score = minimax(board, depth + 1, true, alpha, beta);
                        board[i][j] = Board.EMPTY;
                        bestScore = Math.min(score, bestScore);
                        beta = Math.min(beta, score);
                        if (beta <= alpha) {
                            return bestScore;
                        }
                    }
                }
            }
            return bestScore;
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == Board.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private char checkWinner() {
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

        return Board.EMPTY;
    }

    private boolean checkLine(char[] line) {
        char first = line[0];
        if (first == Board.EMPTY) return false;
        for (char c : line) {
            if (c != first) return false;
        }
        return true;
    }
}