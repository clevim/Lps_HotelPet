/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities.filtros;

import lombok.Data;

/**
 *
 * @author clevs
 */
@Data
public class FiltroPet {

    
    public String nome;
    public String raca;
    public Integer proprietario_id;
    public String StatusAgendado;
    public String pesoIn;
    public String pesoOut;
    public String idadeIn;
    public String idadeOut;
    public String especie;
    
    public FiltroPet(String nome, String raça, Integer proprietario_id, String pesoIn, String pesoOut, String idadeIn, String idadeOut, String especie) {
        this.nome = nome;
        this.raca = raça;
        this.proprietario_id = proprietario_id;
        this.pesoIn = pesoIn;
        this.pesoOut = pesoOut;
        this.idadeIn = idadeIn;
        this.idadeOut = idadeOut;
        this.especie = especie;
    }
    
   public FiltroPet() {
        this.nome = "";
        this.raca = "";
        this.proprietario_id = -1;
        this.StatusAgendado = "";
        this.pesoIn = "";
        this.pesoOut = "";
        this.idadeIn = "";
        this.idadeOut = "";
        this.especie = "";
    }
    
}
