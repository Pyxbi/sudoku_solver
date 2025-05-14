package backtracking;

public class Main {
    public static void main(String[] args) {
        // Define the initial Sudoku puzzle (0 represents empty cells)
        int[][] puzzle = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };


        // Create board and solver objects
        Board board = new Board(puzzle);
        BacktrackingSolver solver = new BacktrackingSolver(board);
        Runtime runtime = Runtime.getRuntime();

        // Measure memory before solving
        long beforeMemory = measureMemory();

        // Measure solving time
        long startTime = System.nanoTime();
        boolean solved = solver.solve();
        long endTime = System.nanoTime();

        // Measure memory after solving
        long afterMemory = measureMemory();

        // Output solution
        if (solved) {
            System.out.println("Solved Sudoku:");
            board.print();
        } else {
            System.out.println("This Sudoku cannot be solved.");
        }

        // Calculate and output performance metrics
        double durationInMs = (endTime - startTime) / 1_000_000.0;
        long memoryUsed = afterMemory - beforeMemory;
        double memoryUsedKB = memoryUsed / 1024.0;

        System.out.printf("\nSolving time: %.3f ms\n", durationInMs);
        System.out.printf("Memory used: %.2f KB\n", memoryUsedKB);
        if (memoryUsed < 0) {
            System.out.println("Note: Negative memory usage may indicate garbage collection or heap resizing effects.");
            System.out.printf("Debug Info - Before Memory: %.2f KB, After Memory: %.2f KB\n",
                    beforeMemory / 1024.0, afterMemory / 1024.0);
            System.out.printf("Total Memory (end): %.2f KB, Free Memory (end): %.2f KB\n",
                    runtime.totalMemory() / 1024.0, runtime.freeMemory() / 1024.0);
        }
    }


    private static long measureMemory() {
        Runtime runtime = Runtime.getRuntime();
        long lastMemory;
        long currentMemory = runtime.totalMemory() - runtime.freeMemory();
        final int maxAttempts = 5;
        int attempt = 0;

        // Attempt to stabilize memory by running GC multiple times
        do {
            lastMemory = currentMemory;
            System.gc();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.err.println("Warning: Memory measurement interrupted");
                Thread.currentThread().interrupt();
                break;
            }
            currentMemory = runtime.totalMemory() - runtime.freeMemory();
            attempt++;
        } while (attempt < maxAttempts && Math.abs(currentMemory - lastMemory) > 1024); // Continue if change > 1KB

        return currentMemory;
    }

    /**
     * Validates that the puzzle is a 9x9 grid with values between 0 and 9.
     * @param puzzle The Sudoku puzzle to validate
     * @return True if valid, false otherwise
     */
    private static boolean isValidPuzzle(int[][] puzzle) {
        if (puzzle == null || puzzle.length != 9) {
            return false;
        }
        for (int[] row : puzzle) {
            if (row == null || row.length != 9) {
                return false;
            }
            for (int value : row) {
                if (value < 0 || value > 9) {
                    return false;
                }
            }
        }
        return true;
    }
}