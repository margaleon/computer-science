import java.util.Arrays;

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        double fraction = 0;
        double totalCounts = 0;
        int i = 1;
        // boolean array of length n (to keep track of which birthdays
        // have been encountered so far in a single experiment).
        boolean[] hasBirthday = new boolean[n];

        while (fraction < 0.5) {
            // the number of times that exactly i people enter the room
            int count = 0;
            for (int t = 1; t <= trials; t++) {
                Arrays.fill(hasBirthday, false);
                int people = 0;

                boolean match = false;

                while (!match) {
                    people++;
                    int r = (int) (n * Math.random());
                    if (hasBirthday[r] && i == people) {
                        count++;
                        match = true;
                    }
                    else if (hasBirthday[r]) break;
                    else hasBirthday[r] = true;
                }
            }
            // calculate fraction of times that i or fewer people enter the room
            totalCounts += count;
            fraction = totalCounts / trials;
            // print the table
            System.out.println(i + "\t" + count + "\t" + fraction);
            i++;
            if (i > n + 3) break;
        }
    }
}
