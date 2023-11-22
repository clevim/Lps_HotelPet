/*
 * Click nbps://nbhost/SystempileSystem/Templates/Licenses/license-depault.txt to change this license
 */
package com.clevervitor.hotelpet;


import com.clevervitor.hotelpet.controller.FuncionarioController;
import com.clevervitor.hotelpet.model.entities.Funcionario;
import com.clevervitor.hotelpet.view.DlgCadPet;
import com.clevervitor.hotelpet.view.FrLogin;
import com.clevervitor.hotelpet.view.FrMainMenuClient;


/**
 *
 * @author clevs
 */
public class HotelPet {

    public static void main(String[] args) {
         FuncionarioController fC = new FuncionarioController();
        Funcionario f = new Funcionario();
        
        // FAZER CADASTRO
        FrLogin Tl = new FrLogin();
        Tl.setVisible(true);
 
    }
}
