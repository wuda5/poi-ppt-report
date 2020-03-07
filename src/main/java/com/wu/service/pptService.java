package com.wu.service;

import com.wu.domain.User;
import com.wu.mapper.UserMapper;
import com.wu.report.chapter.AsstInfoChapter;
import com.wu.report.core.SlideReportGenerator;
import com.wu.report.dataMerge.ReportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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


        return data;
    }

}
