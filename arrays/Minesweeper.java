public class Minesweeper {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int numMines = Integer.parseInt(args[2]);

        // a boolean 2D array to specify which cells contain mines
        boolean[][] mines = new boolean[x + 2][y + 2];
        // an integer 2D array to count the number of neighboring mines
        int[][] cells = new int[x + 2][y + 2];

        // Pick random positions for mines and store them in the boolean array
        // System.out.println("dimension of grid: " + (x + 2) + " " + (y + 2));
        for (int k = 0; k < numMines; k++) {
            // random number between 1 and 8 including both
            // int r = (int) (Math.random() * (upper - lower)) + lower;
            int rX = (int) (Math.random() * (x) + 1);
            int rY = (int) (Math.random() * (y) + 1);

            if (!mines[rX][rY]) {
                mines[rX][rY] = true;
            }
            // System.out.println(rX + " " + rY);
        }

        // Generate an m-by-n grid of cells, with exactly k of the mn cells
        // containing mines, uniformly at random
        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < y + 1; j++) {
                // For each cell not containing a mine, count the number of
                // neighboring mines (above, below, left, right, or diagonal)
                if (mines[i + 1][j]) cells[i][j]++;
                if (mines[i + 1][j - 1]) cells[i][j]++;
                if (mines[i + 1][j + 1]) cells[i][j]++;
                if (mines[i - 1][j]) cells[i][j]++;
                if (mines[i - 1][j + 1]) cells[i][j]++;
                if (mines[i - 1][j - 1]) cells[i][j]++;
                if (mines[i][j - 1]) cells[i][j]++;
                if (mines[i][j + 1]) cells[i][j]++;

                // System.out.print(cells[i][j]);
            }
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                // Place the k mines uniformly among the xy cells
                if (mines[i][j]) {
                    System.out.print("*  ");
                }
                else {
                    // print the results
                    System.out.print(cells[i][j] + "  ");
                }
            }
            System.out.print("\n");
        }
    }
}
