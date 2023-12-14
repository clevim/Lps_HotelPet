/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities.filtros;

import lombok.Data;

/**
 *
 * @author clevs
 */
@Data
public class FiltroProprietario {

    public String nome;
    public String email;
    public String endereco;
    public String sexo;

    public FiltroProprietario(String nome, String email, String endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.sexo = sexo;
    }

    public FiltroProprietario() {
        this.nome = "";
        this.email = "";
        this.endereco = "";
        this.sexo = "";
    }

}
