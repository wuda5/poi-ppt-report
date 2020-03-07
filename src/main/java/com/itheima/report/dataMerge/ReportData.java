package com.itheima.report.dataMerge;

import com.itheima.report.chapter.AsstInfoChapter;
import com.itheima.report.chapter.CapcityChapter;
import com.itheima.report.chapter.VersionChapter;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有报告数据的汇总模型--涵盖所有章节 --它在service 先是查询dao 层 每个章节对应封装好熟悉，逐个赋值
 * **/
@Data
public class ReportData {

    private  List<SlideData> result = new ArrayList<>();

    private AsstInfoChapter asstInfo = new AsstInfoChapter();
    private VersionChapter version = new VersionChapter();
    private CapcityChapter cap = new CapcityChapter();



    /** 由上面 的每一个章节的xxx**/
    public List<SlideData> generateSlideData() {


        buildResult( asstInfo.generate());
        buildResult( version.generate());
        buildResult( cap.generate());



        return result;
    }

    private List<SlideData> buildResult( List<SlideData> slideDataList) {

        if (!CollectionUtils.isEmpty(slideDataList)){
           result.addAll(slideDataList);
        }
        return result;
    }
}
