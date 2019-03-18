
package com.library.pojo;

import java.util.HashSet;
import java.util.Set;

public class Reader {
    private String readId;
    private String readName;
    private String readAddress;
    private String readMobile;
    private int readBalance;
    private String readPassword;
    private String portrait;
    public Reader() {
    }

    public Reader(String readId, String readName, String readAddress, String readMobile, int readBalance, String readPassword, String portrait) {
        this.readId = readId;
        this.readName = readName;
        this.readAddress = readAddress;
        this.readMobile = readMobile;
        this.readBalance = readBalance;
        this.readPassword = readPassword;
        this.portrait = portrait;
    }

   
  
    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getReadId() {
        return readId;
    }

    public void setReadId(String readId) {
        this.readId = readId;
    }

    


    public String getReadName() {
        return readName;
    }

    public void setReadName(String readName) {
        this.readName = readName;
    }

    public String getReadAddress() {
        return readAddress;
    }

    public void setReadAddress(String readAddress) {
        this.readAddress = readAddress;
    }

    public String getReadMobile() {
        return readMobile;
    }

    public void setReadMobile(String readMobile) {
        this.readMobile = readMobile;
    }

    public int getReadBalance() {
        return readBalance;
    }

    public void setReadBalance(int readBalance) {
        this.readBalance = readBalance;
    }

    public String getReadPassword() {
        return readPassword;
    }

    public void setReadPassword(String readPassword) {
        this.readPassword = readPassword;
    }


}
