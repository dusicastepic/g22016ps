/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import dbb.DBBroker;
import domen.Lokacija;
import domen.Radnik;
import domen.Raspored;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Kontroler {

    private static Kontroler instance;
    DBBroker dbb;

    private Kontroler() {
        dbb = new DBBroker();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public ArrayList<Lokacija> vratiListuLokacija() {
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        ArrayList<Lokacija> listaLokacija = dbb.vratiListuLokacija();
        dbb.zatvoriKonekciju();
        return listaLokacija;
    }

    public ArrayList<Radnik> vratiListuRadnika() {
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        ArrayList<Radnik> listaRadnika = dbb.vratiListuRadnika();
        dbb.zatvoriKonekciju();
        return listaRadnika;
    }

    public boolean sacuvaj(ArrayList<Raspored> listaRasporeda) {
        boolean uspesno = false;
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        int indeks = dbb.vratiIndeks();
        try {
            for (Raspored r : listaRasporeda) {
                dbb.sacuvajRaspored(r, indeks);
                indeks++;
            }
            uspesno = true;
            dbb.commit();
        } catch (Exception e) {
            dbb.rollback();
            uspesno = false;
        }
        dbb.zatvoriKonekciju();
        return uspesno;
    }

}
