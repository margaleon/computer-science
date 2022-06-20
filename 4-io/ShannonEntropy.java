public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] freq = new int[m + 1];
        double count = 0;
        double entropy = 0.0;

        while (!StdIn.isEmpty()) {
            // read the values from the input
            int value = StdIn.readInt();
            // track the frequency of the number in an array
            freq[value] += 1;
            // track count of numbers from the input
            count += 1;
        }

        for (int i = 1; i <= m; i++) {
            double p = 0;
            if (freq[i] != 0) {
                // calculate probability for each number (only if this
                // number appears, else its probability is 0)
                p = -(freq[i] / count * (Math.log(freq[i] / count)
                        / Math.log(2)));
                // StdOut.println(p);
            }
            // add p to total entropy
            entropy += p;
        }
        StdOut.printf("%.4f", entropy);
    }
}
