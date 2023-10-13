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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Proprietario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "Proprietario", cascade = CascadeType.ALL)
    private List<Pet> petsPossuidos;

    public Proprietario() {
        super();
        this.petsPossuidos = new ArrayList<>();
    }

    public Proprietario(String nome, String endereco, String DataNasc, String sexo, String tel, String email, String cpf, String senha, Integer nivelAcesso) {
        super(nome, endereco, DataNasc, sexo, tel, email, cpf, senha, nivelAcesso);
        this.petsPossuidos = new ArrayList<>();
    }

}
