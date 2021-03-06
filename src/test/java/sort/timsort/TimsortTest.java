package sort.timsort;

import io.InputReader;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TimsortTest {

    @Test
    public void sortEnglish() {
        String[] sourceFile = InputReader.loadFile("english-20k.txt");
        String[] output = new String[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        Timsort.sort(output);
        Arrays.sort(sourceFile);
        assertArrayEquals(sourceFile, output);
    }
    @Test
    public void sortInts() {
        String[] sourceFile = InputReader.loadFile("integers.txt");
        String[] output = new String[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        Timsort.sort(output);
        Arrays.sort(sourceFile);
        assertArrayEquals(sourceFile, output);
    }
    @Test
    public void sortChineese() {
        String[] sourceFile = InputReader.loadFile("chineese.txt");
        String[] output = new String[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        Timsort.sort(output);
        Arrays.sort(sourceFile);
        assertArrayEquals(sourceFile, output);
    }
}