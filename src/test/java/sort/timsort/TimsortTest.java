package sort.timsort;

import io.InputReader;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TimsortTest {

    @Test
    public void sort() {
        String[] sourceFile = InputReader.loadFile("english-20k.txt");
        String[] output = new String[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        Timsort.sort(output);
        Arrays.sort(sourceFile);
        assertArrayEquals(sourceFile, output);
    }
}