package com.wu.report.dataMerge;

import com.wu.report.chapter.AsstInfoChapter;
import com.wu.report.chapter.CapcityChapter;
import com.wu.report.chapter.VersionChapter;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有报告数据的汇总模型--涵盖所有章节 --它在service 先是查询dao 层 每个章节对应封装好熟悉，逐个赋值
 * **/
@Data
public class ReportData {

    private AsstInfoChapter asstInfo = new AsstInfoChapter();
    private VersionChapter version = new VersionChapter();
    private CapcityChapter cap = new CapcityChapter();


    /** 由上面 的每一个章节的xxx**/
    public List<SlideData> generateSlideData() {

        List<SlideData> result = new ArrayList<>();

        result.addAll( asstInfo.generate());
        result.addAll( version.generate());
        result.addAll( cap.generate());

        return result;
    }
}
