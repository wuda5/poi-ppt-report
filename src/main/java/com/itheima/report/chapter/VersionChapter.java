package com.itheima.report.chapter;

import com.itheima.domain.User;
import com.itheima.report.baseModel.TableData;
import com.itheima.report.baseModel.TableRow;
import com.itheima.report.dataMerge.SlideData;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class VersionChapter implements ISlidedataConverter {

    private final ChapterTemplateName chapter = ChapterTemplateName.version;
    private  List<User> users;

    @Override
    public List<SlideData> generate() {

        List<SlideData> result = new ArrayList<>();
        result.add(getTableTest());
        return result;
    }
    private  SlideData getTableTest() {
        SlideData slideData = new SlideData(chapter);
        /** 构建table 表格 **/
        TableData tableData = new TableData();
        /** 注意：是3列 ，一个人的信息就对应一行 **/
        for (User user : users) {
            TableRow row = new TableRow();

            row.addCell(user.getName());
            row.addCell(user.getId()+"");
            row.addCell(user.getPassword());

            tableData.addRow(row);
        }

        return slideData.addTable(tableData);
    }

}
