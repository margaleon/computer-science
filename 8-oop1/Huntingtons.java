public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int n = dna.length();
        int maxCount = 0;
        int count = 0;

        int i = 0;
        while (i <= n - 3) {
            // check if nucleotide C occurs
            if (dna.charAt(i) == 'C') {
                // if so define a codon with three nucleotides
                String codon = dna.substring(i, i + 3);
                // if this nucleotide is CAG add 1 to the count
                if (codon.equals("CAG")) {
                    count++;
                    // save the maximum count encountered so far
                    maxCount = Math.max(count, maxCount);
                    // move 3-by-3 steps
                    i += 3;
                    continue;
                }
            }
            // reinitialize the count to 0
            count = 0;
            i++;
        }
        return maxCount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String copy = s.replace(" ", "").replace("\t", "").replace("\n", "");
        return copy;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9 || maxRepeats >= 181) {
            return "not human";
        }
        else if (maxRepeats <= 35) {
            return "normal";
        }
        else if (maxRepeats <= 39) {
            return "high risk";
        }
        else return "Huntington's";
    }

    public static void main(String[] args) {
        In datafile = new In(args[0]);
        String dna = datafile.readAll();

        String formattedDna = removeWhitespace(dna);
        int maxRepeats = maxRepeats(formattedDna);
        StdOut.println("max repeats = " + maxRepeats);
        StdOut.println(diagnose(maxRepeats));

    }
}
