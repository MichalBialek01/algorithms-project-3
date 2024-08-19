# Project Description: Tic-Tac-Toe with AI Opponent

## Overview
This project is a Java-based implementation of the classic Tic-Tac-Toe game, featuring a computer-controlled AI opponent. The game includes a graphical user interface (GUI) created using Java Swing, allowing players to interact with the game in a visually intuitive way. The AI opponent uses the minimax algorithm with alpha-beta pruning to decide the best possible moves, making the game both challenging and engaging for players.

## Source Files and Their Functions

1. **`StatisticsWindow.java`**
    - This class is responsible for displaying the game statistics in a separate window. It shows the number of wins for the user, the AI, and the number of ties.
    - **Key Functions:**
      - Creates a GUI window to display game statistics.
      - Displays the results in the form of labels.

2. **`Statistics.java`**
    - This class manages and stores the game's statistics, including the number of user wins, AI wins, and ties.
    - **Key Functions:**
      - Increments the count of wins for the user and AI, as well as ties.
      - Saves and loads statistics from a file using Java's serialization mechanism.

3. **`Board.java`**
    - This class represents the game board. It includes methods for initializing the board, checking the game state (e.g., if someone has won or if the board is full), and making moves for both the user and AI.
    - **Key Functions:**
      - Initializes a game board of a specified size.
      - Checks if there is a winner or if the board is full.
      - Handles the moves made by the user and AI.
      - Resets the board after the game ends.

4. **`TicTacToeGUI.java`**
    - This class implements the main graphical user interface for the game. It allows the player to interact with the board by clicking buttons corresponding to each cell.
    - **Key Functions:**
      - Creates a window with buttons for each cell on the board.
      - Handles user interactions, such as button clicks, and triggers the appropriate game logic.
      - Calls the AI to make its move after the player makes theirs.
      - Ends the game when a winner is found or the board is full, and displays a message with the result.

5. **`AI.java`**
    - This class contains the logic for the AI opponent. It uses the minimax algorithm with alpha-beta pruning to determine the optimal move based on the current state of the board.
    - **Key Functions:**
      - Computes the best possible move for the AI based on the game board's state.
      - Implements the minimax algorithm to simulate possible moves for both the AI and the player.
      - Optimizes the decision-making process using alpha-beta pruning to reduce the number of nodes evaluated in the game tree.

## AI and Algorithms Used

1. **Minimax Algorithm**
    - The minimax algorithm is a decision-making algorithm used in two-player games like Tic-Tac-Toe. It operates by simulating all possible moves for both the player (maximizing) and the AI (minimizing) to predict the outcome of the game. The AI attempts to maximize its chances of winning while minimizing the player's chances.
    - **How it Works:**
      - The algorithm recursively explores all possible moves and their outcomes, assigning a score to each possible end state: +10 for an AI win, -10 for a player win, and 0 for a tie.
      - The AI then selects the move that maximizes its minimum guaranteed score, assuming that the opponent also plays optimally.

2. **Alpha-Beta Pruning**
    - Alpha-beta pruning is an optimization technique for the minimax algorithm. It reduces the number of nodes that need to be evaluated in the game tree, thereby improving the efficiency of the algorithm.
    - **How it Works:**
      - During the minimax process, alpha-beta pruning eliminates branches in the tree that cannot possibly influence the final decision. It keeps track of two values, alpha (the best value the maximizer can guarantee) and beta (the best value the minimizer can guarantee).
      - If at any point the minimizer's best option (beta) becomes worse than the maximizer's best option (alpha), that branch is pruned (i.e., not further explored), because it cannot affect the final decision.

## Game Features
- **Customizable Board Size:** The player can choose the size of the board before starting the game.
- **Smart AI Opponent:** The AI uses advanced algorithms to determine the best possible move, providing a challenging gameplay experience.
- **Graphical User Interface:** The game features a simple, intuitive GUI that makes it easy to play and interact with the game.
- **Statistics Tracking:** The game tracks and displays statistics such as the number of wins for the player, AI, and ties.

