package com.itheima.report.core;

import com.itheima.report.baseModel.TableData;
import com.itheima.report.baseModel.TableRow;
import com.itheima.report.dataMerge.SlideData;
import org.apache.poi.xslf.usermodel.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 单页 ppt 数据 生成器
 * **/
@Component
public class SlidePageConstructor {

    public void fillData(XSLFSlide slide,SlideData slideData){
        /**1. 文本 替换  **/
        generateSlideText(slide,slideData);
        /**2. 生成表格 **/
        generateSlideTables(slide,slideData);
    }

/**
 * 注意：slideData 在这里就是仅仅代表一页的数据--> 分页逻辑 必须在各个章节生产数据时完成
 * */
    private void generateSlideTables(XSLFSlide slide, SlideData slideData) {
        List<XSLFShape> shapeList = slide.getShapes();
        /** 其实应该考虑一页多张表！！ **/
        for (XSLFShape shape : shapeList) {
            List<TableData> tableList = slideData.getTableDataList();
            //当一页有多个表格的时候
            int tableNum = 0;
            //判断表格
            if (shape instanceof XSLFTable) {
                List<TableRow> tableRowList = tableList.get(tableNum).getTableRowList();
                generatorTable((XSLFTable) shape, tableRowList);

            }
            tableNum++;
        }

    }


    /**
     * 构造表格
     *
     * @param table
     * @param tableDataList
     */
    private static void generatorTable(XSLFTable table, List<TableRow> tableDataList) {

        List<XSLFTableRow> rows = table.getRows();
        int rowSize = rows.size() - 1;
        for (int i = 0; i < tableDataList.size(); i++) {

            //为了保证样式 的不变判断数据量比模板的row多的时候，在原来表格基础上新增row
            if (i < rowSize) {
                List<XSLFTableCell> cells = rows.get(i + 1).getCells();
                for (int j = 0; j < tableDataList.get(i).getCellList().size(); j++) {
                    String s = tableDataList.get(i).getCellList().get(j);
                    cells.get(j).setText(s);
                    System.out.println();
                }
            } else {
                /** 追加行 */
                XSLFTableRow row = table.addRow();
//                XSLFTableRow row = rows.get(i + 1);// 原始的
                for (int j = 0; j < tableDataList.get(i).getCellList().size(); j++) {
                    String s = tableDataList.get(i).getCellList().get(j);
                    row.addCell().setText(s);
                    System.out.println();
                }
            }
        }
        //清空我的配置文件（根据自己解析数据的业务清空配置文件）
        table.getCell(0, 0).setText("");
    }


    void generateSlideText(XSLFSlide slide, SlideData slideData){


    }

}
