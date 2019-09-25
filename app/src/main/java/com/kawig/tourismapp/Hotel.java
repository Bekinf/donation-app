package com.kawig.tourismapp;

public class Hotel {
    private String hdetails;
    private String hlocation;
    private String hname;
    private String hno;

    public Hotel() {
    }

    public Hotel(String hdetails, String hlocation, String hname, String hno) {
        this.hdetails = hdetails;
        this.hlocation = hlocation;
        this.hname = hname;
        this.hno = hno;
    }

    public String getHdetails() {
        return hdetails;
    }

    public void setHdetails(String hdetails) {
        this.hdetails = hdetails;
    }

    public String getHlocation() {
        return hlocation;
    }

    public void setHlocation(String hlocation) {
        this.hlocation = hlocation;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHno() {
        return hno;
    }

    public void setHno(String hno) {
        this.hno = hno;
    }
}
