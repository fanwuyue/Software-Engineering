package top.womoe.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Worker {
    private Integer id;

    private String wksNumber;

    private String wksName;

    private Date wksBirthdate;

    private Integer wksEdu;

    private String wksHometown;

    private String wksAddress;

    private String wksTelephone;

    private Integer wksSeniority;

    private Integer wksBasesalary;

    private String wksSex;

    public String toString(){
        String xl = "";
        switch (wksEdu){
            case 0: xl = "高中";
                break;
            case 1: xl = "学士";
                break;
            case 2: xl = "硕士";
                break;
            case 3: xl = "博士";
                break;
            case 4: xl = "其它";
                break;

        }
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        return String.format("姓名: %s， 编号: %s， 性别: %s， 生日: %s， 学历: %s， 籍贯: %s， 地址: %s， 电话: %s， 工龄: %s， 基本薪水: %s"
                , wksName, wksNumber, wksSex, df.format(wksBirthdate), xl, wksHometown, wksAddress, wksTelephone, wksSeniority, wksBasesalary);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWksNumber() {
        return wksNumber;
    }

    public void setWksNumber(String wksNumber) {
        this.wksNumber = wksNumber;
    }

    public String getWksName() {
        return wksName;
    }

    public void setWksName(String wksName) {
        this.wksName = wksName;
    }

    public Date getWksBirthdate() {
        return wksBirthdate;
    }

    public void setWksBirthdate(Date wksBirthdate) {
        this.wksBirthdate = wksBirthdate;
    }

    public Integer getWksEdu() {
        return wksEdu;
    }

    public void setWksEdu(Integer wksEdu) {
        this.wksEdu = wksEdu;
    }

    public String getWksHometown() {
        return wksHometown;
    }

    public void setWksHometown(String wksHometown) {
        this.wksHometown = wksHometown;
    }

    public String getWksAddress() {
        return wksAddress;
    }

    public void setWksAddress(String wksAddress) {
        this.wksAddress = wksAddress;
    }

    public String getWksTelephone() {
        return wksTelephone;
    }

    public void setWksTelephone(String wksTelephone) {
        this.wksTelephone = wksTelephone;
    }

    public Integer getWksSeniority() {
        return wksSeniority;
    }

    public void setWksSeniority(Integer wksSeniority) {
        this.wksSeniority = wksSeniority;
    }

    public Integer getWksBasesalary() {
        return wksBasesalary;
    }

    public void setWksBasesalary(Integer wksBasesalary) {
        this.wksBasesalary = wksBasesalary;
    }

    public String getWksSex() {
        return wksSex;
    }

    public void setWksSex(String wksSex) {
        this.wksSex = wksSex;
    }
}