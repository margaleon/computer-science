public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // create bidimensional array
        if (k < -n || k > n) return 0;
        else if (k == 0 && n == 0) return 1;
        else {
            n = Math.abs(n);
            k = Math.abs(k);

            long[][] array = new long[n + k + 1][k + n + 1];
            array[0][0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < k + n; j++) {
                    if (j == 0) {
                        array[i][j] = 2 * array[i - 1][j + 1] + array[i - 1][j];
                    }
                    else {
                        array[i][j] = array[i - 1][j - 1] + array[i - 1][j] + array[i - 1][j + 1];
                    }
                }
            }
            return array[n][k];
        }
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
