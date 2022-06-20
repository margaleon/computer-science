public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        double latDist = x2 - x1;
        double lonDist = y2 - y1;

        double a = Math.pow((Math.sin((latDist) / 2)), 2) +
                Math.cos(x1) * Math.cos(x2) *
                        Math.pow(Math.sin((lonDist) / 2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = 6371 * c;

        System.out.println(distance + " kilometers");

    }
}
