/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Viagem;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import model.ViagemFacade;

/**
 *
 * @author 09123471980
 */
@Named(value = "viagemController")
@ApplicationScoped
public class ViagemController {
    
    ViagemFacade viagemFacade;

    /**
     * Creates a new instance of ViagemController
     */
    public ViagemController() {
    }
    
     public List<Viagem> findAll(){
        return this.viagemFacade.findAll();
    }
     
     public void delete(Viagem viagem){
        this.viagemFacade.remove(viagem);
     }
    
    
}
