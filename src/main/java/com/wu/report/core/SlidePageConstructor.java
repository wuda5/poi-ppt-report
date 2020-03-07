package com.wu.report.core;

import com.wu.report.dataMerge.SlideData;
import org.apache.poi.hslf.record.Slide;
import org.apache.poi.xslf.usermodel.XSLFSlide;

/**
 * 单页 ppt 数据 生成器
 * **/
public class SlidePageConstructor {

    public void fillData(XSLFSlide slide,SlideData slideData){
        /**1. 文本 替换  **/
        generateSlideText(slide,slideData);
        /**2. 生成表格 **/
        generateSlideTables(slide,slideData);
    }

    private void generateSlideTables(XSLFSlide slide, SlideData slideData) {
    }

    void generateSlideText(XSLFSlide slide, SlideData slideData){


    }

}
