import io.InputReader;
import io.OutputWriter;
import sort.quicksort.InsertionSort;
import sort.quicksort.QuickSort_DualPivot;
import sort.radix.LSDRadixSort;
import sort.radix.MSDRadixSort;
import sort.radix.RadixItem;
import sort.timsort.Timsort;
import util.Benchmark;
import util.Benchmark_Timer;

import java.util.Locale;
import java.util.function.Function;

public class Main {



    /**
     * main() runs the benchmark for the enitre project
     * Be sure to create output/results dir to run
     * @param args
     */

    public static void main(String[] args) {


        String[] items = InputReader.loadFile("chineese.txt");

        double N[] = new double[]{0.1d, 0.25d, 0.5d, 1d, 2d, 4d};

//        System.out.println("Dual-Pivot Quick Sort");
//        runQuick(items, N);
//        System.out.println("Tim Sort");
//        runTim(items, N);
        System.out.println("MSD Radix Sort");
        runMSD(items, N);
        //System.out.println("LSD Radix Sort");
        //runLSD(items, N);
//        System.out.println("Insertion Sort");
//        runInsertion(items, N);


    }


    private static void runQuick(String[] items, double[] N) {
        String description = "Dual Pivot sort";
        double[] times = runBenchmarks(items, (b) -> {
            QuickSort_DualPivot sort = new QuickSort_DualPivot("", b.length);
            sort.sort(b, false);
            return null;
        }, description, N);
        logTime(times, N, description);

    }

    private static void runMSD(String[] items, double[] N) {
        String description = "MSD Radix sort";
        double[] times = runBenchmarks(items, (b) -> {
            MSDRadixSort.sort(b);
            return null;
        }, description, N);
        logTime(times, N, description);

    }

    private static void runLSD(String[] items, double[] N) {
        String description = "LSD Radix sort";
        double[] times = runBenchmarks(items, (b) -> {
            LSDRadixSort.sort(b);
            return null;
        }, description, N);
        logTime(times, N, description);

    }

    private static void runTim(String[] items, double[] N) {
        String description = "Tim Sort";
        double[] times = runBenchmarks(items, (b) -> {
            Timsort.sort(b);
            return null;
        }, description, N);
        logTime(times, N, description);
    }

    private static void runInsertion(String[] items, double[] N) {
        String description = "Insertion sort";
        double[] times = runBenchmarks(items, (b) -> {
            InsertionSort.sort(b, 0, b.length);
            return null;
        }, description, N);
        logTime(times, N, description);

    }


    private static double[] runBenchmarks(String source[], Function<RadixItem[], Void> sort, String description, double[] multiplierArray) {

        double[] time = new double[multiplierArray.length];
        int i = 0;
        for (double multiplier : multiplierArray) {
            time[i++] = runBenchmark(
                    RadixItem.createItem(multiplyArray(source, multiplier), Locale.CHINESE),
                    sort,
                    description);
            System.out.println(multiplier + ": " + time[i - 1]);
        }

        return time;


    }

    private static double runBenchmark(RadixItem source[], Function<RadixItem[], Void> sort, String description) {

        Benchmark<RadixItem[]> bm = new Benchmark_Timer<>(
                description, (sourceFile) -> {

            RadixItem[] output = new RadixItem[sourceFile.length];
            System.arraycopy(sourceFile, 0, output, 0, sourceFile.length);
            return output;
        }, b -> {
            //MSDRadixSort.sort(b);
            sort.apply(b);
        }, (b) -> {
            b = null;
        });

        double timeTaken = bm.run(source, 25);
        return timeTaken;
    }


    private static String[] multiplyArray(String[] array, double mul) {

        String[] newArray = new String[(int) Math.floor(array.length * mul)];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = new String(array[i % array.length]);
        }

        return newArray;
    }


    private static void logTime(double times[], double N[], String desc) {

        String[] csv = new String[N.length];

        for (int i = 0; i < csv.length; i++) {
            csv[i] = (N[i] * 1000000d) + "," + times[i];
        }
        OutputWriter.writeFile(csv, "results/" + desc + ".csv");


    }


}
