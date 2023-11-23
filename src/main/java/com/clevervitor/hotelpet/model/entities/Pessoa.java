/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Data;

/**
 *
 * @author clevs
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    private String nome;
    private String endereco; // "concat cidade estado"
    private String dataNasc; // "10-12-1997"
    private String sexo;
    private String tel;
    private String email;
    private String cpf;
    private String senha;
    private Integer nivelAcesso;

    public Pessoa() {

    }

    public Pessoa(String nome, String endereco, String DataNasc, String sexo, String tel, String email, String cpf, String senha, Integer nivelAcesso) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNasc = DataNasc;
        this.sexo = sexo;
        this.tel = tel;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }
}