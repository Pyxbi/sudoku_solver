package constraintPropagation;

public class Test {
    public static void main(String[] args) {
        runTest("Case 6: Invalid Puzzle", new int[][]{
                {5, 3, 5, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        });

        runTest("Case 7: Minimum Clues (17)", new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 1, 2},
                {0, 0, 0, 0, 0, 0, 7, 0, 0},
                {0, 0, 0, 5, 0, 9, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 5, 0, 0, 0, 8, 0, 0},
                {0, 0, 0, 0, 7, 0, 0, 0, 0},
                {0, 0, 0, 0, 9, 0, 0, 0, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0}
        });

        runTest("Case 8: Very Hard Puzzle (35 clues)", new int[][]{
                {0, 0, 0, 2, 6, 0, 7, 0, 1},
                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                {8, 2, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                {7, 0, 3, 0, 1, 8, 0, 0, 0}
        });
    }

    private static void runTest(String label, int[][] puzzle) {
        Board board = new Board(puzzle);
        ConstraintPropagationSolver solver = new ConstraintPropagationSolver(board);

        // Measure performance
        long startTime = System.nanoTime();
        long startMemory = measureMemory();

        boolean solved = solver.solve();

        long endTime = System.nanoTime();
        long endMemory = measureMemory();

        double timeMs = (endTime - startTime) / 1_000_000.0;
        double memoryKB = (endMemory - startMemory) / 1024.0;
        boolean withinTime = (endTime - startTime) < 120_000_000_000L;

        // Print result
        System.out.printf("%s | Time: %.2f ms | Memory: %.2f KB | Solved: %s | Within 2 min: %s\n",
                label, timeMs, memoryKB, solved ? "Yes" : "No", withinTime ? "Yes" : "No");


    }

    private static long measureMemory() {
        Runtime runtime = Runtime.getRuntime();
        for (int i = 0; i < 3; i++) {
            System.gc();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
