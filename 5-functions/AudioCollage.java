public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        // create new double array with length of a
        double[] newSound = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            // for each element in the array, multiply by alpha and store
            // this in the new array
            newSound[i] = a[i] * alpha;
        }
        return newSound;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] newSound = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            newSound[i] = a[a.length - 1 - i];
        }
        return newSound;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] newSound = new double[a.length + b.length];
        // create two for loops that loops through array a and array b
        // and store the elements in the new array
        for (int i = 0; i < a.length; i++) newSound[i] = a[i];
        for (int i = 0; i < b.length; i++) newSound[i + a.length] = b[i];
        return newSound;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] largerSound;
        double[] shorterSound;

        // check if sounds are lager or smaller
        if (a.length < b.length) {
            largerSound = b;
            shorterSound = a;
        }
        else {
            largerSound = a;
            shorterSound = b;
        }

        double[] newSound = new double[largerSound.length];
        for (int i = 0; i < largerSound.length; i++) {
            // If one sound is longer than the other, append 0s to the shorter
            // sound before summing
            if (i >= shorterSound.length) {
                newSound[i] = largerSound[i] + 0;
            }
            // Create a new sound that combines two existing sounds by summing
            // the values of the corresponding samples
            else {
                newSound[i] = a[i] + b[i];
            }
        }
        return newSound;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        // create a smaller or bigger array with size divided by alpha value
        double[] newSound = new double[(int) (a.length / alpha)];
        for (int i = 0; i < (int) (a.length / alpha); i++) {
            newSound[i] = a[(int) (i * alpha)];
        }
        return newSound;
    }

    // Creates an audio collage and plays it on standard audio.
    // The duration must be between 10 and 60 seconds
    // (441,000 to 2,646,000 samples)
    public static void main(String[] args) {
        // read samples from wav files
        double[] piano = StdAudio.read("piano.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] scratch = StdAudio.read("scratch.wav");
        double[] singer = StdAudio.read("singer.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] exposure = StdAudio.read("exposure.wav");
        double[] silence = StdAudio.read("silence.wav");
        double[] cow = StdAudio.read("cow.wav");

        double[] reversePiano = reverse(piano);
        double[] reverseExposure = reverse(exposure);

        double[] doubleCow = amplify(merge(cow, cow), 0.7);
        double[] doubleRevPiano = merge(reversePiano, reversePiano);

        double[] pianoAndExpo = mix(doubleRevPiano, reverseExposure);

        double[] speedUpDial = changeSpeed(dialup, 2);

        double[] part1 = mix(pianoAndExpo, doubleCow);
        double[] part2 = mix(doubleRevPiano, speedUpDial);

        double[] collage = merge(merge(part1, harp), part2);
        
        StdAudio.play(collage);
    }
}
