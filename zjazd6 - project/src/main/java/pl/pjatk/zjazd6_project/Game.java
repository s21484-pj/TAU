package pl.pjatk.zjazd6_project;

import java.util.Random;

public class Game {

    private static final int ROWS = 5;
    private static final int COLS = 5;
    private static final int OBSTACLE_QUANTITY = 5;
    private static final char OBSTACLE = 'X';
    private static final char START = 'S';
    private static final char STOP = 'F';
    private static final char USER = 'U';
    private static final char EMPTY = '-';

    private char[][] board;
    private int startRow;
    private int startCol;
    private int stopRow;
    private int stopCol;
    private int userRow;
    private int userCol;

    public Game() {
        initBoard();
    }

    private void initBoard() {
        Random rand = new Random();
        board = new char[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }

        while (true) {
            startRow = rand.nextInt(ROWS);
            startCol = rand.nextInt(COLS);
            if ((startRow == 0 || startRow == 4)
                    || (startCol == 0 || startCol == 4)) {
                break;
            }
        }
        stopRow = startRow == 0 ? 4 : 0;
        stopCol = startCol == 0 ? 4 : 0;
        userRow = startRow;
        userCol = startCol;
        board[startRow][startCol] = START;
        board[stopRow][stopCol] = STOP;

        int count = 0;
        while (count < OBSTACLE_QUANTITY) {
            int row = rand.nextInt(5);
            int col = rand.nextInt(5);
            if (board[row][col] != START && board[row][col] != STOP) {
                board[row][col] = OBSTACLE;
                count++;
            }
        }
    }

    public boolean move(int row, int col, int newRow, int newCol, String move) {
        if (newRow < 0 || newRow >= ROWS || newCol < 0 || newCol >= COLS) {
            System.out.println("Can not move " + move + ". There is board border.");
            return false;
        }
        if (board[newRow][newCol] == OBSTACLE) {
            System.out.println("Can not move " + move + ". There is obstacle.");
            return false;
        }
        board[row][col] = EMPTY;
        board[newRow][newCol] = USER;
        userRow = newRow;
        userCol = newCol;
        System.out.println("You moved " + move);
        return true;
    }

    public boolean moveUp() {
        return move(userRow, userCol, userRow - 1, userCol, "up");
    }

    public boolean moveDown() {
        return move(userRow, userCol, userRow + 1, userCol, "down");
    }

    public boolean moveLeft() {
        return move(userRow, userCol, userRow, userCol - 1, "left");
    }

    public boolean moveRight() {
        return move(userRow, userCol, userRow, userCol + 1, "right");
    }

    public boolean isFinished() {
        return userRow == stopRow && userCol == stopCol;
    }

    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
