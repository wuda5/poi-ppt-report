package com.wu.report.chapter;

public enum ChapterTemplateName {

    assterInfo("d"),
    capcity("cap");











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
