public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int sum = 0;

        for (int i = 0; i <= trials; i++) {
            int x = 0;
            int y = 0;
            int steps = 0;
            int dist = 0;

            while (dist < r) {
                int random = (int) Math.floor(Math.random() * 4);

                if (random == 0) {
                    x++;
                }
                else if (random == 1) {
                    y++;
                }
                else if (random == 2) {
                    x--;
                }
                else if (random == 3) {
                    y--;
                }
                dist = Math.abs(x) + Math.abs(y);
                steps++;
            }
            sum = sum + steps;
        }
        double average = (double) sum / trials;
        System.out.println("average number of steps = " + average);
    }
}

