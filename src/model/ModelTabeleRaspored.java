/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Raspored;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabeleRaspored extends AbstractTableModel {

    ArrayList<Raspored> listaRasporeda = new ArrayList<>();
    String[] kolone = {"Lokacija", "Ime i prezime", "Broj sati", "Datum"};

    @Override
    public int getRowCount() {
        return listaRasporeda.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Raspored r = listaRasporeda.get(rowIndex);
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:
                return r.getLokacija();
            case 1:
                return r.getRadnik();
            case 2:
                return r.getBrojSati();
            case 3:
                return sdf.format(r.getDatum());
            default:
                return "n/a";

        }

    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodaj(Raspored r) {
        listaRasporeda.add(r);
        fireTableDataChanged();
    }
    

    public void izbrisi(int index) {
        listaRasporeda.remove(index);
        fireTableDataChanged();
    }

    public ArrayList<Raspored> vratiListuRaporeda() {
        return listaRasporeda;
    }

}
