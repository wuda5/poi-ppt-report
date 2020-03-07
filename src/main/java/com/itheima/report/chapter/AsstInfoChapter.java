package com.itheima.report.chapter;

import com.itheima.domain.User;
import com.itheima.report.dataMerge.SlideData;
import lombok.Data;

import java.util.List;
@Data
public class AsstInfoChapter implements ISlidedataConverter {

    private final ChapterTemplateName chapter = ChapterTemplateName.assterInfo;
    private  List<User> users;

    @Override
    public List<SlideData> generate() {
        return null;
    }
}
