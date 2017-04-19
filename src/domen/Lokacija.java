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
public class Lokacija {

    private int LokacijaID;
    private String Naziv;
    private Date PocetakGradnje;
    private Date ZavrsetakGradnje;

    public Lokacija() {
    }

    public Lokacija(int LokacijaID, String Naziv, Date PocetakGradnje, Date ZavrsetakGradnje) {
        this.LokacijaID = LokacijaID;
        this.Naziv = Naziv;
        this.PocetakGradnje = PocetakGradnje;
        this.ZavrsetakGradnje = ZavrsetakGradnje;
    }

    public int getLokacijaID() {
        return LokacijaID;
    }

    public void setLokacijaID(int LokacijaID) {
        this.LokacijaID = LokacijaID;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String Naziv) {
        this.Naziv = Naziv;
    }

    public Date getPocetakGradnje() {
        return PocetakGradnje;
    }

    public void setPocetakGradnje(Date PocetakGradnje) {
        this.PocetakGradnje = PocetakGradnje;
    }

    public Date getZavrsetakGradnje() {
        return ZavrsetakGradnje;
    }

    public void setZavrsetakGradnje(Date ZavrsetakGradnje) {
        this.ZavrsetakGradnje = ZavrsetakGradnje;
    }

    @Override
    public String toString() {
        return Naziv;
    }

}
