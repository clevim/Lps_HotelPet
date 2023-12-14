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
public class FiltroAgendamento {

    public String dataCheckIn;
    public String dataCheckOut;
    public String Servicos;
    public String Status;
    public Integer PetAgendado_id;
    public Integer PropAgendado_id;

    public FiltroAgendamento(String dataCheckIn, String dataCheckOut, Integer PetAgendado, Integer PropAgendado) {
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.Servicos = Servicos;
        this.Status = Status;
        this.PetAgendado_id = PetAgendado_id;
        this.PropAgendado_id = PropAgendado_id;
    }

    public FiltroAgendamento() {

        this.dataCheckIn = "";
        this.dataCheckOut = "";
        this.Servicos = "";
        this.Status = "";
        this.PetAgendado_id= -1;
        this.PropAgendado_id = -1;
    }

}
