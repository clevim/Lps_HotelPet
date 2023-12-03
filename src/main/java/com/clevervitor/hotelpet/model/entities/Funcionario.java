/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author clevs
 */
@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@SequenceGenerator(name = "funcionario_id_seq", sequenceName = "funcionario_id_seq", allocationSize = 1)
public class Funcionario extends Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="funcionario_id_seq")
    private Integer id;
    private Double salario;
    private String turno;
    private String cargo;

    public Funcionario(){
        super();
        this.salario = 0.0;
        this.turno = "";
        this.cargo = "";
        
        
    }
    
    public Funcionario(Double Salario, String turno, String cargo) {
        this.salario = Salario;
        this.turno = turno;
        this.cargo = cargo;
    }

    public Funcionario(Double Salario, String turno, String cargo, String nome, String endereco, String DataNasc, String sexo, String tel, String email, String cpf, String senha, Integer nivelAcesso) {
        super(nome, endereco, DataNasc, sexo, tel, email, cpf, senha, nivelAcesso);
        this.salario = Salario;
        this.turno = turno;
        this.cargo = cargo;
    }
    
    
    

  
    
    
}
