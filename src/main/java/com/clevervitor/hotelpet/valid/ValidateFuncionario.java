/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clevervitor.hotelpet.valid;

import com.clevervitor.hotelpet.exceptions.FuncionarioException;
import com.clevervitor.hotelpet.model.entities.Funcionario;

/**
 *
 * @author vitor
 */
public class ValidateFuncionario {
    public Funcionario validaCamposEntrada(Funcionario validaFuncionario){
    Funcionario funcionario = new Funcionario();

        if (validaFuncionario.getNome().isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'nome'.");
        }
        funcionario.setNome(validaFuncionario.getNome());

        if (validaFuncionario.getEndereco().isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'endereco'");
        }

        funcionario.setEndereco(validaFuncionario.getEndereco());

        if (validaFuncionario.getDataNasc().isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'Data Nascimento'");
        }

        funcionario.setDataNasc(validaFuncionario.getDataNasc());

        if (validaFuncionario.getSexo().isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'sexo'.");
        }

        if (validaFuncionario.getTel().isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'telefone'");
        }

        funcionario.setTel(validaFuncionario.getTel());

        if (validaFuncionario.getEmail() == null) {
            throw new FuncionarioException("Error - Campo vazio: 'e-mail'");
        }

        funcionario.setEmail(validaFuncionario.getEmail());

        if (validaFuncionario.getCpf().isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'cpf'");
        }

        funcionario.setCpf(validaFuncionario.getCpf());

        if (validaFuncionario.getSenha().isEmpty()) {
            throw new FuncionarioException("Error - Campo vazio: 'senha'");
        }
        funcionario.setSenha(validaFuncionario.getSenha());
        
        if (validaFuncionario.getSalario() <= 0.0){
            throw new FuncionarioException("Error - O Funcionario não possui salario?.");
        }
        funcionario.setSalario(validaFuncionario.getSalario());
        
        if (validaFuncionario.getTurno().isEmpty()){
            throw new FuncionarioException("Error - O Funcionario não possui turno?.");
        }
        funcionario.setSalario(validaFuncionario.getSalario());
        
        if (validaFuncionario.getCargo().isEmpty()){
            throw new FuncionarioException("Error - O Funcionario precisa ter um cargo!.");
        }
        funcionario.setCargo(validaFuncionario.getCargo());
        
        return funcionario;
    }
}
