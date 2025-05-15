package DLX;

public class AdvancedSudokuTests {
    public static void main(String[] args) {
        testDuplicateInRow();
        testDuplicateInColumn();
        testDuplicateInBlock();
        testSolvedPuzzle();
        testEmptyPuzzle();
        testInvalidPuzzle();

        testCoverAndUncover();
        testDlSearchMinimal();
        testDlSearchEmpty();

        // Performance test cases
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
    }

    static void testDuplicateInRow() {
        int[][] puzzle = {
                {5, 3, 5, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println("Row Duplication Test: " + !isValidSudoku(puzzle));
    }

    static void testDuplicateInColumn() {
        int[][] puzzle = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {5, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println("Column Duplication Test: " + !isValidSudoku(puzzle));
    }

    static void testDuplicateInBlock() {
        int[][] puzzle = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 5, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println("Block Duplication Test: " + !isValidSudoku(puzzle));
    }

    static void testSolvedPuzzle() {
        int[][] puzzle = {
                {8,1,2,7,5,3,6,4,9},
                {9,4,3,6,8,2,1,7,5},
                {6,7,5,4,9,1,2,8,3},
                {1,5,4,2,3,7,8,9,6},
                {3,6,9,8,4,5,7,2,1},
                {2,8,7,1,6,9,5,3,4},
                {5,2,1,9,7,4,3,6,8},
                {4,3,8,5,2,6,9,1,7},
                {7,9,6,3,1,8,4,5,2}
        };
        System.out.println("Test Solved Puzzle: " + isValidSudoku(puzzle));
    }

    static void testEmptyPuzzle() {
        int[][] puzzle = new int[9][9];
        System.out.println("Test Empty Puzzle: " + isValidSudoku(puzzle));
    }

    static void testInvalidPuzzle() {
        int[][] puzzle = {
                {5,3,5,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };
        System.out.println("Test Invalid Puzzle: " + !isValidSudoku(puzzle));
    }

    public static void testCoverAndUncover() {
        int[][] puzzle = new int[9][9];
        DancingLinks dl = new DancingLinks(puzzle);
        DLHeaderNode column = dl.getSmallestColumn();

        int originalSize = column.size;
        dl.coverColumn(column);
        dl.uncoverColumn(column);

        System.out.println("Test Cover & Uncover:");
        System.out.println("Original size: " + originalSize);
        System.out.println("Restored size: " + column.size);
        System.out.println("Restored size match: " + (originalSize == column.size));
    }

    public static void testDlSearchMinimal() {
        int[][] puzzle = {
                {8, 1, 2, 7, 5, 3, 6, 4, 0},
                {9, 4, 3, 6, 8, 2, 1, 7, 5},
                {6, 7, 5, 4, 9, 1, 2, 8, 3},
                {1, 5, 4, 2, 3, 7, 8, 9, 6},
                {3, 6, 9, 8, 4, 5, 7, 2, 1},
                {2, 8, 7, 1, 6, 9, 5, 3, 4},
                {5, 2, 1, 9, 7, 4, 3, 6, 8},
                {4, 3, 8, 5, 2, 6, 9, 1, 7},
                {7, 9, 6, 3, 1, 8, 4, 5, 2}
        };

        RMIT_Sudoku_Solver solver = new RMIT_Sudoku_Solver(puzzle);
        int[][] solution = solver.solve();

        System.out.println("Test dlSearch Minimal:");

        System.out.println("Valid: " + isValidSudoku(solution));
    }

    public static void testDlSearchEmpty() {
        int[][] puzzle = new int[9][9];
        RMIT_Sudoku_Solver solver = new RMIT_Sudoku_Solver(puzzle);
        int[][] solution = solver.solve();

        System.out.println("Test dlSearch Empty Board:");

        System.out.println("Valid: " + isValidSudoku(solution));
    }

    public static void testCase1() { runTimedTest("Case 1: Fully Solved Puzzle", new int[][]{
            {8,1,2,7,5,3,6,4,9},
            {9,4,3,6,8,2,1,7,5},
            {6,7,5,4,9,1,2,8,3},
            {1,5,4,2,3,7,8,9,6},
            {3,6,9,8,4,5,7,2,1},
            {2,8,7,1,6,9,5,3,4},
            {5,2,1,9,7,4,3,6,8},
            {4,3,8,5,2,6,9,1,7},
            {7,9,6,3,1,8,4,5,2}
    }); }

    public static void testCase2() { runTimedTest("Case 2: Empty Puzzle", new int[9][9]); }

    public static void testCase3() { runTimedTest("Case 3: One Cell Missing", new int[][]{
            {8,1,2,7,5,3,6,4,0},
            {9,4,3,6,8,2,1,7,5},
            {6,7,5,4,9,1,2,8,3},
            {1,5,4,2,3,7,8,9,6},
            {3,6,9,8,4,5,7,2,1},
            {2,8,7,1,6,9,5,3,4},
            {5,2,1,9,7,4,3,6,8},
            {4,3,8,5,2,6,9,1,7},
            {7,9,6,3,1,8,4,5,2}
    }); }

    public static void testCase4() { runTimedTest("Case 4: Hard Puzzle (20 clues)", new int[][]{
            {0,3,0,0,0,7,0,0,0},
            {8,0,0,0,0,0,0,0,1},
            {0,0,0,6,0,0,0,8,0},
            {0,0,6,0,0,0,0,0,0},
            {0,0,0,0,0,8,0,0,5},
            {0,0,0,0,0,0,0,9,0},
            {1,0,0,0,0,0,0,0,0},
            {0,0,0,5,0,0,0,0,0},
            {0,0,0,0,7,0,0,6,0}
    }); }

    public static void testCase5() { runTimedTest("Case 5: Extremely Hard Puzzle (30 clues)", new int[][]{
            {0,2,0,0,0,0,0,0,0},
            {0,0,0,6,0,0,0,0,3},
            {0,7,4,0,8,0,0,0,0},
            {0,0,0,0,0,3,0,0,2},
            {0,8,0,0,4,0,0,1,0},
            {6,0,0,5,0,0,0,0,0},
            {0,0,0,0,1,0,7,8,0},
            {5,0,0,0,0,9,0,0,0},
            {0,0,0,0,0,0,0,4,0}
    }); }

    private static void runTimedTest(String label, int[][] puzzle) {
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
            System.out.println(label + " | Exception: " + e.getMessage());
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