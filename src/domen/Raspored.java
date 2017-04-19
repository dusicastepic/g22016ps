/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;

/**
 *
 * @author User
 */
public class Raspored {
    private int RasporedID;
    private int BrojSati;
    private Date datum;
    private Lokacija lokacija;
    private Radnik radnik;

    public Raspored() {
    }

    public Raspored(int RasporedID, int BrojSati, Date datum, Lokacija lokacija, Radnik radnik) {
        this.RasporedID = RasporedID;
        this.BrojSati = BrojSati;
        this.datum = datum;
        this.lokacija = lokacija;
        this.radnik = radnik;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public int getRasporedID() {
        return RasporedID;
    }

    public void setRasporedID(int RasporedID) {
        this.RasporedID = RasporedID;
    }

    public int getBrojSati() {
        return BrojSati;
    }

    public void setBrojSati(int BrojSati) {
        this.BrojSati = BrojSati;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }
    
    
}
