package util;

import io.InputReader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;

public class ChartHelper {
    public static void printChart(XYDataset dataset, String fileName, String title, String xLabel, String yLabel) throws IOException {
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                title,
                xLabel,
                yLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);


        int width = 640;   /* Width of the image */
        int height = 480;  /* Height of the image */
        String dir = System.getProperty("user.dir");
        File XYChart = new File(dir + "/" + fileName);
        ChartUtils.saveChartAsPNG(XYChart, xylineChart, width, height);
    }


    private static XYSeries createXYSeries(String filename, String title) {
        XYSeries series = new XYSeries(title);
        String[] values = InputReader.loadFile("../outputs/" + filename);
        for(String val: values) {
            double time = Double.valueOf(val.split(",")[1]);
            double n = Double.valueOf(val.split(",")[0]);
            series.add(n, time);
        }
        return series;
    }

    public static void main(String[] args) throws IOException {

        XYSeries dual = createXYSeries("results/Dual Pivot sort.csv","Dual Pivot Quicksort");
        XYSeries lsd = createXYSeries("results/LSD Radix sort.csv","LSD Radix Sort");
        XYSeries msd = createXYSeries("results/MSD Radix sort.csv","MSD Radix Sort");
        XYSeries merge_husky_sort = createXYSeries("results/Merge Husky Sort.csv","Merge Husky Sort");
        XYSeries tim_sort = createXYSeries("results/Tim Sort.csv","Tim Sort");
        XYSeries two_byte_msd_radix_sort = createXYSeries("results/Two Byte MSD Radix Sort.csv","Two Byte MSD Radix Sort");

        String x = "N - Size of Array";
        String y = "Time in ms";
        printChart(new XYSeriesCollection(dual), "Log Dual Pivot Quicksort.png","Dual Pivot Quicksort", x, y);
        printChart(new XYSeriesCollection(lsd), "Log LSD Radix sort.png","LSD Radix sort", x, y);
        printChart(new XYSeriesCollection(msd), "Log MSD Radix sort.png","MSD Radix sort", x, y);
        printChart(new XYSeriesCollection(merge_husky_sort), "Log Merge Husky Sort.png","Merge Husky Sort", x, y);
        printChart(new XYSeriesCollection(tim_sort), "Log Tim Sort.png","Tim Sort", x, y);
        printChart(new XYSeriesCollection(two_byte_msd_radix_sort), "Log Two Byte MSD Radix Sort.png","Two Byte MSD Radix Sort", x, y);


        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(dual);
        dataset.addSeries(lsd);
        dataset.addSeries(msd);
        dataset.addSeries(merge_husky_sort);
        dataset.addSeries(tim_sort);
        dataset.addSeries(two_byte_msd_radix_sort);

        printChart(dataset, "Log Combined.png","", x, y);







    }

}
