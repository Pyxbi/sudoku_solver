public class test {
    public static void main(String[] args) {
        System.out.println("DLX Solver Tests");
        DLX.Test.main(new String[]{});

        System.out.println("\nBacktracking Solver Tests");
        backtracking.Test.main(new String[]{});

        System.out.println("\nConstraint Propagation Solver Tests");
        constraintPropagation.Test.main(new String[]{});
    }
}
