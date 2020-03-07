package com.itheima.report.baseModel;

import com.itheima.report.chapter.ChapterTemplateName;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Data
public class TableData {

    private ChapterTemplateName templateName;

    //表格一行数据
    private List<TableRow> tableRowList = new ArrayList<>();



    public   TableData addRow (TableRow ...row){
        List<TableRow> tables = Arrays.asList(row);
        tableRowList.addAll(tables);
        return   this;
    }






    public TableData(ChapterTemplateName templateName) {
        this.templateName = templateName;
    }

    public TableData() {

    }

}
