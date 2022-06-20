public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length;
        int[] freq = new int[n];
        int total = 0;

        for (int i = 1; i < n; i++) {
            freq[i] = Integer.parseInt(args[i]);
            // Define the cumulative sums Si=a1+a2+…+ai, with S0=0.
            total += freq[i];
            
        }

        for (int j = 0; j < m; j++) {
            // generate random integer with probability proportional to frequency
            int r = (int) (total * Math.random());   // integer in [0, total)
            int sum = 0;
            int event = -1;
            for (int i = 0; i < n && sum <= r; i++) {
                sum += freq[i];
                event = i;
            }

            System.out.print(event + " ");
        }
    }
}
