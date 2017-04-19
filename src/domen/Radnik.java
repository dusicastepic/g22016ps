/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author User
 */
public class Radnik {

    private int RadnikID;
    private String Ime;
    private String Prezime;
    private String Specijalizacija;

    public Radnik() {
    }

    public Radnik(int RadnikID, String Ime, String Prezime, String Specijalizacija) {
        this.RadnikID = RadnikID;
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.Specijalizacija = Specijalizacija;
    }

    public String getSpecijalizacija() {
        return Specijalizacija;
    }

    public void setSpecijalizacija(String Specijalizacija) {
        this.Specijalizacija = Specijalizacija;
    }

    public int getRadnikID() {
        return RadnikID;
    }

    public void setRadnikID(int RadnikID) {
        this.RadnikID = RadnikID;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String Ime) {
        this.Ime = Ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String Prezime) {
        this.Prezime = Prezime;
    }

    @Override
    public String toString() {
        return Ime + " " + Prezime;

    }

}
