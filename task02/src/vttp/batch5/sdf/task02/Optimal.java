package vttp.batch5.sdf.task02;

public class Optimal {

    private char me;
    private char op;

    public Optimal(char me, char op) {
        this.me = me;
        this.op = op;
    }

    public int[] getMove(Board board) {
        int bestScore = Integer.MIN_VALUE; // start initial bestScore - min value so that minmax can get higher values
        int[] bestMove = new int[3]; // initialise array for bestMove[row], bestMove[col], score

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.cellIsEmpty(row, col)) { // check if cell is empty
                    Board optBoard = board.getCopy(); // copy board
                    optBoard.updateBoard(row, col, me); // fill with ai
                    int score = minimax(optBoard, false, 0); // check score of next move - start at depth 0
                    optBoard.updateBoard(row, col, '.'); // clear hypo move
                    if (score > bestScore) {
                        bestScore = score; // update best score if current score is higher
                        bestMove[0] = row; // select bestMove
                        bestMove[1] = col;
                        bestMove[2] = bestScore; //utility score of bestMove
                    }
                }
            }
        }
        
        return bestMove;

    }

    private int minimax(Board board, boolean isMaximizing, int depth) {
        if (board.checkWinner('X')) return 10;
        if (board.checkWinner('O')) return -10;
        if (board.isFull()) return 0; 

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE; // start from min value to find highest score
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.cellIsEmpty(row, col)) { // if cell empty
                        board.updateBoard(row, col, me); // make hypo move
                        int score = minimax(board, false, depth + 1); // next player is minimizing, depth + 1 recursive
                        board.updateBoard(row, col, '.'); // clear hypo move
                        bestScore = Math.max(score, bestScore); // find max diff between score and bestScore
                    }
                }
            }

            return bestScore;

        } else {
            int bestScore = Integer.MAX_VALUE; // start from max value to find lowest score
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.cellIsEmpty(row, col)) { //if cell empty
                        board.updateBoard(row, col, op); // make hypo move
                        int score = minimax(board, true, depth + 1); // next player is maximizing, depth + 1 recursive
                        board.updateBoard(row, col, '.'); // clear hypo move
                        bestScore = Math.min(score, bestScore); // find min diff between score and bestScore
                    }
                }
            }

            return bestScore;
        }
    }
}
