/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;

import com.clevervitor.hotelpet.model.enums.Services;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 *
 * @author clevs
 */
@Entity
@Data

public class Servicos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Services nomeServico;
    
    private Double valorServico;
    
   @ManyToMany(mappedBy = "servicosAdicionais")
   @ToString.Exclude private Set<Agendamento> agendamentoMarcadoServices = new HashSet<Agendamento>();

    public Servicos() {
        this.nomeServico = Services.NULL;
        this.valorServico = 0.0;
        
    }

    public Servicos(Services nomeServico, Double valorServico) {
        this.nomeServico = nomeServico;
        this.valorServico = valorServico;
    }
    
    
    
    
}
