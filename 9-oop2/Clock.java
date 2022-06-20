public class Clock {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;

    private int hours;     // the hour   (between 0 and 23)
    private int minutes;   // the minute (between 0 and 59)
    private String time;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h >= HOURS_PER_DAY) {
            throw new IllegalArgumentException("hours is invalid: " + h);
        }
        if (m < 0 || m >= MINUTES_PER_HOUR) {
            throw new IllegalArgumentException("minutes is invalid: " + m);
        }
        hours = h;
        minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        // The string argument is composed of two digits, followed by a colon,
        // followed by two digits, such as 09:45. Throw an IllegalArgumentException
        // if either the string argument is not in this format or if it does not
        // correspond to a valid time between 00:00 and 23:59.

        time = s;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hours < that.hours) return true;
        if (this.hours > that.hours) return false;
        return this.minutes < that.minutes;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        minutes++;
        if (minutes == MINUTES_PER_HOUR) {
            minutes = 0;
            hours++;
        }
        if (hours == HOURS_PER_DAY) {
            hours = 0;
        }
        // StdOut.println(hours + ":" + minutes);
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        minutes += delta;
        int remainder = minutes % MINUTES_PER_HOUR;
        if (minutes >= MINUTES_PER_HOUR) {
            minutes = remainder;
            hours++;
        }
        if (hours >= HOURS_PER_DAY) {
            hours = 0;
        }
        // StdOut.println(hours + ":" + minutes);
    }

    // Test client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        Clock testTime = new Clock(h, m);

        String timeString = testTime.toString();
        Clock clockString = new Clock(timeString);

        Clock testTime2 = new Clock(15, 30);
        testTime.isEarlierThan(testTime2);

        testTime.tic();
        testTime.toc(50);

    }
}
