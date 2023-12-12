/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.connection;

import com.clevervitor.hotelpet.model.entities.Pessoa;

/**
 *
 * @author clevs
 */
public class loginContexto {
    private static loginContexto instancia = null;
    private Pessoa pessoaLogada;

    private loginContexto() {
        // Inicialização de atributos, se necessário
    }

    public static loginContexto getInstance() {
        if (instancia == null) {
            instancia = new loginContexto();
        }
        return instancia;
    }

    public Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public void setPessoaLogada(Pessoa pessoa) {
        this.pessoaLogada = pessoa;
    }
}
