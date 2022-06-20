public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
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
            System.out.println("(" + x + "," + y + ")");
            dist = Math.abs(x) + Math.abs(y);
            steps++;
        }
        System.out.println("steps = " + steps);
    }
}
