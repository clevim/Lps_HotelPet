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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

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
    
    private String nomeServico;
    
    private Double valorServico;
    
    @ManyToOne
    @JoinColumn(name = "lstServicosAgendados_id")
    private Agendamento agendamentoMarcadoServices;

    public Servicos() {
    }

    public Servicos(String nomeServico, Double valorServico) {
        this.nomeServico = nomeServico;
        this.valorServico = valorServico;
    }
    
    
    
    
}
