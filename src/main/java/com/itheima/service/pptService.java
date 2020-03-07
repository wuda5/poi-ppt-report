package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.report.chapter.AsstInfoChapter;
import com.itheima.report.core.SlideReportGenerator;
import com.itheima.report.dataMerge.ReportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class pptService {

    /**
     *
     */
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SlideReportGenerator slideReportGenerator;

    public void generatePptReport(){
        ReportData reportData = buildRepotDat();
        slideReportGenerator.generateReport(reportData,"");


    }
     //
    public ReportData buildRepotDat(){

        ReportData data = new ReportData();

        AsstInfoChapter asstInfo = data.getAsstInfo();
        asstInfo.setUsers(userMapper.queryUserList());

        data.getVersion().setUsers(userMapper.queryUserList());


        return data;
    }

}
