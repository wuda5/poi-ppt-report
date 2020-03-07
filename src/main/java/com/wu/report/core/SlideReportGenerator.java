package com.wu.report.core;

import com.wu.report.chapter.ChapterTemplateName;
import com.wu.report.dataMerge.ReportData;
import com.wu.report.dataMerge.SlideData;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.Map;

@Component
public class SlideReportGenerator {

    /**
     *
     */
    @Autowired
    private  SlidePageConstructor slidePageConstructor;

    private  static  ThreadLocal<Map<ChapterTemplateName, XSLFSlide>> pptChaterTemlates;

    /**
     * most !!
     * 就是用它来完成 生成ppt, 客户端就是调用它！！！
     * **/
    public void generateReport(ReportData pptData, String templatePath){

//       XMLSlideShow newppt = generatePpt( templatePath);
//       savePpt(newppt ,new File(""));

    }

    private XSLFSlide getTemplate(SlideData slideData) {

        return  null;
    }

    private void savePpt(XMLSlideShow newppt, File file) {
    }

    /***1. pptTemplate 名字改了 */
    private XMLSlideShow generatePptByTemplate( ReportData pptData, XMLSlideShow pptTemplate) {
        /**一. 先通过模板 构造出要返回的 pptResult 对象 */
        XMLSlideShow pptResult = new XMLSlideShow(pptTemplate.getPackage());

        /**二. 通过数据源 生产ppt 能识别的模型 list<SlideData>  **/
        List<SlideData> slideDataList = pptData.generateSlideData();

        /**三. 循环 模型 list<SlideData>  ，对每个 【slideData】 生产ppt的数据*/
        for (SlideData slidedata: slideDataList ) {
            /**1. 找到原始模板章节 **/
            XSLFSlide templateSlide = getTemplate(slidedata);
            /**2. 初始化新页 newSlide -> **/
            XSLFSlide newSlide = pptResult.createSlide(templateSlide.getSlideLayout());
            newSlide.importContent(templateSlide);// 复制模板内容

            /**3.通过slideData 单页数据源执行新页 newSlide 的数据**/
            slidePageConstructor.fillData(newSlide,slidedata);

        }


        return null;
    }

}
