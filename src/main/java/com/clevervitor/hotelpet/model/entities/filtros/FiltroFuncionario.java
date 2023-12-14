/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities.filtros;

import com.clevervitor.hotelpet.model.enums.Sexo;
import com.clevervitor.hotelpet.model.enums.Turno;
import lombok.Data;

/**
 *
 * @author clevs
 */
@Data
public class FiltroFuncionario {

    public String nome;
    public String email;
    public String endereco;
    public String salarioIn;
    public String salarioOut;

    public FiltroFuncionario(String nome, String email, String endereco, String salarioIn, String salarioOut) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.salarioIn = salarioIn;
        this.salarioOut = salarioOut;
    }

    public FiltroFuncionario() {
        
        this.nome = "";
        this.email = "";
        this.endereco = "";
        this.salarioIn = "";
        this.salarioOut = "";
    }
    
    
}
