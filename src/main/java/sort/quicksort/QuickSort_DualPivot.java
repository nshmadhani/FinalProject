package sort.quicksort;

import java.util.ArrayList;
import java.util.List;


/**
 * Taken from INFO6205 Repo - modified to remove dependency on helper class
 *
 * @param <X>
 */
public class QuickSort_DualPivot<X extends Comparable<X>> extends QuickSort<X> {

    public static final String DESCRIPTION = "QuickSort dual pivot";

    public QuickSort_DualPivot(String description, int N) {
        super(N);
        setPartitioner(createPartitioner());
    }


    public Partitioner<X> createPartitioner() {
        return new Dual_Partitioner<>();
    }

    public class Dual_Partitioner<X extends Comparable<X>> implements Partitioner<X> {

        public Dual_Partitioner() {

        }

        /**
         * Method to partition the given partition into smaller partitions.
         *
         * @param partition the partition to divide up.
         * @return an array of partitions, whose length depends on the sorting method being used.
         */
        public List<Partition<X>> partition(Partition<X> partition) {
            final X[] xs = partition.xs;
            final int lo = partition.from;
            final int hi = partition.to - 1;
            swapConditional(xs, lo, hi);
            int lt = lo + 1;
            int gt = hi - 1;
            int i = lt;
            // NOTE: we are trying to avoid checking on instrumented for every time in the inner loop for performance reasons (probably a silly idea).
            // NOTE: if we were using Scala, it would be easy to set up a comparer function and a swapper function. With java, it's possible but much messier.

            while (i <= gt) {
                X x = xs[i];
                if (x.compareTo(xs[lo]) < 0) swap(xs, lt++, i++);
                else if (x.compareTo(xs[hi]) > 0) swap(xs, i, gt--);
                else i++;
            }
            swap(xs, lo, --lt);
            swap(xs, hi, ++gt);


            List<Partition<X>> partitions = new ArrayList<>();
            partitions.add(new Partition<X>(xs, lo, lt));
            partitions.add(new Partition<X>(xs, lt + 1, gt));
            partitions.add(new Partition<X>(xs, gt + 1, hi + 1));

            return partitions;
        }

        private boolean swapConditional(X[] xs, int i, int j) {
            final X v = xs[i];
            final X w = xs[j];
            boolean result = v.compareTo(w) > 0;
            if (result) {
                // CONSIDER invoking swap
                xs[i] = w;
                xs[j] = v;
            }
            return result;
        }

        // CONSIDER invoke swap in BaseHelper.
        private void swap(X[] ys, int i, int j) {
            X temp = ys[i];
            ys[i] = ys[j];
            ys[j] = temp;
        }

    }
}


