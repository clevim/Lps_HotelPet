/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.controller.tableModel;

import com.clevervitor.hotelpet.model.entities.Funcionario;
import com.clevervitor.hotelpet.model.entities.Pet;
import com.clevervitor.hotelpet.utils.utils;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vitor
 */
public class TMFuncionario extends AbstractTableModel {

    private List lista;

    private final int COL_NOME = 0;
    private final int COL_CPF = 1;
    private final int COL_TURNO = 2;
    private final int COL_EMAIL = 3;
    private final int COL_ENDERECO = 4;
    private final int COL_SALARIO = 5;

    public TMFuncionario(List lstFuncionarios) {
        this.lista = lstFuncionarios;
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
        Funcionario aux = new Funcionario();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Funcionario) lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_NOME:
                    return aux.getNome();
                case COL_CPF:
                    return aux.getCpf();
                case COL_EMAIL:
                    return aux.getEmail();
                case COL_ENDERECO:
                    return aux.getEndereco();
                case COL_TURNO:
                    return utils.TurnoToString(aux.getTurno());
                case COL_SALARIO:
                    return "R$ "+aux.getSalario();
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
                return "Nome do pet";
            case COL_CPF:
                return "CPF";
            case COL_EMAIL:
                return "Email";
            case COL_ENDERECO:
                return "Endereço";
            case COL_TURNO:
                return "Turno";
            case COL_SALARIO:
                return "Salario(R$)";
            default:
                break;
        }

        return "";
    }

}
