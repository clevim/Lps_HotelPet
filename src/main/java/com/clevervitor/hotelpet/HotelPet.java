/*
 * Click nbps://nbhost/SystempileSystem/Templates/Licenses/license-depault.txt to change this license
 */
package com.clevervitor.hotelpet;

import com.clevervitor.hotelpet.controller.FuncionarioController;
import com.clevervitor.hotelpet.model.entities.Funcionario;
import com.clevervitor.hotelpet.valid.ValidateUtils;
import com.clevervitor.hotelpet.view.dialogs.DlgCadPet;
import com.clevervitor.hotelpet.view.FrLogin;
import com.clevervitor.hotelpet.view.FrMainMenuClient;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author clevs
 */
public class HotelPet {

    public static void main(String[] args) {
//        ValidateUtils vLogin = new ValidateUtils();
//        boolean b = false;
//
//        FuncionarioController fC = new FuncionarioController();
//        Funcionario f = new Funcionario();
//
//        //Create Func Admin
//        f.setCargo("Admin");
//        f.setCpf("11111111111");
//        f.setDataNasc("01/01/2023");
//        f.setEmail("admin@admin.com");
//        f.setEndereco("ADMINADMIN");
//        f.setNivelAcesso(0);
//        f.setNome("ADMIN");
//        f.setSalario(10000.00);
//        f.setSenha("admin");
//        f.setSexo("Masculino");
//        f.setTel("3299999999");
//        f.setTurno("Diurno");
//
//        fC.cadastrarFuncionario(f);
//
//        try {
//            b = vLogin.validateLogin("admin@admin.com", "admin");
//        } catch (Exception ex) {
//            Logger.getLogger(HotelPet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.err.println(b);
        FrLogin TLogin = new FrLogin();
        TLogin.setTitle("Login");
        TLogin.setVisible(true);

    }
}
