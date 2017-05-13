/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Clientes;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.ClientesFacade;


/**
 *
 * @author Matheus
 */
@Named(value = "clienteController")
@SessionScoped
public class ClienteController implements Serializable {

   
    @EJB
    private ClientesFacade clienteFacade;
    private Clientes cliente = new Clientes();

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    public List<Clientes> findAll(){
        return this.clienteFacade.findAll();
    }
    public ClienteController() {
    }
    
    public String insert(){
        try{
            this.clienteFacade.create(cliente);
        }catch(Exception e){
            System.err.println(e);
        }
        this.cliente = new Clientes();
        return "index";
    }
    
    public void delete(Clientes cliente){
        this.clienteFacade.remove(cliente);
    }
    
    public String update(Clientes cliente){
        this.cliente = cliente;
        return "update";
    }
    
    public String update(){
        this.clienteFacade.edit(cliente);
        this.cliente = new Clientes();
        return "index";
    }
    
}
