/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Clientes;
import java.io.IOException;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 09123471980
 */
@Stateless(mappedName="ClienteAtual")
public class ClientesFacade extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "GerenciadorPassagens-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public Clientes autenticar(String login, String senha){
        System.out.println("AUTENTICAR"+login+" "+senha);
        Query query = em.createQuery("SELECT c FROM Clientes c WHERE c.senha = :senha AND c.login = :login");
        query.setParameter("senha", senha);
        query.setParameter("login", login);
        List<Clientes> cliente = query.getResultList();
        if(cliente.isEmpty()){
            return null;
        }
        return cliente.get(0);  
    }
    
    public ClientesFacade() {
        super(Clientes.class);
    }
    
    public Clientes editar(Clientes cliente){
        Clientes cli = find(cliente.getId());
        if(!cli.getSenha().equals(cliente.getSenha()) ){
            return null;
        }else{
            super.edit(cliente);
            return cliente;
        }
    }
    
}
