/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;

import lombok.Data;

@Data
public class Pet {
    
    private Integer id;
    private String nome;
    private String especie;
    private String raca;
    private Integer idade;
    private String genero;
    private Double peso;
    private String infoDeSaude;
    private Proprietario Proprietario;
    
    public Pet(Integer id, String nome, String especie, String raca, Integer idade, String genero, Double peso, String infoDeSaude, Proprietario proprietario){
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.genero = genero;
        this.peso = peso;
        this.infoDeSaude = infoDeSaude;
        this.Proprietario = proprietario;
    }
    
    public Pet(){
        this.id = -1;
        this.nome = "";
        this.especie = "";
        this.raca = "";
        this.idade = 0;
        this.genero = "";
        this.peso = 0.0;
        this.infoDeSaude = "";
        this.Proprietario = null;
    }
}
