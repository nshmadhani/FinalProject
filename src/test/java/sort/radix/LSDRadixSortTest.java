package sort.radix;

import io.InputReader;
import io.OutputWriter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

import static org.junit.Assert.assertArrayEquals;

public class LSDRadixSortTest {


    @org.junit.Test
    public void sortBasic() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("basic.txt"),
                Locale.ENGLISH);
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        MSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "basic.txt");
        assertArrayEquals(sourceFile, output);
    }


    @org.junit.Test
    public void sortEnglishTest() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("english-20k.txt"),
                Locale.ENGLISH);
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        MSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "english-20k.txt");
        assertArrayEquals(sourceFile, output);
    }

    @Test
    public void sortChineeseTest() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("chineese.txt"),
                Locale.CHINESE);
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        MSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "chineese.txt");
        assertArrayEquals(sourceFile, output);
    }
}