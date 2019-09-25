package com.kawig.tourismapp;

public class Guide {
    private String gname;
    private String gaddress;
    private String glanguage;
    private String gcity;
    private String gno;

    public Guide() {
    }

    public Guide(String gname, String gaddress, String glanguage, String gcity, String gno) {
        this.gname = gname;
        this.gaddress = gaddress;
        this.glanguage = glanguage;
        this.gcity = gcity;
        this.gno = gno;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGaddress() {
        return gaddress;
    }

    public void setGaddress(String gaddress) {
        this.gaddress = gaddress;
    }

    public String getGlanguage() {
        return glanguage;
    }

    public void setGlanguage(String glanguage) {
        this.glanguage = glanguage;
    }

    public String getGcity() {
        return gcity;
    }

    public void setGcity(String gcity) {
        this.gcity = gcity;
    }

    public String getGno() {
        return gno;
    }

    public void setGno(String gno) {
        this.gno = gno;
    }
}
