package com.library.pojo;

public class Manager {

    private String managerID;
    private String managerName;
    private String managerMobile;
    private String managerPassword;
    private String managerPost;
    

    public Manager() {
    }

    public Manager(String managerID, String managerName, String managerMobile, String managerPassword, String managerPost) {
        this.managerID = managerID;
        this.managerName = managerName;
        this.managerMobile = managerMobile;
        this.managerPassword = managerPassword;
        this.managerPost = managerPost;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerMobile() {
        return managerMobile;
    }

    public void setManagerMobile(String managerMobile) {
        this.managerMobile = managerMobile;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerPost() {
        return managerPost;
    }

    public void setManagerPost(String managerPost) {
        this.managerPost = managerPost;
    }

}
