package sort.quicksort;

import io.InputReader;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class QuickSort_DualPivotTest {


    @Test
    public void sortTest1() {

        String[] sourceFile = InputReader.loadFile("english-20k.txt");
        String[] output = new String[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        QuickSort<String> qs = new QuickSort_DualPivot<String>("Quicksort English", output.length);
        qs.sort(output, false);
        Arrays.sort(sourceFile);
        assertArrayEquals(sourceFile, output);

    }

}