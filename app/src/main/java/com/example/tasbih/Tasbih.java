package com.example.tasbih;

public class Tasbih {
    private String kalm;
    private String kalmaCount;
    private String darood;
    private String daroodCount;
    private String astaghfar;
    private String astaghfarCount;
    private String date;

    public Tasbih(String kalm, String kalmaCount, String darood, String daroodCount, String astaghfar, String astaghfarCount, String date) {
        this.kalm = kalm;
        this.kalmaCount = kalmaCount;
        this.darood = darood;
        this.daroodCount = daroodCount;
        this.astaghfar = astaghfar;
        this.astaghfarCount = astaghfarCount;
        this.date=date;
    }
    public String getDate() {
        return date;
    }

    public String getKalm() {
        return kalm;
    }

    public void setKalm(String kalm) {
        this.kalm = kalm;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getKalmaCount() {
        return kalmaCount;
    }

    public void setKalmaCount(String kalmaCount) {
        this.kalmaCount = kalmaCount;
    }

    public String getDarood() {
        return darood;
    }

    public void setDarood(String darood) {
        this.darood = darood;
    }

    public String getDaroodCount() {
        return daroodCount;
    }

    public void setDaroodCount(String daroodCount) {
        this.daroodCount = daroodCount;
    }

    public String getAstaghfar() {
        return astaghfar;
    }

    public void setAstaghfar(String astaghfar) {
        this.astaghfar = astaghfar;
    }

    public String getAstaghfarCount() {
        return astaghfarCount;
    }

    public void setAstaghfarCount(String astaghfarCount) {
        this.astaghfarCount = astaghfarCount;
    }
    @Override
    public String toString() {
        return "Tasbih [kalma=" + kalm + ", kalmaCount=" + kalmaCount + ", darood=" + darood +" daroodCount="+daroodCount+"astaghfar= "+astaghfar+" astaghfarCount= "+astaghfarCount+ " date="+date+" ]";
    }
}
