/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.controller.tableModel;

import com.clevervitor.hotelpet.model.entities.Agendamento;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.model.entities.Servicos;
import com.clevervitor.hotelpet.model.enums.Services;
import com.clevervitor.hotelpet.utils.utils;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vitor
 */
public class TMAgendamentos extends AbstractTableModel {

    private List lista;

    private final int COL_NOME = 0;
    private final int COL_DATA_CHECKIN = 1;
    private final int COL_DATA_CHECKOUT = 2;
    private final int COL_SERVICOS_ADICIONAIS = 3;
    private final int COL_STATUS = 4;

    public TMAgendamentos(List lstAgendamentos) {
        this.lista = lstAgendamentos;
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
        Agendamento aux = new Agendamento();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Agendamento) lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_NOME:
                    return aux.getPetAgendado().toString();
                case COL_DATA_CHECKIN:
                    return aux.getDataCheckIn();
                case COL_DATA_CHECKOUT:
                    return aux.getDataCheckOut();
                case COL_SERVICOS_ADICIONAIS:
                    return ToStringServiceName(aux.getServicosAdicionais());
                case COL_STATUS:
                    return utils.StatusToString(aux.getStatus());
                default:
                    break;
            }
        }
        return aux;

    }

    @Override
    public String getColumnName(int column) {

        switch (column) {

            case COL_NOME:
                return "Pet";
            case COL_DATA_CHECKIN:
                return "Data check-in";
            case COL_DATA_CHECKOUT:
                return "Data check-out";
            case COL_SERVICOS_ADICIONAIS:
                return "Serviços";
            case COL_STATUS:
                return "Status";
            default:
                break;
        }

        return "";
    }

    public String ToStringServiceName(Set<Servicos> lstServ) {
        StringBuilder result = new StringBuilder();
        for (Servicos s : lstServ) {
            if (!s.getNomeServico().equals(Services.DIARIA)) {
                result.append(utils.ServicesToString(s.getNomeServico())).append(",");
            }
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

}
