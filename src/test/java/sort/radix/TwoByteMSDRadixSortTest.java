package sort.radix;


import io.InputReader;
import io.OutputWriter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

import static org.junit.Assert.assertArrayEquals;

public class TwoByteMSDRadixSortTest {


    @org.junit.After
    public void tearDown() {
    }



    @org.junit.Test
    public void sortIntegers() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("integers.txt"),
                Locale.ENGLISH);
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        TwoByteMSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "integers.txt");
        assertArrayEquals(sourceFile, output);
    }

    @org.junit.Test
    public void sortEnglishTest() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("english-20k.txt"),
                Locale.ENGLISH);
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        TwoByteMSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "Sorted-English-Words.txt");
        assertArrayEquals(sourceFile, output);
    }

    @Test
    public void sortChineeseTest() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("chineese-1000.txt"),
                Locale.CHINA);
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        TwoByteMSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        assertArrayEquals(sourceFile, output);
    }

    @Test
    public void sortHindiTest() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("Hindi-Words.txt"),
                new Locale("hi-IN"));
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        TwoByteMSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "Sorted-Hindi-Words.txt");
        assertArrayEquals(sourceFile, output);
    }

    @Test
    public void sortRussianTest() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("russian-20K.txt"),
                new Locale("ru-RU"));
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        TwoByteMSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "Sorted-russian-20K.txt");
        assertArrayEquals(sourceFile, output);
    }

    @Test
    public void sortJapaneseTest() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("japanese-15K.txt"),
                Locale.JAPANESE);
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        TwoByteMSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "Sorted-japanese-20K.txt");
        assertArrayEquals(sourceFile, output);
    }

    @Test
    public void sortGermanTest() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("german-20K.txt"),
                Locale.GERMAN);
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        TwoByteMSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "Sorted-german-20K.txt");
        assertArrayEquals(sourceFile, output);
    }

    @Test
    public void sortFrenchTest() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("french-15K.txt"),
                Locale.FRENCH);
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        TwoByteMSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "Sorted-french-15K.txt");


        assertArrayEquals(sourceFile, output);
    }

    @Test
    public void sortKoreanTest() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("Korean-15K.txt"),
                new Locale("ko_KR"));
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        TwoByteMSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "Sorted-Korean-15K.txt");
        assertArrayEquals(sourceFile, output);
    }

    @Test
    public void sortSankskritTest() {
        RadixItem[] sourceFile = RadixItem.createItem(InputReader.loadFile("Sanskrit-15K.txt"),
                new Locale("sa_IN"));
        RadixItem[] output = new RadixItem[sourceFile.length];
        System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
        TwoByteMSDRadixSort.sort(output);
        Arrays.sort(sourceFile);
        OutputWriter.writeFile(output, "Sorted-Sanskrit-15K.txt");
        assertArrayEquals(sourceFile, output);
    }
}