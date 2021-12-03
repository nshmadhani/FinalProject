/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package sort.quicksort;


/**
 * Taken from INFO6205 Repo - not modified
 *
 * @param
 */
public class InsertionSort {


    /**
     * Constructor for InsertionSort
     *
     *
     */
    public InsertionSort() {

    }


    /**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
    public static void sort(Comparable[] xs, int from, int to) {
        for (int i = from; i < to; i++) {
            Comparable key = xs[i];
            int j = i - 1;
            while (j >= from && !less(xs[j], key)) {
                swap(xs, j, j + 1);
                j = j - 1;
            }
            xs[j + 1] = key;
        }
    }

    private static void swap(Comparable[] xs, int j, int i) {
        Comparable temp = xs[i];
        xs[i] = xs[j];
        xs[j] = temp;
    }

    private static boolean less(Comparable x, Comparable key) {
        return x.compareTo(key) < 0;
    }


}
