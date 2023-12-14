/*
 * Click nbps://nbhost/SystempileSystem/Templates/Licenses/license-depault.txt to change this license
 */
package com.clevervitor.hotelpet;

import com.clevervitor.hotelpet.connection.GEmailSender;
import com.clevervitor.hotelpet.controller.FuncionarioController;
import com.clevervitor.hotelpet.controller.ServicosController;
import com.clevervitor.hotelpet.model.dao.PessoaDAO;
import com.clevervitor.hotelpet.model.entities.Funcionario;
import com.clevervitor.hotelpet.model.entities.Pessoa;
import com.clevervitor.hotelpet.model.enums.Sexo;
import com.clevervitor.hotelpet.model.enums.Turno;
import com.clevervitor.hotelpet.utils.emailBodys;
import com.clevervitor.hotelpet.utils.utils;
import com.clevervitor.hotelpet.valid.ValidateUtils;
import com.clevervitor.hotelpet.view.dialogs.DlgCadPet;
import com.clevervitor.hotelpet.view.FrLogin;
import com.clevervitor.hotelpet.view.FrMainMenuClient;

/**
 *
 * @author clevs
 */
public class HotelPet {

    public static void main(String[] args) throws Exception {
        ValidateUtils vLogin = new ValidateUtils();
        boolean b;

        FuncionarioController fC = new FuncionarioController();
        PessoaDAO pDao = new PessoaDAO();
        Funcionario f = new Funcionario();
        Pessoa p = new Pessoa();
        ServicosController sC = new ServicosController();

        //Create Func Admin
        f.setCpf("11111111111");
        f.setDataNasc("01/01/2023");
        f.setEmail("a");
        f.setEndereco("ADMIN, ADMIN");
        f.setNivelAcesso(0);
        f.setNome("ADMIN");
        f.setSalario(10000.00);
        f.setSenha("a");
        f.setSexo(Sexo.M);
        f.setTel("3299999999");
        f.setTurno(Turno.MANHA);

        p = pDao.findByEmail(f.getEmail());

        if (p == null) {
            fC.cadastrarFuncionario(f);
        }

        FrLogin TLogin = new FrLogin();
        TLogin.setTitle("Login");
        TLogin.setVisible(true);


        sC.initServicos();



//----------------------------------------Permanece no Main depois--------------------------
//----------------------------------------Inicializadores e Updates-------------------------
        utils.updateStatusAgendamento();
        utils.VerificaAniversario();

    }
}
