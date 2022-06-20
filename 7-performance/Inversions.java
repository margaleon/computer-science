public class Inversions {

    // Return the number of inversions in the permutation a[].
    // The count() method should take time proportional to n2 in the worst case
    public static long count(int[] arr) {
        long inversions = 0;
        // traverse through the array from start to end
        for (int i = 0; i < arr.length - 1; i++) {
            // for every element i, find the count of elements j smaller than
            // the current number up to that index using another loop
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    // Sum up the count of inversion for every index
                    inversions++;
                }
            }
        }
        return inversions;
    }

    // Return a permutation of length n with exactly k inversions.
    // The generate() method should take time proportional to n in the worst case
    public static int[] generate(int n, long k) {
        if (n == 1) {
            int[] arr = { 1 };
            return arr;
        }
        if (k == 0) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            return arr;
        }
        // initialize array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        // set inversions count to 0
        int inversions = 0;
        int i = 0;

        while (inversions < k && i < n) {
            int j = i - 1;
            while (j >= 0 && inversions < k) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                inversions++;
                j--;
            }
            i++;
        }
        return arr;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int permuted[] = generate(n, k);
        // The main() method should print the permutation of length n to
        // standard output as a sequence of n integers, separated by whitespace,
        // all on one line
        for (int i = 0; i < permuted.length; i++) {
            StdOut.print(permuted[i] + " ");
        }

        count(permuted);
    }
}

