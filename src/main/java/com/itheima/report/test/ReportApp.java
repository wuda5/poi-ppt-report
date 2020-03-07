package com.itheima.report.test;

import com.itheima.report.baseModel.*;
import com.itheima.report.dataMerge.SlideData;
import com.itheima.report.util.PowerPointGenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b><code>ReportApp</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/10/31 22:48.
 *
 * @author Hu Weihui
 */
public class ReportApp {

    public static void main(String[] args) {
        String templateFile = System.getProperty("user.dir") +
                File.separator + "src\\main\\resources\\demo.pptx";

        String resultFile = System.getProperty("user.dir") +
                File.separator + "src\\main\\resources\\result.pptx";

        Map<Integer, SlideData> data = getData();

        PowerPointGenerator.generatorPowerPoint(templateFile, resultFile, data);
    }

    /**
     * 造点数据玩完吧
     * @return
     */
    private static Map<Integer, SlideData> getData() {
        Map<Integer, SlideData> map = new HashMap<>();
        /** 第1页text **/
        SlideData slideData3 = new SlideData();
        Map<String, String> textDataTest = getTextDataTest();
        slideData3.setTextMap(textDataTest);
        map.put(1, slideData3);


        /**2.   2页表格**/
        SlideData slideData4 = new SlideData();
        map.put(2,  getTableTest(slideData4));


        //3页饼图
        SlideData slideData5 = new SlideData();
        List<ChartData> chartData5 = getChartData();
        slideData5.setChartDataList(chartData5);
        map.put(3, slideData5);
        //4页柱状图
        SlideData slideData6 = new SlideData();
        List<ChartData> chartData6 = getChartData2();
        slideData6.setChartDataList(chartData6);
        Map<String, String> textDataTest2 = getTextDataTest2();
        slideData6.setTextMap(textDataTest2);
        map.put(4, slideData6);

        //5页折线图
        SlideData slideData8 = new SlideData();
        List<ChartData> chartData3 = getChartData2();
        slideData8.setChartDataList(chartData3);
        map.put(5, slideData8);

        return map;
    }

    private static Map<String, String> getTextDataTest() {
        Map<String, String> textMap = new HashMap<>();
        textMap.put("3A", "测试成功A");
        textMap.put("3B", "测试成功B");
        return textMap;
    }

    private static Map<String, String> getTextDataTest2() {
        Map<String, String> textMap = new HashMap<>();
        textMap.put("6A", "测试成功A");
        textMap.put("6B", "测试成功B");
        textMap.put("6C", "测试成功C");
        textMap.put("6D", "测试成功D");
        return textMap;
    }

    private static SlideData getTableTest(SlideData slideData4) {
        /** 构建table 表格 **/
        TableData tableData = new TableData();

        TableRow tableRow1 = new TableRow();
        tableRow1.addCell("测试成功A1--");
        tableRow1.addCell("测试成功B1");
        tableRow1.addCell("测试成功C1");

        TableRow tableRow2 = new TableRow();
        tableRow2.addCell("测试成功C2");
        tableRow2.addCell("测试成功B2");
        tableRow2.addCell("测试成功A2");

        tableData.addRow(tableRow1);
        tableData.addRow(tableRow2);

        return slideData4.addTable(tableData);
    }

    private static List<ChartData> getChartData() {
        List<ChartCategory> categoryDataList = new ArrayList<>();
        ChartCategory categoryData = new ChartCategory("第一季度", 8.2);
        ChartCategory categoryData2 = new ChartCategory("第二季度", 3.2);
        ChartCategory categoryData3 = new ChartCategory("第三季度", 2.6);
        categoryDataList.add(categoryData);
        categoryDataList.add(categoryData2);
        categoryDataList.add(categoryData3);

        List<ChartSeries> seriesDataList = new ArrayList<>();
        ChartSeries seriesData = new ChartSeries();
        seriesData.setSeriesName("销售额");
        seriesData.setChartCategoryList(categoryDataList);
        seriesDataList.add(seriesData);

        ChartData chartData = new ChartData();
        chartData.setChartSeriesList(seriesDataList);

        List<ChartData> chartDataList = new ArrayList<>();
        chartDataList.add(chartData);
        return chartDataList;
    }


    private static List<ChartData> getChartData2() {
        List<ChartCategory> categoryDataList = new ArrayList<>();
        ChartCategory categoryData = new ChartCategory("A", 0.123);
        ChartCategory categoryData2 = new ChartCategory("B", 0.084);
        ChartCategory categoryData3 = new ChartCategory("C", 0.53);
        ChartCategory categoryData4 = new ChartCategory("D", 0.262);
        categoryDataList.add(categoryData);
        categoryDataList.add(categoryData2);
        categoryDataList.add(categoryData3);
        categoryDataList.add(categoryData4);


        List<ChartCategory> categoryDataList1 = new ArrayList<>();
        ChartCategory categoryData1 = new ChartCategory("A", 0.093);
        ChartCategory categoryData12 = new ChartCategory("B", 0.084);
        ChartCategory categoryData13 = new ChartCategory("C", 0.55);
        ChartCategory categoryData14 = new ChartCategory("D", 0.181);
        categoryDataList1.add(categoryData1);
        categoryDataList1.add(categoryData12);
        categoryDataList1.add(categoryData13);
        categoryDataList1.add(categoryData14);

        List<ChartCategory> categoryDataList2 = new ArrayList<>();
        ChartCategory categoryData21 = new ChartCategory("A", 0.051);
        ChartCategory categoryData22 = new ChartCategory("B", 0.071);
        ChartCategory categoryData23 = new ChartCategory("C", 0.558);
        ChartCategory categoryData24 = new ChartCategory("D", 0.32);
        categoryDataList2.add(categoryData21);
        categoryDataList2.add(categoryData22);
        categoryDataList2.add(categoryData23);
        categoryDataList2.add(categoryData24);


        List<ChartCategory> categoryDataList3 = new ArrayList<>();
        ChartCategory categoryData31 = new ChartCategory("A", 0.019);
        ChartCategory categoryData32 = new ChartCategory("B", 0.413);
        ChartCategory categoryData33 = new ChartCategory("C", 0.302);
        ChartCategory categoryData34 = new ChartCategory("D", 0.266);
        categoryDataList3.add(categoryData31);
        categoryDataList3.add(categoryData32);
        categoryDataList3.add(categoryData33);
        categoryDataList3.add(categoryData34);


        List<ChartSeries> seriesDataList = new ArrayList<>();
        ChartSeries seriesData = new ChartSeries();
        seriesData.setSeriesName("test1");
        seriesData.setChartCategoryList(categoryDataList);

        ChartSeries seriesData1 = new ChartSeries();
        seriesData1.setSeriesName("test2");
        seriesData1.setChartCategoryList(categoryDataList1);

        ChartSeries seriesData2 = new ChartSeries();
        seriesData2.setSeriesName("test3");
        seriesData2.setChartCategoryList(categoryDataList2);

        ChartSeries seriesData3 = new ChartSeries();
        seriesData3.setSeriesName("test4");
        seriesData3.setChartCategoryList(categoryDataList3);

        seriesDataList.add(seriesData);
        seriesDataList.add(seriesData1);
        seriesDataList.add(seriesData2);
        seriesDataList.add(seriesData3);


        ChartData chartData = new ChartData();
        chartData.setChartSeriesList(seriesDataList);

        List<ChartData> chartDataList = new ArrayList<>();
        chartDataList.add(chartData);
        return chartDataList;
    }
}
