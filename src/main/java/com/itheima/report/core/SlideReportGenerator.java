package com.itheima.report.core;

import com.itheima.report.chapter.ChapterTemplateName;
import com.itheima.report.dataMerge.ReportData;
import com.itheima.report.dataMerge.SlideData;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Component
public class SlideReportGenerator {

    @Autowired
    private  SlidePageConstructor slidePageConstructor;

    private  static String defaultOutputPath =System.getProperty("user.dir") + File.separator + "src\\main\\resources\\myppt\\myppt-demo";
    private  static String  templatePath = System.getProperty("user.dir") + File.separator + "src\\main\\resources\\demo.pptx";

    /** 要remove */
    private  static   Map<ChapterTemplateName, XSLFSlide> pptChaterTemlates = new HashMap<>();
//    private  static   Map<Integer, XSLFSlide> pptChaterNumber = new HashMap<>();
//    private  static  ThreadLocal<Map<ChapterTemplateName, XSLFSlide>> pptChaterTemlates;

    static {
        XMLSlideShow  templateXmlSlideShow = readPowerPoint(templatePath);
        List<XSLFSlide> slideList = templateXmlSlideShow.getSlides();
        //遍历每一页PPT构造
        ChapterTemplateName[] cps = ChapterTemplateName.values();

        if (cps.length != slideList.size()){
            throw new RuntimeException("ChapterTemplateName number is not match pptTemplate");
        }
        for (int i = 0; i < slideList.size(); i++) {
            pptChaterTemlates.put(cps[i], slideList.get(i));
        }
    }

    /**
     *！ most !!
     * 就是用它来完成 生成ppt, 客户端就是调用它！！！
     * **/
    public void generateReport(ReportData pptData, String outputPath){
        XMLSlideShow  templateXmlSlideShow = readPowerPoint(templatePath);
        XMLSlideShow newPpt = generatePptByTemplate(pptData, templateXmlSlideShow);
        savePowerPoint(newPpt ,outputPath);
    }

    /**
     * 通过 转换数据对象 到 【模板池】 查询 对应的 ppt 原始 模板页 -- 重要！！--> 确保生产新的ppt 的顺序一定不会错乱！
     *
     * **/
    private XSLFSlide getTemplate(SlideData slideData) {
        ChapterTemplateName chapterTemplateName = slideData.getChapterTemplateName();
        XSLFSlide templateSlide = pptChaterTemlates.get(chapterTemplateName);
        if (templateSlide == null)
        {
            throw new RuntimeException("ChapterTemplateName number is not match pptTemplate");
        }
        return  templateSlide;
    }

    /**
     * 保存ppt到指定路径
     *
     * @param ppt
     * @param outputFilePath
     */
    private static void savePowerPoint(XMLSlideShow ppt, String outputFilePath) {

        if (StringUtils.isEmpty(outputFilePath)){
            outputFilePath =  defaultOutputPath+ RandomUtils.nextFloat()+".pptx";
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outputFilePath);
            ppt.write(fileOutputStream);
        } catch (IOException e) {
            LOGGER.info("save powerpoint to  destPath fail ");
        } finally {
            try {
                fileOutputStream.close();
                ppt.close();
            } catch (IOException e) {
                LOGGER.info("stream close fail  ");
            }
        }

    }

    /**
     * 读取模板库PPT
     *
     * @param inputFilePath
     * @return
     */
    private static XMLSlideShow readPowerPoint(String inputFilePath) {
        FileInputStream fileInputStream = null;
        XMLSlideShow ppt = null;
        try {
            fileInputStream = new FileInputStream(inputFilePath);
            ppt = new XMLSlideShow(fileInputStream);
        } catch (IOException e) {
            LOGGER.info(" readPowerPoint fail,reason: {}");
        }
        return ppt;
    }

    /***1. pptTemplate 名字改了 */
    private XMLSlideShow generatePptByTemplate( ReportData pptData, XMLSlideShow pptTemplate) {
        /**一. 先通过模板 构造出要返回的 pptResult 对象 --一下就多了很多页！！！*/
        XMLSlideShow pptResult = new XMLSlideShow(pptTemplate.getPackage());

        /**二. 通过数据源 生产ppt 能识别的模型 list<SlideData>  **/
        List<SlideData> slideDataList = pptData.generateSlideData();

        /**三. 循环 模型 list<SlideData>  ，对每个 【slideData】 生产ppt的数据*/
        for (SlideData slidedata: slideDataList ) {
            /**1. 从模板池中 找到原始模板章节 **/
            XSLFSlide templateSlide = getTemplate(slidedata);
            /**2. pptResult 初始化新页 newSlide -> 需要复--制对--应模板池的全部布局和内容 **/
            XSLFSlide newSlide = pptResult.createSlide(templateSlide.getSlideLayout());
            newSlide.importContent(templateSlide);// 复制模板内容 --

            /**3.通过slideData 单页数据源执行新页 newSlide 的数据**/
            slidePageConstructor.fillData(newSlide,slidedata);
        }
        /** 四、删除最开始多余复制的 模板页**/
        for (int i = 0; i <pptChaterTemlates.size() ; i++) {
            pptResult.removeSlide(0);//应该是每次都删除新ppt的第一页的
//            pptResult.removeSlide(i);//报错
        }

        return pptResult;
    }

}
