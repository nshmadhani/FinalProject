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
        LSDRadixSort.sort(output);
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
        LSDRadixSort.sort(output);
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
        LSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "chineese.txt");
        assertArrayEquals(sourceFile, output);
    }

//    @Test
//    public void sortHindiTest() {
//        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("Hindi-Words.txt"),
//                new Locale("hi-IN"));
//        RadixItem[] output = new RadixItem[sourceFile.length];
//        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
//        LSDRadixSort.sort(output);
//        Arrays.sort(sourceFile);
//        OutputWriter.writeFile(output, "Sorted-Hindi-Words.txt");
//        assertArrayEquals(sourceFile, output);
//    }
//
//    @Test
//    public void sortRussianTest() {
//        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("russian-20K.txt"),
//                new Locale("ru-RU"));
//        RadixItem[] output = new RadixItem[sourceFile.length];
//        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
//        LSDRadixSort.sort(output);
//        Arrays.sort(sourceFile);
//        OutputWriter.writeFile(output, "Sorted-russian-20K.txt");
//        assertArrayEquals(sourceFile, output);
//    }
//
//    @Test
//    public void sortJapaneseTest() {
//        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("japanese-15K.txt"),
//                Locale.JAPANESE);
//        RadixItem[] output = new RadixItem[sourceFile.length];
//        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
//        MSDRadixSort.sort(output);
//        Arrays.sort(sourceFile);
//        OutputWriter.writeFile(output, "Sorted-japanese-20K.txt");
//        assertArrayEquals(sourceFile, output);
//    }
//
//    @Test
//    public void sortGermanTest() {
//        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("german-20K.txt"),
//                Locale.GERMAN);
//        RadixItem[] output = new RadixItem[sourceFile.length];
//        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
//        LSDRadixSort.sort(output);
//        Arrays.sort(sourceFile);
//        OutputWriter.writeFile(output, "Sorted-german-20K.txt");
//        assertArrayEquals(sourceFile, output);
//    }
}