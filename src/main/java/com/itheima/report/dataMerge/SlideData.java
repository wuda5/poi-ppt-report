package com.itheima.report.dataMerge;

import com.itheima.report.baseModel.ChartData;
import com.itheima.report.baseModel.TableData;
import com.itheima.report.chapter.ChapterTemplateName;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@Data
public class SlideData {

    private ChapterTemplateName chapterTemplateName;
    //页码
    private Integer slidePage;

    //文本数据 格式${}
    private Map<String, String> textMap;

    //表格数据 支持多个表格 按照创建顺序渲染
    private List<TableData> tableDataList = new ArrayList<>();
    //图表数据 支持多个图表 按照创建顺序渲染
    private List<ChartData> chartDataList;

    /**
     *  添加一张 或 多张 表格数据
     * */
    public SlideData addTable(TableData ... table){
//    public SlideData addTable(List<TableData> table){
        List<TableData> tables = Arrays.asList(table);
        tableDataList.addAll(tables);
        return  this;
    }








    public SlideData(ChapterTemplateName chapterTemplateName) {
        this.chapterTemplateName = chapterTemplateName;
    }
    public SlideData() {

    }

    public SlideData(Integer slidePage, List<TableData> tableDataList, List<ChartData> chartDataList, Map<String, String> textMap) {
        this.slidePage = slidePage;
        this.tableDataList = tableDataList;
        this.chartDataList = chartDataList;
        this.textMap = textMap;
    }

//    public Integer getSlidePage() {
//        return slidePage;
//    }
//
//    public void setSlidePage(Integer slidePage) {
//        this.slidePage = slidePage;
//    }
//
//    public List<TableData> getTableDataList() {
//        return tableDataList;
//    }
//
//    public void setTableDataList(List<TableData> tableDataList) {
//        this.tableDataList = tableDataList;
//    }
//
//    public List<ChartData> getChartDataList() {
//        return chartDataList;
//    }
//
//    public void setChartDataList(List<ChartData> chartDataList) {
//        this.chartDataList = chartDataList;
//    }
//
//    public Map<String, String> getTextMap() {
//        return textMap;
//    }
//
//    public void setTextMap(Map<String, String> textMap) {
//        this.textMap = textMap;
//    }
}
