package com.kawig.tourismapp;

public class Car {
    private String ctype;
    private String cnumber;
    private String cno;
    private String cfaci;


    public Car() {
    }

    public Car(String ctype, String cnumber, String cno, String cfaci) {
        this.ctype = ctype;
        this.cnumber = cnumber;
        this.cno = cno;
        this.cfaci = cfaci;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCfaci() {
        return cfaci;
    }

    public void setCfaci(String cfaci) {
        this.cfaci = cfaci;
    }
}
