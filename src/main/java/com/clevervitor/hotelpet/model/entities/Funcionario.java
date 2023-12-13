/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;

import com.clevervitor.hotelpet.model.enums.Sexo;
import com.clevervitor.hotelpet.model.enums.Turno;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author clevs
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Funcionario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double salario;
    private Turno turno;

    public Funcionario() {
        super();
        this.salario = 0.0;
        this.turno = Turno.NULL;

    }

    public Funcionario(Double Salario, Turno turno) {
        this.salario = Salario;
        this.turno = turno;
    }

    public Funcionario(Double Salario, Turno turno, String nome, String endereco, String DataNasc, Sexo sexo, String tel, String email, String cpf, String senha, Integer nivelAcesso) {
        super(nome, endereco, DataNasc, sexo, tel, email, cpf, senha, nivelAcesso);
        this.salario = Salario;
        this.turno = turno;
    }

}
