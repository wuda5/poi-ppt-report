package com.itheima.report.chapter;

public enum ChapterTemplateName {

    assterInfo("d"),
    version("cap"),
    capcity("cap");
//    device("cap"),
//    single("cap");











    private String templateName ;

    public String templateName() {
        return templateName;
    }

    public void templateName(String msg) {
        this.templateName = msg;
    }

    ChapterTemplateName(String msg) {
        this.templateName = templateName;
    }

}
