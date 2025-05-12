public class Main {
    public static void main(String[] args) {
        runPerformanceTest("Case 1: Fully Solved Puzzle", new int[][]{
                {8,1,2,7,5,3,6,4,9},
                {9,4,3,6,8,2,1,7,5},
                {6,7,5,4,9,1,2,8,3},
                {1,5,4,2,3,7,8,9,6},
                {3,6,9,8,4,5,7,2,1},
                {2,8,7,1,6,9,5,3,4},
                {5,2,1,9,7,4,3,6,8},
                {4,3,8,5,2,6,9,1,7},
                {7,9,6,3,1,8,4,5,2}
        });

        runPerformanceTest("Case 2: Empty Puzzle", new int[9][9]);

        runPerformanceTest("Case 3: One Missing Cell", new int[][]{
                {8,1,2,7,5,3,6,4,0},
                {9,4,3,6,8,2,1,7,5},
                {6,7,5,4,9,1,2,8,3},
                {1,5,4,2,3,7,8,9,6},
                {3,6,9,8,4,5,7,2,1},
                {2,8,7,1,6,9,5,3,4},
                {5,2,1,9,7,4,3,6,8},
                {4,3,8,5,2,6,9,1,7},
                {7,9,6,3,1,8,4,5,2}
        });

        runPerformanceTest("Case 4: Hard Puzzle", new int[][]{
                {0,3,5,0,0,7,0,0,0},
                {8,0,0,0,0,0,0,0,1},
                {0,0,2,6,0,9,0,8,0},
                {0,0,6,0,0,5,2,0,0},
                {0,0,0,0,0,8,4,0,5},
                {0,0,0,0,0,0,0,9,7},
                {1,0,0,0,0,0,0,0,0},
                {0,0,0,5,8,0,0,0,4},
                {0,0,0,1,7,0,0,6,0}
        });

        runPerformanceTest("Case 5: Extremely Difficult", new int[][]{
                {0,2,0,0,0,0,0,0,0},
                {0,0,0,6,0,0,0,0,3},
                {0,7,4,0,8,0,0,0,0},
                {0,0,0,0,0,3,0,0,2},
                {0,8,0,0,4,0,0,1,0},
                {6,0,0,5,0,0,0,0,0},
                {0,0,0,0,1,0,7,8,0},
                {5,0,0,0,0,9,0,0,0},
                {0,0,0,0,0,0,0,4,0}
        });

        runPerformanceTest("Case 6: Invalid Puzzle", new int[][]{
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

        runPerformanceTest("Case 7: Medium Difficulty (25 clues)", new int[][]{
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {2, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        });

        runPerformanceTest("Case 8: Medium-Hard (37 clues)", new int[][]{
                {0, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 6, 0, 0, 0, 0, 3},
                {0, 7, 4, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 2},
                {0, 8, 0, 0, 4, 0, 0, 1, 0},
                {6, 0, 0, 5, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 7, 8, 0},
                {5, 0, 0, 0, 0, 9, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 4, 0}
        });
    }

    public static void runPerformanceTest(String label, int[][] puzzle) {
        RMIT_Sudoku_Solver solver = new RMIT_Sudoku_Solver(puzzle);

        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        int[][] solution = null;
        boolean valid = false;

        try {
            solution = solver.solve();
            valid = isValidSudoku(solution);
        } catch (RuntimeException e) {
            System.out.println(label + ": Failed - " + e.getMessage());
            return;
        }

        long endTime = System.nanoTime();
        System.gc();
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = afterMemory - beforeMemory;
        double timeMs = (endTime - startTime) / 1_000_000.0;
        boolean withinTime = (endTime - startTime) <= 120_000_000_000L;

        System.out.printf("%s | Time: %.2f ms   | Memory: %.2f KB   | Valid: %s  | Within 2 min: %s\n",
                label, timeMs, memoryUsed / 1024.0, valid, withinTime ? "Yes" : "No");
    }

    public static boolean isValidSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[10];
            boolean[] col = new boolean[10];
            boolean[] box = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int r = board[i][j];
                int c = board[j][i];
                int b = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3];
                if (r != 0 && row[r]) return false;
                if (c != 0 && col[c]) return false;
                if (b != 0 && box[b]) return false;
                if (r != 0) row[r] = true;
                if (c != 0) col[c] = true;
                if (b != 0) box[b] = true;
            }
        }
        return true;
    }
}
