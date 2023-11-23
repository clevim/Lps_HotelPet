/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.controller.tableModel;

import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vitor
 */
public class TMAgendamentos extends AbstractTableModel {

    private List lista;

    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_RACA = 2;
    private final int COL_DATA_CHECKIN = 3;
    private final int COL_DATA_CHECKOUT = 4;
    private final int COL_SERVICOS_ADICIONAIS = 5;

    public TMAgendamentos(List lstAgendamentos) {
        this.lista = lstAgendamentos;
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
        Agendamento aux = new Agendamento();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Agendamento) lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_ID:
                    return aux.getId();
                case COL_NOME:
                    return aux.getPetAgendado().getNome();
                case COL_RACA:
                    return aux.getPetAgendado().getRaca();
                case COL_DATA_CHECKIN:
                    return aux.getDataCheckIn();
                case COL_DATA_CHECKOUT:
                    return aux.getDataCheckOut();
                case COL_SERVICOS_ADICIONAIS:
                    return aux.getServicosAdicionais();
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
                    return "Id do agendamento";
                case COL_NOME:
                    return "Nome do pet";
                case COL_RACA:
                    return "Raca";
                case COL_DATA_CHECKIN:
                    return "Data check-in";
                case COL_DATA_CHECKOUT:
                    return "Data check-out";
                case COL_SERVICOS_ADICIONAIS:
                    return "Serviços";
                default:
                    break;
            }
        
        return "";
    }
    
}
