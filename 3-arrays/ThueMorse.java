public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // create a boolean array of length n
        int[] sequence = new int[n];

        for (int k = 0; k < n; k++) {
            if (k == 0) {
                // Initialize the first bit in the array to 0
                sequence[k] = 0;
            }
            else if (k % 2 == 0) {
                sequence[k] = sequence[k / 2];
            }
            else if (k % 2 == 1) {
                // for negation, you need not perform bit level operations.
                // Use integers with the operation newValue = 1 - oldValue
                sequence[k] = 1 - sequence[k - 1];
            }
        }
        // System.out.println(Arrays.toString(sequence));

        // Use a double nested loop to determine whether bits i and j in
        // the sequence are equal
        for (int i = 0; i < sequence.length; i++) {
            for (int j = 0; j < sequence.length; j++) {
                if (sequence[i] == sequence[j]) {
                    System.out.print("+  ");
                }
                else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }

    }
}
