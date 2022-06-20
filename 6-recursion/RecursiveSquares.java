public class RecursiveSquares {
    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double size) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, size / 2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, size / 2);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;
        
        // top right
        draw(n - 1, x + size / 2, y + size / 2, size / 2);
        // top left
        draw(n - 1, x - size / 2, y + size / 2, size / 2);

        drawSquare(x, y, size);

        // bottom left
        draw(n - 1, x - size / 2, y - size / 2, size / 2);
        // bottom right
        draw(n - 1, x + size / 2, y - size / 2, size / 2);

    }


    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double x = 0.5;
        double y = 0.5;
        double size = 0.5;
        draw(n, x, y, size);
    }
}
