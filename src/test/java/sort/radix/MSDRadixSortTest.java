package sort.radix;

import io.InputReader;
import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

import static org.junit.Assert.assertArrayEquals;

public class MSDRadixSortTest {
    @org.junit.After
    public void tearDown() {
    }

    /*
     * 1. Load the new File to test on into the inputs/ folder
     * 2. Use InputReader to load into a String[],
     * 3. Pass the string[] to RadixItem.createItem(sting[], locale) => you can use Locale.CHINEESE("Frendch", "GERMAN")
     * 4. Create a copy of RadixItem[] array
     * 5. Pass one to MSDRadixSort.sort()
     * 6. Pass another to Arrays.sort() with the itemComparator
     *
     * Languages to Add:
     *   1. Chinese - Pinyin,
     *   2. Hindi
     *   3. Sanskrit
     *   4. Urdu
     *   5. Marathi
     *   6. English
     *   7. French
     *   8. German
     *   9. Spanish
     *   10. Korean
     *   11. Japanese
     *   Add documentation to all sortTests
     *
     *
     * */

    @org.junit.Test
    public void sortEnglishTest() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("english-20k.txt"),
                Locale.ENGLISH);
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        MSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
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
        assertArrayEquals(sourceFile, output);
    }
}