/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @ManyToOne
    @JoinColumn(name ="prorpietario_id")
    private Proprietario proprietario;
    
    @ManyToOne
    @JoinColumn(name ="pet_id")
    private Agendamento agendamentoMarcado;
    
    public Pet(String nome, String especie, String raca, Integer idade, String genero, Double peso, String obs, Proprietario dono){
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.sexo = genero;
        this.peso = peso;
        this.obs = obs;
        this.proprietario = dono;

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
