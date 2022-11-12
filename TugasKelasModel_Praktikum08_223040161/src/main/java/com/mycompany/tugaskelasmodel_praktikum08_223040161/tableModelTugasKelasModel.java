/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugaskelasmodel_praktikum08_223040161;

/**
 *
 * @author HANA NURKARIMAH
 */

import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;

class tableModelTugasKelasModel extends AbstractTableModel {
    private String[] columnNames = {"Nama", "Nomor HP", "Jenis Kelamin", "Alamat"};
    private ArrayList<Biodata> data = new ArrayList<Biodata>();
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Biodata rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getNama();
                break;
            case 1:
                value = rowItem.getNomorHP();
                break;
            case 2:
                value = rowItem.getJenisKelamin();
                break;
            case 3:
                value = rowItem.getAlamat();
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Biodata value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void remove(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public void setValueAt(String value, int row, int col) {
        Biodata rowItem = data.get(row);
        String nama = "";
        String nomorHP = "";
        String jenisKelamin = "";
        String alamat = "";
        
        if (col == 0) {
            nama = value;
            rowItem.setNama(nama);
        }
        if (col == 1) {
            nomorHP = value;
            rowItem.setNomorHP(nomorHP);
        }
        if (col == 2) {
            jenisKelamin = value;
            rowItem.setJenisKelamin(jenisKelamin);
        }
        if (col == 3) {
            alamat = value;
            rowItem.setAlamat(alamat);
        }

        fireTableRowsUpdated(row, col);
    }
}
