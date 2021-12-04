package sort.quicksort;

import io.InputReader;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InsertionSortTest {
    @Test
    public void sortEnglish() {
        String[] sourceFile = InputReader.loadFile("english-20k.txt");
        String[] output = new String[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        InsertionSort.sort(output, 0, output.length);
        Arrays.sort(sourceFile);
        assertArrayEquals(sourceFile, output);
    }
    @Test
    public void sortIntegers() {
        String[] sourceFile = InputReader.loadFile("integers.txt");
        String[] output = new String[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        InsertionSort.sort(output, 0, output.length);
        Arrays.sort(sourceFile);
        assertArrayEquals(sourceFile, output);
    }


}