/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.model.entities;

import com.clevervitor.hotelpet.model.enums.Status;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    private double valor;
    private Status status;

    @OneToOne
    @JoinColumn(name = "proprietarioResp_id")
    private Proprietario proprietarioResp;

    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet PetAgendado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "agendamento_servicos", joinColumns = @JoinColumn(name = "idAgendamento", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "idServicos", referencedColumnName = "id"))
    @EqualsAndHashCode.Exclude
    private Set<Servicos> servicosAdicionais;

    public Agendamento(String dataCheckIn, String dataCheckOut, Set<Servicos> servicosAdicionais, Proprietario proprietario, Pet pets, double valor, Status status) {
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.servicosAdicionais = servicosAdicionais;
        this.proprietarioResp = proprietario;
        this.PetAgendado = pets;
        this.valor = valor;
        this.status = status;
    }

    public Agendamento() {
        this.dataCheckIn = "";
        this.dataCheckOut = "";
        this.valor = 0.0;
        this.servicosAdicionais = new HashSet<Servicos>();
        this.proprietarioResp = new Proprietario();
        this.PetAgendado = new Pet();
        this.status = Status.NULL;

    }

    public String toStringLst(List<Pet> lst) {
        String txt = "";
        for (Pet pet : lst) {
            txt += pet.getNome() + " | " + pet.getRaca();
        }
        return txt;
    }
    
//    public String toStringServicos(){
//        String txt = "";
////        for(String str : getServicosAdicionais()){
////            
////        }
//    }

}
