/*
 * Click nbps://nbhost/SystempileSystem/Templates/Licenses/license-depault.txt to change this license
 */
package com.clevervitor.hotelpet;


import com.clevervitor.hotelpet.view.FrCadPet;
import com.clevervitor.hotelpet.view.FrLogin;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author clevs
 */
public class HotelPet {

    public static void main(String[] args) {
         FuncionarioController fC = new FuncionarioController();
        PetController petC = new PetController();
        ProprietarioController propC = new ProprietarioController();
        
        
        Funcionario f = new Funcionario();
        Proprietario p = new Proprietario();
        Pet pet = new Pet();
         Pet pet2 = new Pet();
        
        
        f.setCargo("Assitente");
        f.setCpf("1231321");
        f.setDataNasc("10-07-1998");
        f.setEmail("TEste@gmail.com");
        f.setEndereco("ENDREcO");
        f.setNivelAcesso(1);
        f.setNome("TESTEFUNC");
        f.setSalario(23.05);
        f.setSenha("123123");
       f.setSexo("MASculino");
       f.setTel("3299941632");
       f.setTurno("MAtutino");
       
       
       p.setCpf("123132132132");
       p.setDataNasc("10-05-2020");
       p.setEndereco("ENDEREco2");
       p.setNivelAcesso(2);
       p.setNome("TESTEPROP");
       p.setSenha("123123131");
       p.setSexo("Femino");
       p.setTel("32996464646");
       
       
       pet.setEspecie("Cachorro");
       pet.setIdade(10);
       pet.setNome("DOG");
       pet.setObs("Problema na coluna");
       pet.setProprietario(p);
       pet.setRaca("Salsicha");
       pet.setSexo("Nao Binario");
       
       pet2.setEspecie("gato");
       pet2.setIdade(10);
       pet2.setNome("Cat");
       pet2.setObs("felv");
       pet2.setProprietario(p);
       pet2.setRaca("Pardo");
       pet2.setSexo("Nao Binario");
       
       
        List<Pet> listP = new ArrayList<Pet>();
        
        listP.add(pet);
        listP.add(pet2);
        
        p.setPetsPossuidos(listP);
        
        
       fC.cadastrarFuncionario(f);
       
       propC.cadastrarProprietario(p);
        


      
    }
}
