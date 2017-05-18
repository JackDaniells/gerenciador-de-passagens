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
    private static Clientes cliente = new Clientes();

    private String login, senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
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
        return "listaCliente";
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
        return "listaCliente";
    }
     public String entrar(){
       
        System.out.println("Login: "+getLogin()+" Senha: "+getSenha());
        clienteFacade.autenticar(getLogin(), getSenha());
        
      return "listaPassagens";
    }
    
    
}
