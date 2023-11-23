/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.controller.tableModel;

import com.clevervitor.hotelpet.model.entities.Pet;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vitor
 */
public class TMPet extends AbstractTableModel {

    private List lista;

    private final int COL_ID = 0;
    private final int COL_RACA = 1;
    private final int COL_IDADE = 2;
    private final int COL_SEXO = 3;
    private final int COL_PESO = 4;
    private final int COL_EDITAR = 5;

    public TMPet(List lstPets) {
        this.lista = lstPets;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pet aux = new Pet();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Pet) lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_ID:
                    return aux.getId();
                case COL_IDADE:
                    return aux.getIdade();
                case COL_PESO:
                    return aux.getPeso();
                case COL_RACA:
                    return aux.getRaca();
                case COL_SEXO:
                    return aux.getSexo();
                case COL_EDITAR:
                    return new ImageIcon(getClass().getResource("/imagens/edit.png"));
                default:
                    break;
            }
        }
        return aux;

    }

    @Override
    public String getColumnName(int column) {

        switch (column) {

            case COL_ID:
                return "Id";
            case COL_IDADE:
                return "Idade";
            case COL_PESO:
                return "Peso";
            case COL_RACA:
                return "Raca";
            case COL_SEXO:
                return "Sexo";
            case COL_EDITAR:
                return "Editar";
            default:
                break;
        }

        return "";
    }

}
