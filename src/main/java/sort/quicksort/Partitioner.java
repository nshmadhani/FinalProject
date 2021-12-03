package sort.quicksort;

import java.util.List;

/**
 * Taken from INFO6205 Repo - not modified
 *
 * @param <X> Element to partition
 */
public interface Partitioner<X extends Comparable<X>> {

    /**
     * Method to partition the given partition into smaller partitions.
     *
     * @param partition the partition to divide up.
     * @return an array of partitions, whose length depends on the sorting method being used.
     */
    List<Partition<X>> partition(Partition<X> partition);
}
