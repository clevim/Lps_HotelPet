/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;

import java.util.ArrayList;
import java.util.List;
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
    
    @OneToOne
    @JoinColumn(name = "proprietarioResp_id")
    private Proprietario proprietarioResp;
    
    
    
    @OneToMany(mappedBy = "agendamentoMarcado", fetch = FetchType.EAGER)
    private List<Pet> lstPetsAgendados;
    
    public Agendamento (String dataCheckIn, String dataCheckOut, String servicosAdicionais,Proprietario proprietario, List<Pet> pets){
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.servicosAdicionais = servicosAdicionais;
        this.proprietarioResp = proprietario;
        this.lstPetsAgendados = pets;
    }
    
    public Agendamento (){
        this.dataCheckIn = "";
        this.dataCheckOut = "";
        this.servicosAdicionais = "";
        this.proprietarioResp = new Proprietario();
        this.lstPetsAgendados = new ArrayList<>();
    }
    
    
    public String toStringLst(List<Pet> lst) {
        String txt = "";
        for (Pet pet : lst) {
            txt += pet.getNome() + " | " + pet.getRaca();
        }
        return txt;
    }
    
}
