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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    
    private String login, senha, senhaNova, senhaNovaVerify;

    public String getSenhaNova() {
        return senhaNova;
    }

    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }

    public String getSenhaNovaVerify() {
        return senhaNovaVerify;
    }

    public void setSenhaNovaVerify(String senhaNovaVerify) {
        this.senhaNovaVerify = senhaNovaVerify;
    }

    
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
        Session.getInstance();
        return Session.getUsuario();
    }

    public void setCliente(Clientes cliente) {
        Session.getInstance();
        Session.setUsuario(cliente);
    }
    public List<Clientes> findAll(){
        
        return this.clienteFacade.findAll();
    }
    public ClienteController() {
    }
    
    public String insert(){
        try{
            this.clienteFacade.create(this.cliente);
        }catch(Exception e){
            System.err.println(e);
        }
        return "index";
    }
    
    public void delete(Clientes cliente){
        this.clienteFacade.remove(cliente);
    }
           
    public String update(Clientes cliente){
        Clientes cli = this.clienteFacade.editar(cliente);
        if(cli == null){
            return null;
        }else{
            return "listaPassagens";
        }
    }
        
    public String entrar(){
       
        Clientes cliente = clienteFacade.autenticar(getLogin(), getSenha());
        if(cliente != null){
            Session.getInstance();
            Session.setUsuario(cliente);
            return "listaPassagens";
        } else{
            return null;
        } 
        
    }
    
    public String sair(){
       cliente = new Clientes();
       Session.getInstance();
       Session.setUsuario(cliente);
       login = "";
       senha = "";
       return "index";
    }
    
    public String editarSenha(){
        Session.getInstance();
        Clientes cliAtual = Session.getUsuario();
        if(senhaNova.equals(senhaNovaVerify) && senha.equals(cliAtual.getSenha())){
            cliAtual.setSenha(senhaNova);
            this.clienteFacade.edit(cliAtual);
            return "listaPassagens";
        }
        return null;
    }
    
    
}
