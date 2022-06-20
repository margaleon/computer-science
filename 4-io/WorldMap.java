public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();

        StdDraw.enableDoubleBuffering();
        // set the size of the canvas to be width-by-height pixels
        StdDraw.setCanvasSize(width, height);
        // x-coordinates of the canvas range from 0 to width and
        // y-coordinates range from 0 to height
        StdDraw.setXscale(0.0, width);
        StdDraw.setYscale(0.0, height);

        while (!StdIn.isEmpty()) {
            StdIn.readString();
            // read number of vertices
            int vertices = StdIn.readInt();
            // create x-coords and y-coords arrays with the length of vertices
            double[] x = new double[vertices];
            double[] y = new double[vertices];
            // store coords in array for each vertice
            for (int i = 0; i < vertices; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            // draw each polygon with corresponding coords
            StdDraw.polygon(x, y);
        }
        StdDraw.show();
    }
}
