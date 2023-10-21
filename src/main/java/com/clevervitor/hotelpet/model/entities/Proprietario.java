/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@Entity
public class Proprietario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pet> petsPossuidos;

    public Proprietario() {
        super();
        this.petsPossuidos = new ArrayList<>();
    }

    public Proprietario(String nome, String endereco, String dataNasc, String sexo, String tel, String email, String cpf, String senha, Integer nivelAcesso) {
        super(nome, endereco, dataNasc, sexo, tel, email, cpf, senha, nivelAcesso);
        this.petsPossuidos = new ArrayList<>();
    }

}
