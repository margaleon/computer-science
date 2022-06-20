public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // Call StdDraw.setScale(0, n) so that x- and y-coordinates of the
        // canvas range from 0 and n
        // (0, 0) starts on bottom left of the canvas
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // for each row and each column, check if square index is even
                // if yes squares will be blue
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                // otherwise they will be grey
                else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }
}
