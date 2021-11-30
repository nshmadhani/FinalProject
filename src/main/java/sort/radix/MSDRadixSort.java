package sort.radix;
/******************************************************************************
 *  Compilation: javac MSDRadixSort.java
 *  Execution:   java MSDRadixSort < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/51radix/words3.txt
 *                https://algs4.cs.princeton.edu/51radix/shells.txt
 *
 *  Sort an array of strings or integers using MSDRadixSort radix sort.
 *
 *  % java MSDRadixSort < shells.txt
 *  are
 *  by
 *  sea
 *  seashells
 *  seashells
 *  sells
 *  sells
 *  she
 *  she
 *  shells
 *  shore
 *  surely
 *  the
 *  the
 *
 ******************************************************************************/

/**
 * The {@code MSDRadixSort} class provides static methods for sorting an
 * array of extended ASCII strings or integers using MSDRadixSort radix sort.
 * <p>
 * For additional documentation,
 * see <a href="https://algs4.cs.princeton.edu/51radix">Section 5.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 * <p>
 * Algoorth has been modified to work on byte arrays
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * @author Nishay
 * @author aravind
 */
public class MSDRadixSort {
    private static final int BITS_PER_BYTE = 8;
    private static final int BITS_PER_INT = 32;   // each Java int is 32 bits
    private static final int R = 256;   // extended ASCII alphabet size
    private static final int CUTOFF = 15;   // cutoff to insertion sort

    // do not instantiate
    private MSDRadixSort() {
    }

    /**
     * Rearranges the array of extended ASCII strings in ascending order.
     *
     * @param a the array to be sorted
     */

    // exchange a[i] and a[j]
    //recommendation: To avoid inspecting many empty buckets is to record the minimum and maximum character encountered
    // during the bucketing phase and then only look at the buckets in between these extreme values.


    /**
     * Rearranges the array of 32-bit integers in ascending order.
     * Currently assumes that the integers are nonnegative.
     *
     * @param a the array to be sorted
     */
    public static void sort(RadixItem[] a) {
        int n = a.length;
        RadixItem[] aux = new RadixItem[n];
        sort(a, 0, n - 1, 0, aux);
    }

    // MSDRadixSort sort from a[lo] to a[hi], starting at the dth byte
    private static void sort(RadixItem[] a, int lo, int hi, int d, RadixItem[] aux) {

        // cutoff to insertion sort for small subarrays
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi);
            return;
        }

        // compute frequency counts (need R = 256)
        int[] count = new int[R + 1];
        for (int i = lo; i <= hi; i++) {
                int c = a[i].getByte(d) & 0xFF;
                count[c + 1]++;
        }
        // transform counts to indicies
        for (int r = 0; r < R; r++)
            count[r + 1] += count[r];

        // distribute
        for (int i = lo; i <= hi; i++) {
            int c = a[i].getByte(d) & 0xFF;
            aux[count[c]++] = a[i];
        }
        // copy back
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        // recursively sort for each character
        // (could skip r = R/2 for d = 0 and skip r = R for d > 0)
        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1, aux);

    }

    // insertion sort a[lo..hi]
    private static void insertion(RadixItem[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && a[j].getCollationKey().compareTo(a[j - 1].getCollationKey()) < 0; j--)
                exch(a, j, j - 1);
    }

    // exchange a[i] and a[j]
    private static void exch(RadixItem[] a, int i, int j) {
        RadixItem temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * Reads in a sequence of extended ASCII strings from standard input;
     * MSDRadixSort radix sorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
//        String[] a = StdIn.readAllStrings();
//        int n = a.length;
//        sort(a);
//        for (int i = 0; i < n; i++)
//            StdOut.println(a[i]);
    }


}
