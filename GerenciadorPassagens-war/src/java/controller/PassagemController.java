/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Passagem;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import model.PassagemFacade;

/**
 *
 * @author 09123471980
 */
@Named(value = "passagemController")
@ApplicationScoped
public class PassagemController {

    @EJB
    private PassagemFacade passagemFacade;
    private Passagem passagem = new Passagem();

    
    
    public PassagemController() {
    }
    
    public List<Passagem> findAll(){
        return this.passagemFacade.findAll();
    }
    
    public List<Passagem> listaDisponiveis(){
        return this.passagemFacade.listaDisponiveis(new Timestamp(System.currentTimeMillis()));
    }
    
    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }
}
