public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] arr) {
        // check if array is not empty
        int x = arr.length;
        if (x == 0) return 0;
        int y = arr[0].length;
        if (y == 0) return 0;
        int max = 0;

        // create new array
        int[][] sizes = new int[x][y];

        // increment values in b[][] depending on 1s found
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // top left border cases
                if (i == 0 || j == 0) {
                    sizes[i][j] = arr[i][j];
                }
                else if (arr[i][j] == 1) {
                    sizes[i][j] = Math.min(sizes[i][j - 1],
                                           Math.min(sizes[i - 1][j], sizes[i - 1][j - 1])) + 1;
                }
                // StdOut.print(sizes[i][j] + "  ");
                // find the max value
                if (sizes[i][j] > max) max = sizes[i][j];
            }
            // StdOut.println();
        }
        return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = StdIn.readInt();
                // StdOut.print(arr[i][j] + "  ");
            }
            // StdOut.println();
        }
        StdOut.println(size(arr));
    }
}
