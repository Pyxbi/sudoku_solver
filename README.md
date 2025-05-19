<h1 align="center">COSC2469|COSC2722 - Data Structure and Algorithm</h1>
<h2 align="center" style="font-size: 30px;">The Maze Navigation</h2>

### I. CONTRIBUTION INFORMATION

The starting score for each student is 5 points. Each group can decide to add/remove points to/from each member, but the total point of the whole group is kept unchanged (it is = (the number of members) * 5). Additional rules:

<ul>
    <li>The maximum point for a member is 7.
    <li>If a member gets zero points => that member gets zero for the whole group project assignment. In this case, the total point of the whole group = (the number of members whose scores > zero) * 5.
    <li>The contribution score must be agreed upon by all members. If there are disagreements, you must inform the lecturer/coordinator before the due time.
    <li>The maximum score for the whole project is 35. If you get more than 35 (due to a high contribution score), the final score is 35.
</ul>


#### TOTAL GROUP CONTRIBUTION SCORE: 15
#### CONTRIBUTOR 1: [PHAM LE GIA HUY](https://github.com/vhpx) (ID: S3975371)
#### Given score: 5

- Implemented data structure and algorithm of dlx.
- Report reaserching and writting.


#### CONTRIBUTOR 2: [NGUYEN THACH KHANH DZI](https://github.com/VanTaizz) (ID: S3980883)
#### Given score: 5

- write code backtracking to compare
- Complexity analyses of data structure and algorithm.
- Report reaserching and writting


#### CONTRIBUTOR 3: [NGUYEN PHAM TIEN HAI](https://github.com/TriDuong070803) (ID: S3979239)
#### Given score: 5

- write code constraint propagation
- Report reaserching and writting
- etc...

#### CONTRIBUTOR 4: [NGUYEN THI NGOAN](https://github.com/TriDuong070803) (ID: S3912026)
#### Given score: 5

- implemented testing and compare
- Report reaserching and writting
- etc...

#### CONTRIBUTOR 5: [NGUYEN VIET PHAP](https://github.com/TriDuong070803) (ID: S4012986)
#### Given score: 5

- design class diagram
- Report reaserching and writting
- etc...
### II. INSTRUCTION

#### a. Main class
> The main entry point is the `Main.java` file. This class allows users to define Sudoku puzzles and execute the solver. The application supports solving puzzles using Donald Knuth’s Algorithm X implemented through the Dancing Links (DLX) data structure. Users can also benchmark performance and memory usage.

**Key operations:**
- Define a 9×9 puzzle as a 2D integer array (`0` represents empty cells).
- Instantiate the `RMIT_Sudoku_Solver` class with the puzzle as input.
- Call the `solve()` method to compute the solution.
- Output is displayed on the console with timing and memory statistics.

**Example usage:**
```java
int[][] puzzle = {
        {5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,7,9}
};
RMIT_Sudoku_Solver solver = new RMIT_Sudoku_Solver(puzzle);
solver.solve();
```

#### b. Solver logic
> The system models Sudoku as an Exact Cover problem and solves it using recursive backtracking via DLX. The `RMIT_Sudoku_Solver` builds the matrix, applies pre-filled clues, and runs `dlSearch()` to find a valid solution. The solution is reconstructed into a 9×9 grid and printed.

**Core methods:**
- `solve()`: Prepares matrix and initiates solving.
- `dlSearch(int k, DLHeaderNode masterNode)`: Recursively searches for the solution.
- `handlePreFilledEntries()`: Prunes the search space using the initial clues.

#### c. Testing and validation
> The project includes unit and functional testing to ensure solver correctness. The test cases cover a variety of puzzles, including:
- Fully solved
- Empty puzzle
- Puzzles with one missing cell
- Extremely hard puzzles (e.g. 17-clue)
- Invalid puzzles

**Validation utility:**
- `isValidSudoku()`: Ensures the final solution adheres to Sudoku rules.

Refer to `Appendix B` of the report for detailed unit and functional test results.

#### d. Performance evaluation
> To evaluate efficiency, each algorithm folder contains a `Test.java` file to benchmark:
- **DLX (Dancing Links)**
- **Backtracking**
- **Constraint Propagation**

These test files log:
- Execution time in milliseconds
- Memory usage in KB
- Whether the puzzle is solved correctly
- Whether the solution completes within 2 minutes

**Sample output:**


> ```
> Case 2: 17-Clue Unique Puzzle | Time: 0.09 ms | Memory: 7.02 KB | Valid: Yes | Within 2 min: Yes
> Case 3: Easy Puzzle | Time: 0.12 ms | Memory: 17.84 KB | Valid: Yes | Within 2 min: Yes
> ```

> For small-scale testing or demonstration, modify the puzzle directly in `Main.java`. For large-scale benchmarking, use the `Test.java` files provided under each solver’s folder.

#### e. Test Efficiency class
> The `TestEfficiency` file included in the folder is provided to **benchmark the performance** of three different Sudoku-solving algorithms: **Dancing Links (DLX)**, **Backtracking**, and **Constraint Propagation**. This file is especially useful when you want to test the methods on a **large number of puzzles** with varying difficulty levels, such as easy puzzles, extremely hard puzzles (like 17-clue ones), or even invalid ones.

Each solver has its own version of `Test.java` located in their respective folders. These files will:
- Automatically run a series of predefined Sudoku puzzles.
- Measure **execution time**, **memory usage**, and whether the puzzle is **solved correctly within 2 minutes**.
- Print a consistent summary report for easy comparison.

> ```
> Case 4: Easy Puzzle (45 clues) | Time: 0.07 ms | Memory: 12.83 KB | Valid: Yes | Within 2 min: Yes
> Case 8: 17-clue Puzzle | Time: 1.03 ms | Memory: 18.04 KB | Valid: Yes | Within 2 min: Yes
> ```

> For small-scale testing or function validation, we recommend using the manually created test data inside the `Main.java` file instead. For performance benchmarking or algorithm comparison, run the corresponding `Test.java` file inside each algorithm’s directory.


### III. OTHER RESOURCES

#### a. DEMONSTRATION VIDEO
[CLICK HERE TO GO TO DEMONSTRATION VIDEO ON YOUTUBE](https://rmiteduau-my.sharepoint.com/:v:/g/personal/s3980883_rmit_edu_vn/Ec4OYlhiCtBHlwK4glJfNxcB5YZ8rvYINX1n6z8tL6AM2Q?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=cqMkVD)


#### b. UML DIAGRAM
[CLICK HERE TO GO TO LUCID CHART](https://app.diagrams.net/?state=%7B%22ids%22:%5B%221gBDCsw3m3oXsf25Ln4gtHDm2BwQvoEaz%22%5D,%22action%22:%22open%22,%22userId%22:%22116853784373455700089%22,%22resourceKeys%22:%7B%7D%7D)
- if can not access click the "try opening via this page"
<img src = UML.png>