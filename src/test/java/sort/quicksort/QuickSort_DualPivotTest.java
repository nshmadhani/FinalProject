package sort.quicksort;

import io.InputReader;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class QuickSort_DualPivotTest {


    @Test
    public void sortEnglish() {
        String[] sourceFile = InputReader.loadFile("english-20k.txt");
        String[] output = new String[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        QuickSort<String> qs = new QuickSort_DualPivot<String>("Quicksort English", output.length);
        qs.sort(output, false);
        Arrays.sort(sourceFile);
        assertArrayEquals(sourceFile, output);
    }
    @Test
    public void sortIntegers() {
        String[] sourceFile = InputReader.loadFile("integers.txt");
        String[] output = new String[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        QuickSort<String> qs = new QuickSort_DualPivot<String>("Quicksort Int", output.length);
        qs.sort(output, false);
        Arrays.sort(sourceFile);
        assertArrayEquals(sourceFile, output);
    }
    @Test
    public void sortChineese() {
        String[] sourceFile = InputReader.loadFile("chineese.txt");
        String[] output = new String[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        QuickSort<String> qs = new QuickSort_DualPivot<String>("Quicksort Chineese", output.length);
        qs.sort(output, false);
        Arrays.sort(sourceFile);
        assertArrayEquals(sourceFile, output);
    }



}