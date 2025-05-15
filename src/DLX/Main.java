package DLX;

public class Main {
    public static void main(String[] args) {
        int[][] puzzle = {
                {0, 0, 5, 0, 0, 0, 0, 1, 2},
                {0, 0, 0, 0, 0, 0, 7, 0, 0},
                {0, 0, 0, 5, 0, 9, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 5, 0, 0, 0, 8, 0, 0},
                {0, 0, 0, 0, 7, 0, 0, 0, 0},
                {0, 4, 0, 0, 9, 0, 0, 0, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0}
        };


        RMIT_Sudoku_Solver solver = new RMIT_Sudoku_Solver(puzzle);
        Runtime runtime = Runtime.getRuntime();

        // Measure memory and time
        long beforeMemory = measureMemory();
        long startTime = System.nanoTime();
        int[][] solved = null;
        try {
            solved = solver.solve();
        } catch (Exception e) {
            System.out.println("Error solving puzzle: " + e.getMessage());
            return;
        }
        long endTime = System.nanoTime();
        long afterMemory = measureMemory();

        // Output result
        if (solved != null) {
            System.out.println("Solved Sudoku:");
            printPuzzle(solved);
        } else {
            System.out.println("No solution exists.");
        }

        // Performance metrics
        double durationMs = (endTime - startTime) / 1_000_000.0;
        double memoryUsedKB = (afterMemory - beforeMemory) / 1024.0;
        System.out.printf("\nSolving time: %.3f ms\nMemory used: %.2f KB\n", durationMs, memoryUsedKB);
        if (memoryUsedKB < 0) {
            System.out.println("Note: Negative memory usage may indicate GC effects.");
            System.out.printf("Before: %.2f KB, After: %.2f KB\n", beforeMemory / 1024.0, afterMemory / 1024.0);
        }
    }

    private static long measureMemory() {
        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        for (int i = 0; i < 3; i++) {
            System.gc();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                System.err.println("Memory measurement interrupted");
                Thread.currentThread().interrupt();
                break;
            }
            memory = runtime.totalMemory() - runtime.freeMemory();
        }
        return memory;
    }


    private static void printPuzzle(int[][] puzzle) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) System.out.println("-".repeat(11));
            for (int j = 0; j < 9; j++) {
                System.out.print(puzzle[i][j] + (j % 3 == 2 && j < 8 ? " | " : " "));
            }
            System.out.println();
        }
    }
}