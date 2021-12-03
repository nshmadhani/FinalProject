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
 * <p>
 * Adapted by @author Nishay Madhani for byte[]
 */
public class LSDRadixSort {
    private static final int R = 256;   // extended ASCII alphabet size

    // do not instantiate
    private LSDRadixSort() {
    }


    /**
     * Rearranges the array of 32-bit integers in ascending order.
     * Currently assumes that the integers are nonnegative.
     *
     * @param a the array to be sorted
     */
    public static void sort(RadixItem[] a) {
        int n = a.length;
        RadixItem[] aux = new RadixItem[n];
        sort(a, 0, n - 1, aux);
    }

    // MSDRadixSort sort from a[lo] to a[hi], starting at the dth byte
    private static void sort(RadixItem[] a, int lo, int hi, RadixItem[] aux) {

        int maxLength = -0;
        for (RadixItem x : a) {
            maxLength = Math.max(maxLength, x.getCollationKeyBytes().length);
        }
        for (int d = maxLength; d >= 0; d--) {
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

        }
    }


}
