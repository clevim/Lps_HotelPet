/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@SequenceGenerator(name = "proprietario_id_seq", sequenceName = "proprietario_id_seq", allocationSize = 1)
public class Proprietario extends Pessoa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="proprietario_id_seq")
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

    @Override
    public String toString() {
        String txt = getNome();

        return txt;
    }
}
