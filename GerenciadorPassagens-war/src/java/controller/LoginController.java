/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Clientes;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.ClientesFacade;
/**
 *
 * @author 09123471980
 */
@Named(value = "loginController")
@Dependent
public class LoginController {

    @EJB
    private ClientesFacade clientesFacade;
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
    
    public LoginController() {
    }
    
    public String entrar(){
       
        clientesFacade.autenticar(login, senha);
        
      return "listaCliente";
    }
    
    
}
