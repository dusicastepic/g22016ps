/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import domen.Lokacija;
import domen.Radnik;
import domen.Raspored;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DBBroker {

    Connection konekcja;

    public void ucitajDrajver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void otvoriKonekciju() {
        String url = "jdbc:mysql://localhost:3306/prosoftg2";
        String user = "root";
        String pass = "";
        try {
            konekcja = DriverManager.getConnection(url, user, pass);
            konekcja.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zatvoriKonekciju() {
        try {
            konekcja.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void commit() {
        try {
            konekcja.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollback() {
        try {
            konekcja.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        ;
    }

    public ArrayList<Lokacija> vratiListuLokacija() {
        ArrayList<Lokacija> listaLokacija = new ArrayList<>();
        String upit = "select * from Lokacija order by Naziv asc";
        Statement s;
        try {
            s = konekcja.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {
                int LokacijaID = rs.getInt("LokacijaID");
                String Naziv = rs.getString("Naziv");
                Date PocetakGradnje = rs.getDate("PocetakGradnje");
                Date ZavrsetakGradnje = rs.getDate("ZavrsetakGradnje");
                Lokacija l = new Lokacija(LokacijaID, Naziv, PocetakGradnje, ZavrsetakGradnje);
                listaLokacija.add(l);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaLokacija;
    }

    public ArrayList<Radnik> vratiListuRadnika() {
        String upit = "select * from Radnik order by Prezime asc";
        ArrayList<Radnik> listaRadnika = new ArrayList<>();
        try {
            Statement s = konekcja.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {
                int RadnikID = rs.getInt("RadnikID");
                String Ime = rs.getString("Ime");
                String Prezime = rs.getString("Prezime");
                String Specijalizacija = rs.getString("Specijalizacija");
                Radnik r = new Radnik(RadnikID, Ime, Prezime, Specijalizacija);
                listaRadnika.add(r);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRadnika;
    }

    public int vratiIndeks() {
        int maks = 0;
        String upit = "select max(RasporedID) as maks from Raspored";
        Statement s;
        try {
            s = konekcja.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {
                maks = rs.getInt("maks");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return maks++;
    }

    public void sacuvajRaspored(Raspored r, int indeks) throws SQLException {
 
        String upit="insert into Raspored values(?,?,?,?,?)";
        PreparedStatement ps=konekcja.prepareStatement(upit);
        ps.setInt(1, indeks);
        ps.setInt(2, r.getBrojSati());
        ps.setDate(3, new java.sql.Date(r.getDatum().getTime()));
        ps.setInt(4, r.getLokacija().getLokacijaID());
        ps.setInt(5, r.getRadnik().getRadnikID());
        ps.executeUpdate();
    }
}
