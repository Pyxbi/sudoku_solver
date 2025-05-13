package BACKTRACKING;

public class SudokuTest {
    public static void main(String[] args) {
        testCase("Case 1 invalid puzzle", new int[][]{
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

        testCase("Case 2 (25 clues)", new int[][]{
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

        testCase("Case 3 (37 clues)", new int[][]{
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

    public static void testCase(String name, int[][] puzzle) {
        SudokuBoard board = new SudokuBoard(puzzle);
        BacktrackingSolver solver = new BacktrackingSolver(board);

        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();

        long startTime = System.nanoTime();
        boolean solved = solver.solve();
        long endTime = System.nanoTime();

        System.gc();
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();
        long memoryUsed = afterMemory - beforeMemory;

        double durationInMs = (endTime - startTime) / 1_000_000.0;
        boolean withinTwoMinutes = (endTime - startTime) <= 120_000_000_000L;

        System.out.printf("%s | Time: %.3f ms | Memory: %.2f KB | Solved: %s | Within 2 min: %s\n",
                name,
                durationInMs,
                Math.abs(memoryUsed) / 1024.0,
                solved ? "Yes" : "No",
                withinTwoMinutes ? "Yes" : "No");
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

                if (r < 1 || r > 9 || row[r]) return false;
                if (c < 1 || c > 9 || col[c]) return false;
                if (b < 1 || b > 9 || box[b]) return false;

                row[r] = true;
                col[c] = true;
                box[b] = true;
            }
        }
        return true;
    }
}
