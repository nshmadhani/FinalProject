/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package sort.quicksort;


public class InsertionSort<X extends Comparable<X>> {

    int N;

    /**
     * Constructor for InsertionSort
     *
     * @param N the number elements we expect to sort
     */
    public InsertionSort(int N) {
        this.N = N;
    }


    /**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
    public void sort(X[] xs, int from, int to) {
        for (int i = from; i < to; i++) {
            X key = xs[i];
            int j = i - 1;
            while (j >= from && !less(xs[j], key)) {
                swap(xs, j, j + 1);
                j = j - 1;
            }
            xs[j + 1] = key;
        }
    }

    private void swap(X[] xs, int j, int i) {
        X temp = xs[i];
        xs[i] = xs[j];
        xs[j] = temp;
    }

    private boolean less(X x, X key) {
        return x.compareTo(key) < 0;
    }


}
