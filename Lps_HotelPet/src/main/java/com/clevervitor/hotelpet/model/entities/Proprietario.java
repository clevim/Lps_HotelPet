/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Data
public class Proprietario {
    private String nome;
    private String endereco;
    private String numeroTelefone;
    private String email;
    private String documentoIdentificacao;
    private List<Pet> petsPossuidos;

    public Proprietario() {
        this.nome = "";
        this.endereco = "";
        this.numeroTelefone = "";
        this.email = "";
        this.documentoIdentificacao = "";
        this.petsPossuidos = new ArrayList<>();
    }

    public Proprietario(String nome, String endereco, String numeroTelefone, String email, String documentoIdentificacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.numeroTelefone = numeroTelefone;
        this.email = email;
        this.documentoIdentificacao = documentoIdentificacao;
        this.petsPossuidos = new ArrayList<>();
    }

}

