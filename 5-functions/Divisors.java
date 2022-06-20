public class Divisors {
    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        // Implement an iterative version of Euclid’s algorithm.
        // To compute the greatest common divisor of a and b:

        // Replace (a,b) with (|a|,|b|)
        a = Math.abs(a);
        b = Math.abs(b);

        // Repeatedly replace (a,b) with (b,a % b) until the second integer
        // in the pair is zero.
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        // Return the first integer in the pair as the gcd
        return a;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        // Replace (a,b) with (|a|,|b|)
        a = Math.abs(a);
        b = Math.abs(b);

        int lcm;

        if (a == 0 && b == 0) {
            lcm = 0;
        }
        else {
            // To avoid preventable arithmetic overflow, perform the
            // division before the multiplication
            lcm = (a / gcd(a, b)) * b;
        }
        return lcm;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        // Two integers a and b are relatively prime if and only if gcd(a,b)=1
        if (gcd(a, b) == 1) {
            return true;
        }
        else {
            return false;
        }

    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        n = Math.abs(n);
        int count = 0;
        // call areRelativelyPrime() for each positive integer between 1 and n
        for (int i = 1; i <= n; i++) {
            boolean prime = areRelativelyPrime(i, n);
            if (prime) {
                count++;
            }
        }
        return count;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        StdOut.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        StdOut.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        StdOut.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        StdOut.println("totient(" + a + ") = " + totient(a));
        StdOut.println("totient(" + b + ") = " + totient(b));
    }
}
