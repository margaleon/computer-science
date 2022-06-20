public class ColorHSB {
    private final int hue;          // the hue (between 0 and 359)
    private final int saturation;   // the saturation (between 0 and 100)
    private final int brightness;   // the brightness (between 0 and 100)

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359)
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (s < 0 || s > 100)
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (b < 0 || b > 100)
            throw new IllegalArgumentException("the brightness must be between 0 and 100");
        hue = h;
        saturation = s;
        brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return saturation == 0 || brightness == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int dh1 = this.hue - that.hue;
        int dh2 = 360 - Math.abs(dh1);
        int ds = this.saturation - that.saturation;
        int db = this.brightness - that.brightness;
        return Math.min(dh1 * dh1, dh2 * dh2) + ds * ds + db * db;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // the color specified on the command line
        int h0 = Integer.parseInt(args[0]);
        int s0 = Integer.parseInt(args[1]);
        int b0 = Integer.parseInt(args[2]);
        ColorHSB color0 = new ColorHSB(h0, s0, b0);


        // the champion color name (and corresponding distance and color)
        String closestName = null;
        int closestDistance = Integer.MAX_VALUE;
        ColorHSB closestColor = null;

        // read colors from standard input and find closest color
        while (!StdIn.isEmpty()) {
            // read next color from standard input
            String name = StdIn.readString();
            int h = StdIn.readInt();
            int s = StdIn.readInt();
            int b = StdIn.readInt();
            ColorHSB color = new ColorHSB(h, s, b);

            // update champion color if closer
            int distance = color0.distanceSquaredTo(color);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestName = name;
                closestColor = color;
            }
        }
        // print closest color to standard output
        StdOut.println(closestName + " " + closestColor);
    }
}
