/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.controller.tableModel;

import com.clevervitor.hotelpet.model.entities.Proprietario;
import com.clevervitor.hotelpet.model.entities.Pet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vitor
 */
public class TMProprietario extends AbstractTableModel {

    private List lista;

    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_CPF = 2;
    private final int COL_EMAIL = 3;
    private final int COL_ENDERECO = 4;

    public TMProprietario(List lstProprietarios) {
        this.lista = lstProprietarios;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proprietario aux = new Proprietario();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Proprietario) lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_ID:
                    return aux.getId();
                case COL_NOME:
                    return aux.getNome();
                case COL_CPF:
                    return aux.getCpf();
                case COL_EMAIL:
                    return aux.getEmail();
                case COL_ENDERECO:
                    return aux.getEndereco();
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
                    return "Id do Proprietario";
                case COL_NOME:
                    return "Nome do pet";
                case COL_CPF:
                    return "CPF";
                case COL_EMAIL:
                    return "Email";
                case COL_ENDERECO:
                    return "Endereço";
                default:
                    break;
            }
        
        return "";
    }
    
}
