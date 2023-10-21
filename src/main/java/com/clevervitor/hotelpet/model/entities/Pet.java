/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    private String nome;
    private String especie;
    private String raca;
    private Integer idade;
    private String sexo;
    private Double peso;
    private String obs;
    
    public Pet(String nome, String especie, String raca, Integer idade, String genero, Double peso, String obs, Proprietario proprietario){
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.sexo = genero;
        this.peso = peso;
        this.obs = obs;
        this.proprietario = proprietario;
    }
    
    public Pet(){
        this.id = -1;
        this.nome = "";
        this.especie = "";
        this.raca = "";
        this.idade = 0;
        this.sexo = "";
        this.peso = 0.0;
        this.obs = "";
        this.proprietario = new Proprietario();
    }
}
