package constraintPropagation;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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

        Board board = new Board(puzzle);
        ConstraintPropagationSolver solver = new ConstraintPropagationSolver(board);

        // Measure start time and memory
        long startTime = System.nanoTime();
        long startMemory = measureMemory();

        // Solve the puzzle
        boolean solved = solver.solve();

        // Measure end time and memory
        long endTime = System.nanoTime();
        long endMemory = measureMemory();

        // Output result
        if (solved) {
            System.out.println("Solved Sudoku:");
            board.print();
        } else {
            System.out.println("No solution exists.");
        }

        // Report performance
        long durationMillis = (endTime - startTime) / 1_000_000;
        long memoryUsedKB = (endMemory - startMemory) / 1024;

        System.out.println("\nSolving Time: " + durationMillis + " ms");
        System.out.println("Memory Used: " + memoryUsedKB + " KB");
        if (memoryUsedKB < 0) {
            System.out.println("Note: Negative memory usage may indicate garbage collection effects.");
        }
    }

    private static long measureMemory() {
        Runtime runtime = Runtime.getRuntime();
        for (int i = 0; i < 5; i++) {
            System.gc();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return runtime.totalMemory() - runtime.freeMemory();
    }
}