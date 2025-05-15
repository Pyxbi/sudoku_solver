package backtracking;

/**
 * Solver class that applies backtracking with recursion (DFS)
 * to solve a Sudoku puzzle.
 */
public class BacktrackingSolver {
    private Board board; // Sudoku board instance
    private final java.util.List<byte[]> memoryTracker = new java.util.ArrayList<>();

    /**
     * Constructor to create a Solver with a given Sudoku board.
     */
    public BacktrackingSolver(Board board) {
        this.board = board;
    }

    private boolean rowCheck(int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (board.getCell(row, col) == num) {
                return true;
            }
        }
        return false;
    }

    private boolean colCheck(int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (board.getCell(row, col) == num) {
                return true;
            }
        }
        return false;
    }

    private boolean boxCheck(int row, int col, int num) {
        int rowStart = row - row % 3;
        int colStart = col - col % 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board.getCell(i, j) == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSafe(int row, int col, int num) {
        return !(rowCheck(row, num) || colCheck(col, num) || boxCheck(row, col, num));
    }

    /**
     * Solves the Sudoku puzzle using recursive backtracking.
     * Includes simulated heap memory allocation for fair comparison.
     */
    public boolean solve() {
        // Simulate 1 KB allocation and retain it in memory
        byte[] simulateMemory = new byte[1024];
        memoryTracker.add(simulateMemory); // Keep reference to prevent GC

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.getCell(row, col) == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(row, col, num)) {
                            board.setCell(row, col, num);
                            if (solve()) return true;
                            board.setCell(row, col, 0);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}
