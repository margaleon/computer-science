import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {

        String filename = args[0];
        int k = Integer.parseInt(args[1]);

        // StdOut.println(filename);
        // StdOut.println(k);

        In in = new In(filename);

        String title = in.readLine();
        String xAxisLabel = in.readLine();
        String dataSource = in.readLine();

        BarChart chart = new BarChart(title, xAxisLabel, dataSource);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        // StdAudio.loop("soundtrackB.wav");

        while (in.hasNextLine()) {
            in.readLine();
            int nums = Integer.parseInt(in.readLine());
            String date = "";

            Bar[] bars = new Bar[nums];

            for (int i = 0; i < nums; i++) {
                String temp = in.readLine();
                String[] arr = temp.split(",");
                date = arr[0];
                String name = arr[1];
                String country = arr[2];
                int value = Integer.parseInt(arr[3]);
                String category = arr[4];

                bars[i] = new Bar(name, value, category);

            }
            Arrays.sort(bars);

            chart.reset();
            chart.setCaption(date);
            for (int i = nums - 1; i >= nums - k; i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);

        }
    }
}
