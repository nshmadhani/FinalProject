package sort.quicksort;


import java.util.Arrays;
import java.util.Collection;

/**
 * Taken from INFO6205 Repo - not modified
 *
 * @param <X>
 */
public abstract class QuickSort<X extends Comparable<X>> {

    public static final int cutoff = 16;
    protected Partitioner<X> partitioner;

    public QuickSort(int N) {
    }

    /**
     * Create a partition on ys from "from" to "to".
     *
     * @param ys   the array to partition
     * @param from the index of the first element to partition.
     * @param to   the index of the first element NOT to partition.
     * @param <Y>  the underlying type of ys.
     * @return a Partition of Y.
     */
    public static <Y extends Comparable<Y>> Partition<Y> createPartition(Y[] ys, int from, int to) {
        return new Partition<>(ys, from, to);
    }

    /**
     * Method to sort.
     *
     * @param xs       sort the array xs, returning the sorted result, leaving xs unchanged.
     * @param makeCopy if set to true, we make a copy first and sort that.
     * @return the result (sorted version of xs).
     */
    public X[] sort(X[] xs, boolean makeCopy) {
        // CONSIDER merge with MergeSortBasic and maybe others.
        X[] result = makeCopy ? Arrays.copyOf(xs, xs.length) : xs;
        sort(result, 0, result.length, 0);
        return result;
    }

    /**
     * Sort the sub-array xs[from] .. xs[to-1]
     *
     * @param xs    the complete array from which this sub-array derives.
     * @param from  the index of the first element to sort.
     * @param to    the index of the first element not to sort.
     * @param depth the depth of the recursion.
     */
    public void sort(X[] xs, int from, int to, int depth) {
        if (terminator(xs, from, to, depth)) return;
        Partition<X> partition = createPartition(xs, from, to);

        Collection<Partition<X>> partitions = partitioner.partition(partition);
        partitions.forEach(p -> sort(p.xs, p.from, p.to, depth + 1));
    }

    /**
     * Protected method to determine to terminate the recursion of this quick sort.
     * NOTE that in this implementation, the depth is ignored.
     *
     * @param xs    the complete array from which this sub-array derives.
     * @param from  the index of the first element to sort.
     * @param to    the index of the first element not to sort.
     * @param depth the current depth of the recursion.
     * @return true if there is no further work to be done.
     */
    protected boolean terminator(X[] xs, int from, int to, int depth) {
        @SuppressWarnings("UnnecessaryLocalVariable") int lo = from;
        if (to <= lo + cutoff) {
            InsertionSort.sort(xs, from, to);
            return true;
        }
        return false;
    }

    public void setPartitioner(Partitioner<X> partitioner) {
        this.partitioner = partitioner;
    }

}

