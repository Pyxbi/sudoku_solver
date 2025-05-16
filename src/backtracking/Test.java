package backtracking;

public class Test {
    public static void main(String[] args) {
        runTest("Case 1: Invalid Puzzle", new int[][]{
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

        runTest("Case 2: Extremely Hard (10 clues)", new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 1, 2},
                {0, 0, 0, 0, 0, 0, 3, 0, 0},
                {0, 0, 0, 4, 0, 5, 0, 0, 0},
                {0, 0, 6, 0, 0, 0, 7, 0, 0},
                {0, 8, 0, 0, 0, 0, 0, 9, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 4, 0, 0},
                {0, 0, 0, 3, 0, 6, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 0, 8}
        });

        runTest("Case 3: Easy Puzzle (35 clues)", new int[][]{
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

        runTest("Case 4: Empty Sudoku", new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        });

        runTest("Case 5: 1 Missing Cell Fully Solved", new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 0}, // ← only one cell missing here
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        });

        runTest("Case 6: 17-Clue Unique Sudoku", new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 4, 0, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 7, 0, 0, 0, 0, 0},
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 0}
        });

        runTest("Case 7: Fully Solved Sudoku", new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        });

    }

    private static void runTest(String label, int[][] puzzle) {
        if (!isValidPuzzle(puzzle)) {
            System.out.printf("%s | Invalid input format\n", label);
            return;
        }

        Board board = new Board(puzzle);
        BacktrackingSolver solver = new BacktrackingSolver(board);
        Runtime runtime = Runtime.getRuntime();

        System.gc();
        long beforeMemory = measureMemory();
        long startTime = System.nanoTime();
        boolean solved = solver.solve();
        long endTime = System.nanoTime();
        long afterMemory = measureMemory();

        double timeMs = (endTime - startTime) / 1_000_000.0;
        double memoryUsedKB = (afterMemory - beforeMemory) / 1024.0;
        boolean withinTime = (endTime - startTime) <= 120_000_000_000L;

        System.out.printf("%-35s | Time: %6.2f ms | Memory: %8.2f KB | Solved: %-4s | Within 2 min: %s\n",
                label, timeMs, memoryUsedKB, solved ? "Yes" : "No", withinTime ? "Yes" : "No");



    }

    private static long measureMemory() {
        Runtime runtime = Runtime.getRuntime();
        System.gc();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static boolean isValidPuzzle(int[][] puzzle) {
        if (puzzle == null || puzzle.length != 9) return false;
        for (int[] row : puzzle) {
            if (row.length != 9) return false;
            for (int val : row) {
                if (val < 0 || val > 9) return false;
            }
        }
        return true;
    }
}
