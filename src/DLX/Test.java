package DLX;

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

        runTest("Case 2: Minimum Clues (17)", new int[][]{
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

        runTest("Case 3: Very Hard Puzzle (35 clues)", new int[][]{
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
        Runtime runtime = Runtime.getRuntime();
        RMIT_Sudoku_Solver solver = new RMIT_Sudoku_Solver(puzzle);

        System.gc();
        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        boolean solved = false;
        int[][] solution = null;

        try {
            solution = solver.solve();
            solved = isValidSudoku(solution);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();
        double timeMs = (endTime - startTime) / 1_000_000.0;
        double memoryUsedKB = (afterMemory - beforeMemory) / 1024.0;
        boolean withinTime = (endTime - startTime) <= 120_000_000_000L;

        System.out.printf("%s | Time: %.2f ms | Memory: %.2f KB | Valid: %s | Within 2 min: %s\n",
                label, timeMs, memoryUsedKB, solved ? "Yes" : "No", withinTime ? "Yes" : "No");
    }


    private static boolean isValidSudoku(int[][] board) {
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
