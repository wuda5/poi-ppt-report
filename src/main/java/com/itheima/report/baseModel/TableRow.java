package com.itheima.report.baseModel;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class TableRow {

    //每一行数据(由多个单元格组成)  --数字+字符串 --> Object?
    private List<String> cellList = new ArrayList<>();

    public TableRow() {
    }

    public   TableRow addCell(String... cell){

        List<String> tables = Arrays.asList(cell);
        cellList.addAll(tables);
     return   this;
    }



}
