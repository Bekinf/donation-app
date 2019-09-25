package com.kawig.tourismapp;

public class Place {
    private String pdet;
    private String ploc;
    private String pname;
    private String pno;

    public Place() {
    }

    public Place(String pdet, String ploc, String pname, String pno) {
        this.pdet = pdet;
        this.ploc = ploc;
        this.pname = pname;
        this.pno = pno;
    }

    public String getPdet() {
        return pdet;
    }

    public void setPdet(String pdet) {
        this.pdet = pdet;
    }

    public String getPloc() {
        return ploc;
    }

    public void setPloc(String ploc) {
        this.ploc = ploc;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }
}


