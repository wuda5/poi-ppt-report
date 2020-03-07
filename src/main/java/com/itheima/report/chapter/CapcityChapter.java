package com.itheima.report.chapter;

import com.itheima.report.dataMerge.SlideData;
import lombok.Data;

import java.util.List;
@Data
public class CapcityChapter implements ISlidedataConverter {
    private final ChapterTemplateName chapter = ChapterTemplateName.capcity;

    @Override
    public List<SlideData> generate() {
        return null;
    }
}
