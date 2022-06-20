public class RevesPuzzle {
    private static void reves(int n, char from, char temp1, char temp2, char to) {
        if (n == 0) return;
        if (n == 1) {
            System.out.println("Move disc " + n + " from " + from + " to " + to);
            return;
        }
        // k the number of smallest discs is calculated every time reves is called
        int k = (int) Math.round(1.0 + n - Math.sqrt(1.0 + 2 * n));
        // StdOut.println(k);
        // StdOut.println(n - k);

        reves(k, from, to, temp2, temp1); // A D C B
        // move n-k largest discs to the destination pole
        hanoi(n - k, k, from, temp2, to); // A C D
        // move k smallest discs to the destination pole recursively
        reves(k, temp1, from, temp2, to); // B A C D
    }

    // move n - k discs from one pole to another, using the temp pole
    private static void hanoi(int n, int k, char from, char temp, char to) {
        if (n == 0) return;
        hanoi(n - 1, k, from, to, temp);
        // add k to n in the output to print the correct disc number
        StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    public static void main(String[] args) {
        // n is the number of discs
        int n = Integer.parseInt(args[0]);
        // move k smallest discs to a temporary pole "B" recursively
        reves(n, 'A', 'B', 'C', 'D');
    }
}

