package com.cn.teamhelper.model;

import java.util.Date;

/**
 * Created  by  binbinbinfffff
 * 2018/6/11  下午8:31
 */

/**
 * 常见性多发问题(个人层面)
 */
public class personalQuestion {
    /**
     * 序号
     */
    private int id;

    /**
     * 日期
     */
    private Date date;

    /**
     * 责任单位
     */
    private String responsibleUnit;

    /**
     * 责任人
     */
    private String responsiblePerson;

    /**
     * 存在问题
     */
    private String respobsibleContent;

    /**
     * 扣分依据（队内相应条款）
     */
    private String accordingToLaw;

    /**
     * 扣分
     */
    private double minus;

    /**
     * 备注
     */
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResponsibleUnit() {
        return responsibleUnit;
    }

    public void setResponsibleUnit(String responsibleUnit) {
        this.responsibleUnit = responsibleUnit;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getRespobsibleContent() {
        return respobsibleContent;
    }

    public void setRespobsibleContent(String respobsibleContent) {
        this.respobsibleContent = respobsibleContent;
    }

    public String getAccordingToLaw() {
        return accordingToLaw;
    }

    public void setAccordingToLaw(String accordingToLaw) {
        this.accordingToLaw = accordingToLaw;
    }

    public double getMinus() {
        return minus;
    }

    public void setMinus(double minus) {
        this.minus = minus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
