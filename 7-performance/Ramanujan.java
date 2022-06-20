public class Ramanujan {
    // n is a Ramanujan number if n = a^3 + b^3 = c^3 + d^3
    public static boolean isRamanujan(long n) {
        // Since you are searching for integers a, b, c, and d such that
        // n = a3 + b3 = c3 + d3, you need only consider values for a between 1
        // and cube root of n
        for (long a = 1; a <= Math.ceil(Math.cbrt(n)); a++) {
            // For a given value of a, the only possible way to choose b to
            // make a3 + b3 = n is b = cube root of (n − a3)
            long a3 = a * a * a;
            long b = (long) Math.ceil(Math.cbrt(n - a3));
            long b3 = b * b * b;
            if (a3 > n) break;

            // for (long c = 1; c <= Math.ceil(Math.cbrt(n)) && c != a && c != b; c++) {
            //     long c3 = c * c * c;
            //     long d = (long) Math.ceil(Math.cbrt(n - c3));
            //     long d3 = d * d * d;
            //     if (c3 > a3 + b3) break;

            if (a3 + b3 == n) {
                // StdOut.print((a3 + b3) + " = ");
                // StdOut.print(a + "^3 + " + b + "^3 = ");
                // StdOut.print(c + "^3 + " + d + "^3");
                // StdOut.println();
                // StdOut.println("a3 + b3: " + (a3 + b3));
                // StdOut.println("c3 + d3: " + (c3 + d3));
                return true;
            }
        }
        // }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Math.abs(Long.parseLong(args[0]));
        StdOut.println(isRamanujan(n));
    }
}
