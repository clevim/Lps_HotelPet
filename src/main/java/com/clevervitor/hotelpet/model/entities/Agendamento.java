/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author vitor
 */
@Entity
@Data
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String dataCheckIn;
    private String dataCheckOut;
    private String servicosAdicionais;
    
    
    @OneToOne(mappedBy = "agendamentoMarcado")
    @JoinColumn(name = "agendamento_id")
    private Pet petAgendado;
    
    public Agendamento (String dataCheckIn, String dataCheckOut, String servicosAdicionais, Pet petAgendado){
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.servicosAdicionais = servicosAdicionais;
        this.petAgendado = petAgendado;
    }
    
    public Agendamento (){
        this.dataCheckIn = "";
        this.dataCheckOut = "";
        this.servicosAdicionais = "";
        this.petAgendado = new Pet();
    }
    
    
}
