package vttp.batch5.sdf.task02;

public class Board {
    
    // init vars
    private char[][] board;

    // Make 3x3 board
    public Board() {
        board = new char[3][3];
    }

    public Board(char[][] board) {
        this.board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            System.arraycopy(board, 0, this.board, 0, 3);
        }
    }

    public void updateBoard(int row, int col, char c) {
        for (row = 0; row < 3; row++) {
            for (col = 0; col < 3; col++) {
                board[row][col] = c;
            }
        }
    }

    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                    System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    public void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '.';
            }
        }
    }

    public Board getCopy() {
        char[][] copiedBoard = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                copiedBoard[row][col] = this.board[row][col];
            }
        }
        return new Board(copiedBoard);
    }

    public boolean cellIsEmpty(int row, int col) {
        return board[row][col] == '.';
    }

    public boolean checkWinner(char c) {
        for (int row = 0; row < 3; row++) {
            if ((board[row][0] == c ) && (board[row][1] == c) && (board[row][2] ==c) || // check horizontal
                (board[0][row] == c ) && (board[1][row] == c) && (board[2][row] == c) || // check vertical
                (board[0][0] == c ) && (board[1][1] == c) && (board[2][2] ==c) || // check diagonals
                (board[0][2] == c ) && (board[1][1] == c) && (board[2][0] ==c)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '.')
                    return false;
            }
        }
        return true;
    }

    public boolean gameIsOver() {
        return checkWinner('X') || checkWinner('O') || isFull();
    }

}
